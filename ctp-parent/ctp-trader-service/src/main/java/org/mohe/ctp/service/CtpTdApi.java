package org.mohe.ctp.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.mohe.ctp.dto.AccountDTO;
import org.mohe.ctp.dto.ErrorDTO;
import org.mohe.ctp.dto.OrderDTO;
import org.mohe.ctp.dto.PositionDTO;
import org.mohe.ctp.entity.ErrorInfo;
import org.mohe.ctp.enums.THOST_TE_RESUME_TYPE;
import org.mohe.ctp.enums.ThostFtdcDirectionType;
import org.mohe.ctp.service.sequence.EnumSeqType;
import org.mohe.ctp.service.sequence.SequenceService;
import org.mohe.ctp.service.td.GatewayService;
import org.mohe.ctp.service.td.InstrumentService;

import cn.yiwang.ctp.CThostFtdcTraderApi;
import cn.yiwang.ctp.CThostFtdcTraderSpi;
import cn.yiwang.ctp.struct.CTPExchange;
import cn.yiwang.ctp.struct.CTPInputOrder;
import cn.yiwang.ctp.struct.CTPInputOrderAction;
import cn.yiwang.ctp.struct.CTPInstrument;
import cn.yiwang.ctp.struct.CTPInstrumentCommissionRate;
import cn.yiwang.ctp.struct.CTPInstrumentMarginRate;
import cn.yiwang.ctp.struct.CTPInvestorPosition;
import cn.yiwang.ctp.struct.CTPInvestorPositionDetail;
import cn.yiwang.ctp.struct.CTPOrder;
import cn.yiwang.ctp.struct.CTPOrderAction;
import cn.yiwang.ctp.struct.CTPQryInstrument;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfo;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTrade;
import cn.yiwang.ctp.struct.CTPTradingAccount;
import cn.yiwang.ctp.struct.CTPUserLogout;

public class CtpTdApi implements CThostFtdcTraderSpi {

	private final static Logger logger = Logger.getLogger(CtpTdApi.class);

	private CThostFtdcTraderApi tdApi;

	private GatewayService gateway;

	private SequenceService sequenceService;

	private InstrumentService instrumentService;

	private int frontId;
	private int sessionId;
	private boolean isConnected;
	private boolean isLogined;

	private String userId;
	private String password;
	private String brokerId;
	private String address;
	private String flowPath;

	private boolean dbCached;
	
	private int maxOrderRef;

	public CtpTdApi(GatewayService gateway) {
		isConnected = false;
		isLogined = false;
		this.gateway = gateway;
	}

	public boolean isDbCached() {
		return dbCached;
	}

	public void setDbCached(boolean dbCached) {
		this.dbCached = dbCached;
	}

	public String getFlowPath() {
		return flowPath;
	}

	public void setFlowPath(String flowPath) {
		this.flowPath = flowPath;
	}

	public SequenceService getSequenceService() {
		return sequenceService;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	public InstrumentService getInstrumentService() {
		return instrumentService;
	}

	public void setInstrumentService(InstrumentService instrumentService) {
		this.instrumentService = instrumentService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void onFrontConnected() {
		isConnected = true;
		logger.info("交易服务器连接成功");
		login();
	}

	public void onFrontDisconnected(int reason) {
		isConnected = false;
		isLogined = false;
		logger.info("交易服务器连接断开");
	}

	public void onHeartBeatWarning(int timeLapse) {

	}

	public void onRspUserLogin(CTPRspUserLogin rspUserLogin,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		if (rspInfo.ErrorID == 0) {
			frontId = rspUserLogin.FrontID;
			sessionId = rspUserLogin.SessionID;
			isLogined = true;

			logger.info("交易服务器登录完成");
			// 确认计算信息
			CTPSettlementInfoConfirm settlementInfoConfirm = new CTPSettlementInfoConfirm();
			settlementInfoConfirm.BrokerID = brokerId;
			settlementInfoConfirm.InvestorID = userId;
			tdApi.reqSettlementInfoConfirm(settlementInfoConfirm,
					sequenceService.getSequence(EnumSeqType.REQUEST));

		} else {
			logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
			if (gateway != null) {
				ErrorDTO error = new ErrorDTO();
				error.setErrorNo(rspInfo.ErrorID);
				error.setErrorMsg(rspInfo.ErrorMsg);
				gateway.onError(error);
			}
		}
	}

	public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {

	}

	public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast) {
		logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
		if (gateway != null) {
			ErrorDTO error = new ErrorDTO();
			error.setErrorNo(rspInfo.ErrorID);
			error.setErrorMsg(rspInfo.ErrorMsg);
			gateway.onError(error);
		}
	}

	public void onRspQryExchange(CTPExchange exchange, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {

	}

	public void onRspQryInstrument(CTPInstrument instrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

		//保存合约
	}

	public void onRspQryInvestorPosition(CTPInvestorPosition investorPosition,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		String positionName = investorPosition.InstrumentID + "."
				+ investorPosition.PosiDirection;
		
		PositionDTO position = new PositionDTO();
		
		this.gateway.onPosition(position);
	}

	public void onRspQryTradingAccount(CTPTradingAccount tradingAccount,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		AccountDTO account = new AccountDTO();
		account.setGatewayName(gateway.getGatewayName());

		account.setAccountId(tradingAccount.AccountID);
		account.setVtAccountId(account.getGatewayName() + "."
				+ account.getAccountId());

		account.setPreBalance(tradingAccount.PreBalance);
		account.setAvailable(tradingAccount.Available);
		account.setCommission(tradingAccount.Commission);
		account.setMargin(tradingAccount.CurrMargin);
		account.setCloseProfit(tradingAccount.CloseProfit);
		account.setPositionProfit(tradingAccount.PositionProfit);

		BigDecimal preBalance = BigDecimal.valueOf(tradingAccount.PreBalance);
		BigDecimal preCredit = BigDecimal.valueOf(tradingAccount.PreCredit);
		BigDecimal preMortgage = BigDecimal.valueOf(tradingAccount.PreMortgage);
		BigDecimal mortgage = BigDecimal.valueOf(tradingAccount.Mortgage);
		BigDecimal withdraw = BigDecimal.valueOf(tradingAccount.Withdraw);
		BigDecimal deposit = BigDecimal.valueOf(tradingAccount.Deposit);
		BigDecimal closeProfit = BigDecimal.valueOf(tradingAccount.CloseProfit);
		BigDecimal positionProfit = BigDecimal
				.valueOf(tradingAccount.PositionProfit);
		BigDecimal cashIn = BigDecimal.valueOf(tradingAccount.CashIn);
		BigDecimal commission = BigDecimal.valueOf(tradingAccount.Commission);

		float balbance = preBalance.subtract(preCredit).subtract(preMortgage)
				.add(mortgage).subtract(withdraw).add(deposit).add(closeProfit)
				.add(positionProfit).add(cashIn).subtract(commission)
				.floatValue();

		account.setBalance(balbance);
		this.gateway.onAccount(account);
	}

	public void onRspOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
		if (gateway != null) {
			ErrorDTO error = new ErrorDTO();
			error.setErrorNo(rspInfo.ErrorID);
			error.setErrorMsg(rspInfo.ErrorMsg);
			gateway.onError(error);
		}
	}

	public void onErrRtnOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo) {

	}

	public void onRtnOrder(CTPOrder order) {
		Integer newOrderRef = Integer.valueOf(order.OrderRef);
		maxOrderRef = Math.max(maxOrderRef, newOrderRef);
		OrderDTO orderDto = new OrderDTO();
		orderDto.setGatewayName(gateway.getGatewayName());
		orderDto.setSymbol(order.InvestorID);
		orderDto.setExchange(order.ExchangeID);
		orderDto.setVtSymbol(orderDto.getSymbol());
		orderDto.setOrderId(order.OrderRef);
		orderDto.setDirection(String.valueOf(order.Direction));
		orderDto.setOffset(order.CombOffsetFlag);
		orderDto.setStatus(String.valueOf(order.OrderStatus));
		
		orderDto.setPrice(order.LimitPrice);
		orderDto.setTotalVolume(order.VolumeTotalOriginal);
		orderDto.setTradedVolume(order.VolumeTraded);
		orderDto.setOrderTime(order.InsertTime);
		orderDto.setCancelTime(order.CancelTime);
		
		orderDto.setFrontId(order.FrontID);
		orderDto.setSessionId(order.SessionID);
		orderDto.setVtOrderId(gateway.getGatewayName()+"."+ order.OrderRef);
		gateway.onOrder(orderDto);
	}

	public void onRtnTrade(CTPTrade trade) {

	}

	public void onRspOrderAction(CTPInputOrderAction inputOrderAction,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
		if (gateway != null) {
			ErrorDTO error = new ErrorDTO();
			error.setErrorNo(rspInfo.ErrorID);
			error.setErrorMsg(rspInfo.ErrorMsg);
			gateway.onError(error);
		}
	}

	public void onErrRtnOrderAction(CTPOrderAction orderAction,
			CTPRspInfo rspInfo) {

	}

	public void onRspQrySettlementInfoConfirm(
			CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {

	}

	public void onRspSettlementInfoConfirm(
			CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		logger.info("结算信息确认完成");
		// 查询合约代码
		CTPQryInstrument qryInstrument = new CTPQryInstrument();
		tdApi.reqQryInstrument(qryInstrument,
				sequenceService.getSequence(EnumSeqType.REQUEST));
	}

	public void onRspQrySettlementInfo(CTPSettlementInfo settlementInfo,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRspQryInstrumentMarginRate(
			CTPInstrumentMarginRate instrumentMarginRate, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {

	}

	public void onRspQryInstrumentCommissionRate(
			CTPInstrumentCommissionRate instrumentCommissionRate,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRspQryInvestorPositionDetail(
			CTPInvestorPositionDetail investorPositionDetail,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void login() {
		CTPReqUserLogin reqUserLogin = new CTPReqUserLogin();
		reqUserLogin.UserID = userId;
		reqUserLogin.BrokerID = brokerId;
		reqUserLogin.Password = password;
		tdApi.reqUserLogin(reqUserLogin,
				sequenceService.getSequence(EnumSeqType.REQUEST));
	}

	public void connect() {
		if (isConnected) {
			if (!isLogined) {
				login();
			}
		} else {
			File file = new File(flowPath);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			tdApi = new CThostFtdcTraderApi();
			tdApi.createFtdcTraderApi(flowPath);
			tdApi.registerFront(address);
			tdApi.subscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK
					.getCode());
			tdApi.subscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESUME
					.getCode());
			tdApi.registerSpi(this);
			tdApi.init();
			tdApi.join();
		}
	}

}

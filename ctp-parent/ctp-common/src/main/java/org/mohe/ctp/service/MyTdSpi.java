package org.mohe.ctp.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.mohe.ctp.entity.Account;
import org.mohe.ctp.entity.CancelOrderReq;
import org.mohe.ctp.entity.Contract;
import org.mohe.ctp.entity.ErrorDTO;
import org.mohe.ctp.entity.Order;
import org.mohe.ctp.entity.OrderReq;
import org.mohe.ctp.entity.Position;
import org.mohe.ctp.entity.Trade;
import org.mohe.ctp.enums.THOST_TE_RESUME_TYPE;
import org.mohe.ctp.enums.ThostFtdcActionFlagType;
import org.mohe.ctp.enums.ThostFtdcContingentConditionType;
import org.mohe.ctp.enums.ThostFtdcDirectionType;
import org.mohe.ctp.enums.ThostFtdcForceCloseReasonType;
import org.mohe.ctp.enums.ThostFtdcHedgeFlagEnType;
import org.mohe.ctp.enums.ThostFtdcTimeConditionType;
import org.mohe.ctp.enums.ThostFtdcVolumeConditionType;
import org.mohe.ctp.gateway.Gateway;
import org.springframework.util.StringUtils;

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
import cn.yiwang.ctp.struct.CTPQryInvestorPosition;
import cn.yiwang.ctp.struct.CTPQryTradingAccount;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfo;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTrade;
import cn.yiwang.ctp.struct.CTPTradingAccount;
import cn.yiwang.ctp.struct.CTPUserLogout;

public class MyTdSpi implements CThostFtdcTraderSpi {
	private final static Logger logger = Logger.getLogger(MyTdSpi.class);
	
	private CThostFtdcTraderApi tdApi;

	private Gateway gateway;

	private final AtomicInteger reqId = new AtomicInteger();
	
	private final AtomicInteger orderId = new AtomicInteger();


	private int frontId;
	private int sessionId;
	private boolean isConnected;
	private boolean isLogined;
	
	private String userId;
	private String brokerId;
	private String password;
	private int maxOrderRef;

	public MyTdSpi(Gateway gateway) {
		isConnected = false;
		isLogined = false;
		this.gateway = gateway;
	}




	public void onFrontConnected() {
		isConnected = true;
		logger.info("交易服务器连接成功");
		login();
		gateway.setTdConnected(true);
	}

	public void onFrontDisconnected(int reason) {
		isConnected = false;
		isLogined = false;
		logger.info("交易服务器连接断开");
		gateway.setTdConnected(false);
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
			tdApi.reqSettlementInfoConfirm(settlementInfoConfirm, reqId.getAndIncrement());

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
		//logger.info("合约查询"+ instrument.InstrumentID);
		//保存合约
		Contract contract = new Contract();
		contract.setGatewayName(gateway.getGatewayName());
		contract.setSymbol(instrument.InstrumentID);
		contract.setExchange(instrument.ExchangeID);
		contract.setVtSymbol(contract.getSymbol());
		contract.setName(contract.getName());
		contract.setSize(instrument.VolumeMultiple);
		contract.setPriceTick(instrument.PriceTick);
		contract.setStrikePrice(instrument.StrikePrice);
		contract.setUnderlyingSymbol(instrument.UnderlyingInstrID);
		contract.setProductClass(String.valueOf(instrument.ProductClass));
		contract.setOptionType(String.valueOf(instrument.OptionsType));
		gateway.onContract(contract);
	}

	public void onRspQryInvestorPosition(CTPInvestorPosition investorPosition,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		String positionName = investorPosition.InstrumentID + "."
				+ investorPosition.PosiDirection;
		
		Position position = new Position();
		position.setGatewayName(gateway.getGatewayName());
		
		position.setSymbol(investorPosition.InstrumentID);
		position.setVtSymbol(investorPosition.InstrumentID);
		
		position.setDirection(String.valueOf(investorPosition.PosiDirection));
		if(ThostFtdcDirectionType.THOST_FTDC_D_Buy.getCode() == investorPosition.PosiDirection ){
			position.setFrozen(investorPosition.LongFrozen);
		}else
			position.setFrozen(investorPosition.ShortFrozen);
		
		position.setPosition(investorPosition.Position);
		position.setYdPosition(investorPosition.YdPosition);
		
		if(position.getPosition() > 0){
			position.setPrice(investorPosition.PositionCost/investorPosition.Position);
		}
		position.setVtPositionName(positionName);
		this.gateway.onPosition(position);
	}

	public void onRspQryTradingAccount(CTPTradingAccount tradingAccount,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		Account account = new Account();
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
		if(!StringUtils.hasText(order.OrderRef)){
			return;
		}
		Integer newOrderRef = Integer.valueOf(order.OrderRef);
		maxOrderRef = Math.max(maxOrderRef, newOrderRef);
		Order orderDto = new Order();
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
		if(!StringUtils.hasText(trade.TradeID)){
			return;
		}
		Trade tradeDto = new Trade();
		tradeDto.setGatewayName(gateway.getGatewayName());
		tradeDto.setSymbol(trade.InstrumentID);
		tradeDto.setExchange(trade.ExchangeID);
		tradeDto.setVtSymbol(trade.ExchangeInstID);
		
		tradeDto.setTradeId(trade.TradeID);
		tradeDto.setVtTradeId(gateway.getGatewayName()+"."+trade.TradeID);
		
		tradeDto.setOrderId(trade.OrderRef);
		tradeDto.setVtOrderId(gateway.getGatewayName()+"."+trade.OrderRef);
		
		tradeDto.setDirection(String.valueOf(trade.Direction));
		tradeDto.setOffset(String.valueOf(trade.OffsetFlag));
		
		tradeDto.setPrice(trade.Price);
		tradeDto.setVolume(trade.Volume);
		tradeDto.setTradeTime(trade.TradeTime);
		
		gateway.onTrade(tradeDto);
		
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
		tdApi.reqQryInstrument(qryInstrument,reqId.getAndIncrement());
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
		tdApi.reqUserLogin(reqUserLogin,reqId.getAndIncrement());
	}

	public void connect(String flowPath, String frontAddress, String userId, String brokerId, String password) {
		this.userId = userId;
		this.brokerId = brokerId;
		this.password = password;
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
			tdApi.registerFront(frontAddress);
			tdApi.subscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK
					.getCode());
			tdApi.subscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESUME
					.getCode());
			tdApi.registerSpi(this);
			tdApi.init();
		}
	}
	
	
	public void qryAccount(){
		CTPQryTradingAccount qryTradingAccount = new CTPQryTradingAccount();
		tdApi.reqQryTradingAccount(qryTradingAccount , reqId.getAndIncrement());
	}
	
	public void qryPosition(){
		CTPQryInvestorPosition qryInvestorPosition = new CTPQryInvestorPosition();
		qryInvestorPosition.BrokerID = brokerId;
		qryInvestorPosition.InvestorID = userId;
		tdApi.reqQryInvestorPosition(qryInvestorPosition , reqId.getAndIncrement());
	}

	public String sendOrder(OrderReq orderReq){
		
		int orderRef = orderId.getAndIncrement();
		
		CTPInputOrder inputOrder = new CTPInputOrder();
		inputOrder.InstrumentID = orderReq.getSymbol();
		inputOrder.LimitPrice = orderReq.getPrice();
		inputOrder.VolumeTotalOriginal = orderReq.getVolume();
		
		inputOrder.OrderPriceType = orderReq.getPriceType().getCode();
		inputOrder.Direction = orderReq.getDirection().getCode();
		inputOrder.CombOffsetFlag = String.valueOf(orderReq.getOffset().getCode());
		
		inputOrder.OrderRef = String.valueOf(orderRef);
		inputOrder.InvestorID = userId;
		inputOrder.UserID = userId;
		inputOrder.BrokerID = brokerId;
		inputOrder.CombHedgeFlag = String.valueOf(ThostFtdcHedgeFlagEnType.THOST_FTDC_HFEN_Speculation.getCode());
		inputOrder.ContingentCondition = ThostFtdcContingentConditionType.THOST_FTDC_CC_Immediately.getCode();
		inputOrder.ForceCloseReason = ThostFtdcForceCloseReasonType.THOST_FTDC_FCC_NotForceClose.getCode();
		
		inputOrder.IsAutoSuspend = 0;
		inputOrder.TimeCondition = ThostFtdcTimeConditionType.THOST_FTDC_TC_GFD.getCode();
		inputOrder.VolumeCondition = ThostFtdcVolumeConditionType.THOST_FTDC_VC_AV.getCode();
		inputOrder.MinVolume = 1;

		tdApi.reqOrderInsert(inputOrder , reqId.getAndIncrement());
		return gateway.getGatewayName()+"."+orderRef;
	}
	
	public void cancelOrder(CancelOrderReq cancelOrderReq){
		
		CTPInputOrderAction inputOrderAction = new CTPInputOrderAction();
		inputOrderAction.InstrumentID = cancelOrderReq.getSymbol();
		inputOrderAction.ExchangeID = cancelOrderReq.getExchange();
		inputOrderAction.OrderRef = cancelOrderReq.getOrderId();
		inputOrderAction.FrontID = frontId;//cancelOrderReq.getFrontId();
		inputOrderAction.SessionID = sessionId;//cancelOrderReq.getSessionId();
		
		inputOrderAction.ActionFlag = ThostFtdcActionFlagType.THOST_FTDC_AF_Delete.getCode();
		inputOrderAction.BrokerID = brokerId;
		inputOrderAction.InvestorID = userId;
		tdApi.reqOrderAction(inputOrderAction , reqId.getAndIncrement());
	}
	
	
	public void destroy(){
		if(tdApi != null){
			tdApi.release();
		}
	}
}

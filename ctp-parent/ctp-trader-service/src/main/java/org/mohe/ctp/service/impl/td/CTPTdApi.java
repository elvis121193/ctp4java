package org.mohe.ctp.service.impl.td;

import org.apache.log4j.Logger;
import org.mohe.ctp.service.sequence.EnumSeqType;
import org.mohe.ctp.service.sequence.SequenceService;

import cn.yiwang.ctp.CThostFtdcTraderApi;
import cn.yiwang.ctp.CThostFtdcTraderSpi;
import cn.yiwang.ctp.struct.CTPConst;
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
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfo;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTrade;
import cn.yiwang.ctp.struct.CTPTradingAccount;
import cn.yiwang.ctp.struct.CTPUserLogout;

public final class CTPTdApi implements CThostFtdcTraderSpi{
	
	private final static Logger logger = Logger.getLogger(CTPTdApi.class);
	
	private boolean isConnected;
	
	private boolean isLogined;
	
	private String brokerId;
	
	private String password;
	
	private String userId;
	
	private String frontAddress;
	
	private String flowPath;
	
	private int frontId;
	
	private int sessionId;
	
	
	private CThostFtdcTraderApi tdApi;
	
	private SequenceService sequenceService;
	
	

	
	public SequenceService getSequenceService() {
		return sequenceService;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	public String getFlowPath() {
		return flowPath;
	}

	public void setFlowPath(String flowPath) {
		this.flowPath = flowPath;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFrontAddress() {
		return frontAddress;
	}

	public void setFrontAddress(String frontAddress) {
		this.frontAddress = frontAddress;
	}

	public void onFrontConnected() {
		logger.info("交易服务器连接成功");
		isConnected = true;
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
		if(rspInfo.ErrorID == 0){
			logger.info("交易服务器登录完成");
			isLogined = true;
			frontId = rspUserLogin.FrontID;
			sessionId = rspUserLogin.SessionID;
			//确认结算信息
			CTPSettlementInfoConfirm settlementInfoConfirm = new CTPSettlementInfoConfirm();
			settlementInfoConfirm.BrokerID = brokerId;
			settlementInfoConfirm.InvestorID = userId;
			tdApi.reqSettlementInfoConfirm(settlementInfoConfirm, requestID);
		}else
			logger.error("登录错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
		
	}

	public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		if(rspInfo.ErrorID == 0){
			logger.info("交易服务器登出完成");
			isLogined = false;
		}else
			logger.error("登录错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
	}

	public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast) {
		logger.error("错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
	}

	public void onRspQryExchange(CTPExchange exchange, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		
	}

	public void onRspQryInstrument(CTPInstrument instrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		
	}

	public void onRspQryInvestorPosition(CTPInvestorPosition investorPosition,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		
	}

	public void onRspQryTradingAccount(CTPTradingAccount tradingAccount,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		
	}

	public void onRspOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		logger.error(rspInfo.ErrorID + " : " + rspInfo.ErrorMsg);
	}

	public void onErrRtnOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo) {
		logger.error(rspInfo.ErrorID + " : " + rspInfo.ErrorMsg);
	}

	public void onRtnOrder(CTPOrder order) {
		
	}

	public void onRtnTrade(CTPTrade trade) {
		
	}

	public void onRspOrderAction(CTPInputOrderAction inputOrderAction,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		
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
	
	private void login(){
		CTPReqUserLogin reqUserLogin = new CTPReqUserLogin();
		reqUserLogin.BrokerID = brokerId;
		reqUserLogin.Password = password;
		reqUserLogin.UserID = userId;
		tdApi.reqUserLogin(reqUserLogin, sequenceService.getSequence(EnumSeqType.REQUEST));
		
	}
	
	public void connect(){
		tdApi = new CThostFtdcTraderApi();
		tdApi.createFtdcTraderApi(flowPath);
		tdApi.subscribePrivateTopic(CTPConst.THOST_TERT_QUICK);
		tdApi.subscribePublicTopic(CTPConst.THOST_TERT_RESUME);
		tdApi.registerSpi(this);
		tdApi.registerFront(frontAddress);
		tdApi.init();
		tdApi.join();
	}

}

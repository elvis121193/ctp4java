package org.mohe.ctp.service.impl.td;

import org.apache.log4j.Logger;

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
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfo;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTrade;
import cn.yiwang.ctp.struct.CTPTradingAccount;
import cn.yiwang.ctp.struct.CTPUserLogout;

public class TraderSpi implements CThostFtdcTraderSpi{
	
	private final static Logger logger = Logger.getLogger(TraderSpi.class);
	
	private CThostFtdcTraderApi tdApi;

	public void onFrontConnected() {
		// TODO Auto-generated method stub
		
	}

	public void onFrontDisconnected(int reason) {
		// TODO Auto-generated method stub
		
	}

	public void onHeartBeatWarning(int timeLapse) {
		// TODO Auto-generated method stub
		
	}

	public void onRspUserLogin(CTPRspUserLogin rspUserLogin,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryExchange(CTPExchange exchange, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryInstrument(CTPInstrument instrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryInvestorPosition(CTPInvestorPosition investorPosition,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryTradingAccount(CTPTradingAccount tradingAccount,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onErrRtnOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo) {
		// TODO Auto-generated method stub
		
	}

	public void onRtnOrder(CTPOrder order) {
		// TODO Auto-generated method stub
		
	}

	public void onRtnTrade(CTPTrade trade) {
		// TODO Auto-generated method stub
		
	}

	public void onRspOrderAction(CTPInputOrderAction inputOrderAction,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onErrRtnOrderAction(CTPOrderAction orderAction,
			CTPRspInfo rspInfo) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQrySettlementInfoConfirm(
			CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspSettlementInfoConfirm(
			CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQrySettlementInfo(CTPSettlementInfo settlementInfo,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryInstrumentMarginRate(
			CTPInstrumentMarginRate instrumentMarginRate, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryInstrumentCommissionRate(
			CTPInstrumentCommissionRate instrumentCommissionRate,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

	public void onRspQryInvestorPositionDetail(
			CTPInvestorPositionDetail investorPositionDetail,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		// TODO Auto-generated method stub
		
	}

}

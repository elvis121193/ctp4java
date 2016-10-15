package org.mohe.ctp.dto;

import cn.yiwang.ctp.struct.CTPConst;

public class ReqCancelOrder {

	private String instrumentId;
	
	private String exchangeId;
	
	private int orderRef;
	
	private int frontId;
	
	private int sessionId;
	
	private String brokerId;
	
	private String investorId;
	
	
	public char getActionFlag() {
		return CTPConst.THOST_FTDC_AF_Delete;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public int getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(int orderRef) {
		this.orderRef = orderRef;
	}

	public int getFrontId() {
		return frontId;
	}

	public void setFrontId(int frontId) {
		this.frontId = frontId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getInvestorId() {
		return investorId;
	}

	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}
	
	
}

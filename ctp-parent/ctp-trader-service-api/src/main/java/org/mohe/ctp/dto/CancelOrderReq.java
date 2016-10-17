package org.mohe.ctp.dto;

public class CancelOrderReq {

	private String symbol;
	
	private String exchange;
	
	private String orderId;
	
	private int frontId;
	
	private int sessionId;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	
}

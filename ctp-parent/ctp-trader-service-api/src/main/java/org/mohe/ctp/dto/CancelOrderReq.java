package org.mohe.ctp.dto;

public class CancelOrderReq {

	private String symbol;
	
	private String exchange;
	
	private String orderId;
	
	private String frontId;
	
	private String sessionId;

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

	public String getFrontId() {
		return frontId;
	}

	public void setFrontId(String frontId) {
		this.frontId = frontId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}

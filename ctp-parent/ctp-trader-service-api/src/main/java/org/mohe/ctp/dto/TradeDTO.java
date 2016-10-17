package org.mohe.ctp.dto;

import java.io.Serializable;

public class TradeDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 997735187212097112L;

	/**
	 * 合约代码
	 */
	private String symbol;
	
	/**
	 * 交易所代码
	 */
	private String exchange;
	
	/**
	 * 合约在系统中的唯一代码，通常是 合约代码.交易所代码
	 */
	private String vtSymbol;
	
	/**
	 * 成交编号
	 */
	private String tradeId;
	
	/**
	 * 成交在系统中的唯一编号，通常是 Gateway名.成交编号
	 */
	private String vtTradeId;
	
	/**
	 * 订单编号
	 */
	private String orderId;
	
	/**
	 * 订单在系统中的唯一编号，通常是 Gateway名.订单编号
	 */
	private String vtOrderId;
	
	/**
	 * 成交方向
	 */
	private String direction;
	
	/**
	 * 成交开平仓
	 */
	private String offset;
	
	/**
	 * 成交价格
	 */
	private float price;
	
	/**
	 * 成交数量
	 */
	private int volume;
	
	/**
	 * 成交时间
	 */
	private String tradeTime;

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

	public String getVtSymbol() {
		return vtSymbol;
	}

	public void setVtSymbol(String vtSymbol) {
		this.vtSymbol = vtSymbol;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getVtTradeId() {
		return vtTradeId;
	}

	public void setVtTradeId(String vtTradeId) {
		this.vtTradeId = vtTradeId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getVtOrderId() {
		return vtOrderId;
	}

	public void setVtOrderId(String vtOrderId) {
		this.vtOrderId = vtOrderId;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDTO [symbol=");
		builder.append(symbol);
		builder.append(", exchange=");
		builder.append(exchange);
		builder.append(", vtSymbol=");
		builder.append(vtSymbol);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", vtTradeId=");
		builder.append(vtTradeId);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", vtOrderId=");
		builder.append(vtOrderId);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", offset=");
		builder.append(offset);
		builder.append(", price=");
		builder.append(price);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", tradeTime=");
		builder.append(tradeTime);
		builder.append("]");
		return builder.toString();
	}
	
	
}

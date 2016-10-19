package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trade extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 997735187212097112L;

	/**
	 * 合约代码
	 */
	private String symbol;
	
	/**
	 * 成交编号
	 */
	@Id
	private String tradeId;
	
	
	/**
	 * 订单编号
	 */
	private String orderId;
	
	
	/**
	 * 成交方向
	 */
	private char direction;
	
	/**
	 * 成交开平仓
	 */
	private char offset;
	
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

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public char getOffset() {
		return offset;
	}

	public void setOffset(char offset) {
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
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", orderId=");
		builder.append(orderId);
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

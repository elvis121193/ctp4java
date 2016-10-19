package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5989290588565851765L;

	/**
	 * 合约代码
	 */
	private String symbol;

	
	/**
	 * 订单编号
	 */
	@Id
	private String orderId;
	
	
	/**
	 * 报单方向
	 */
	private char direction;
	
	/**
	 * 报单开平仓
	 */
	private String offset;
	
	/**
	 * 报单价格
	 */
	private float price;
	
	/**
	 * 报单总数量
	 */
	private int totalVolume;
	
	/**
	 * 报单成交数量
	 */
	private int tradedVolume;
	
	/**
	 *  报单状态
	 */
	private char status;
	
	/**
	 * 发单时间
	 */
	private String orderTime;
	
	/**
	 * 撤单时间
	 */
	private String cancelTime;
	
	/**
	 * 前置机编号
	 */
	private int frontId;
	
	/**
	 *  连接编号
	 */
	private int sessionId;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public int getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}

	public int getTradedVolume() {
		return tradedVolume;
	}

	public void setTradedVolume(int tradedVolume) {
		this.tradedVolume = tradedVolume;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [symbol=");
		builder.append(symbol);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", offset=");
		builder.append(offset);
		builder.append(", price=");
		builder.append(price);
		builder.append(", totalVolume=");
		builder.append(totalVolume);
		builder.append(", tradedVolume=");
		builder.append(tradedVolume);
		builder.append(", status=");
		builder.append(status);
		builder.append(", orderTime=");
		builder.append(orderTime);
		builder.append(", cancelTime=");
		builder.append(cancelTime);
		builder.append(", frontId=");
		builder.append(frontId);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}
	
	
}

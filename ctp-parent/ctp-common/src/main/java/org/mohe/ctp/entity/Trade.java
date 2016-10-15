package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6847463754729467327L;

	@Id
	private String id;
	
	private String brokerID;

	private String investorID;

	private String instrumentID;

	private String orderRef;

	private String userID;

	private String exchangeID;

	private String tradeID;

	private char direction;

	private String orderSysID;

	private String participantID;

	private String clientID;

	private char tradingRole;

	private String exchangeInstID;

	private char offsetFlag;

	private char hedgeFlag;

	private double price;

	private int volume;

	private String tradeDate;

	private String tradeTime;

	private String tradeType;

	private char priceSource;

	private String traderID;

	private String orderLocalID;

	private String clearingPartID;

	private String businessUnit;

	private int sequenceNo;

	private String tradingDay;

	private int settlementID;

	private int brokerOrderSeq;

	private char tradeSource;

	private long tradeDateTime;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(String brokerID) {
		this.brokerID = brokerID;
	}

	public String getInvestorID() {
		return investorID;
	}

	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public String getOrderSysID() {
		return orderSysID;
	}

	public void setOrderSysID(String orderSysID) {
		this.orderSysID = orderSysID;
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public char getTradingRole() {
		return tradingRole;
	}

	public void setTradingRole(char tradingRole) {
		this.tradingRole = tradingRole;
	}

	public String getExchangeInstID() {
		return exchangeInstID;
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID = exchangeInstID;
	}

	public char getOffsetFlag() {
		return offsetFlag;
	}

	public void setOffsetFlag(char offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public char getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(char hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public char getPriceSource() {
		return priceSource;
	}

	public void setPriceSource(char priceSource) {
		this.priceSource = priceSource;
	}

	public String getTraderID() {
		return traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public String getOrderLocalID() {
		return orderLocalID;
	}

	public void setOrderLocalID(String orderLocalID) {
		this.orderLocalID = orderLocalID;
	}

	public String getClearingPartID() {
		return clearingPartID;
	}

	public void setClearingPartID(String clearingPartID) {
		this.clearingPartID = clearingPartID;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}

	public int getSettlementID() {
		return settlementID;
	}

	public void setSettlementID(int settlementID) {
		this.settlementID = settlementID;
	}

	public int getBrokerOrderSeq() {
		return brokerOrderSeq;
	}

	public void setBrokerOrderSeq(int brokerOrderSeq) {
		this.brokerOrderSeq = brokerOrderSeq;
	}

	public char getTradeSource() {
		return tradeSource;
	}

	public void setTradeSource(char tradeSource) {
		this.tradeSource = tradeSource;
	}

	public long getTradeDateTime() {
		return tradeDateTime;
	}

	public void setTradeDateTime(long tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [id=");
		builder.append(id);
		builder.append(", brokerID=");
		builder.append(brokerID);
		builder.append(", investorID=");
		builder.append(investorID);
		builder.append(", instrumentID=");
		builder.append(instrumentID);
		builder.append(", orderRef=");
		builder.append(orderRef);
		builder.append(", userID=");
		builder.append(userID);
		builder.append(", exchangeID=");
		builder.append(exchangeID);
		builder.append(", tradeID=");
		builder.append(tradeID);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", orderSysID=");
		builder.append(orderSysID);
		builder.append(", participantID=");
		builder.append(participantID);
		builder.append(", clientID=");
		builder.append(clientID);
		builder.append(", tradingRole=");
		builder.append(tradingRole);
		builder.append(", exchangeInstID=");
		builder.append(exchangeInstID);
		builder.append(", offsetFlag=");
		builder.append(offsetFlag);
		builder.append(", hedgeFlag=");
		builder.append(hedgeFlag);
		builder.append(", price=");
		builder.append(price);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", tradeDate=");
		builder.append(tradeDate);
		builder.append(", tradeTime=");
		builder.append(tradeTime);
		builder.append(", tradeType=");
		builder.append(tradeType);
		builder.append(", priceSource=");
		builder.append(priceSource);
		builder.append(", traderID=");
		builder.append(traderID);
		builder.append(", orderLocalID=");
		builder.append(orderLocalID);
		builder.append(", clearingPartID=");
		builder.append(clearingPartID);
		builder.append(", businessUnit=");
		builder.append(businessUnit);
		builder.append(", sequenceNo=");
		builder.append(sequenceNo);
		builder.append(", tradingDay=");
		builder.append(tradingDay);
		builder.append(", settlementID=");
		builder.append(settlementID);
		builder.append(", brokerOrderSeq=");
		builder.append(brokerOrderSeq);
		builder.append(", tradeSource=");
		builder.append(tradeSource);
		builder.append(", tradeDateTime=");
		builder.append(tradeDateTime);
		builder.append("]");
		return builder.toString();
	}

	
	
}

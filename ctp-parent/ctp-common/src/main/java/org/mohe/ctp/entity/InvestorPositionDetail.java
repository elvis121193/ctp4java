package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InvestorPositionDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 938526122886950410L;
	
	@Id
	private String id;
	// /合约代码
	private String instrumentID;
	// /经纪公司代码
	private String brokerID;
	// /投资者代码
	private String investorID;
	// /投机套保标志
	private char hedgeFlag;
	// /买卖
	private char direction;
	// /开仓日期
	private String openDate;
	// /成交编号
	private String tradeID;
	// /数量
	private int volume;
	// /开仓价
	private double openPrice;
	// /交易日
	private String tradingDay;
	// /结算编号
	private int settlementID;
	// /成交类型
	private char tradeType;
	// /组合合约代码
	private String combInstrumentID;
	// /交易所代码
	private String exchangeID;
	// /逐日盯市平仓盈亏
	private double closeProfitByDate;
	// /逐笔对冲平仓盈亏
	private double closeProfitByTrade;
	// /逐日盯市持仓盈亏
	private double positionProfitByDate;
	// /逐笔对冲持仓盈亏
	private double positionProfitByTrade;
	// /投资者保证金
	private double margin;
	// /交易所保证金
	private double exchMargin;
	// /保证金率
	private double marginRateByMoney;
	// /保证金率(按手数)
	private double marginRateByVolume;
	// /昨结算价
	private double lastSettlementPrice;
	// /结算价
	private double settlementPrice;
	// /平仓量
	private int closeVolume;
	// /平仓金额
	private double closeAmount;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
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

	public char getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(char hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
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

	public char getTradeType() {
		return tradeType;
	}

	public void setTradeType(char tradeType) {
		this.tradeType = tradeType;
	}

	public String getCombInstrumentID() {
		return combInstrumentID;
	}

	public void setCombInstrumentID(String combInstrumentID) {
		this.combInstrumentID = combInstrumentID;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public double getCloseProfitByDate() {
		return closeProfitByDate;
	}

	public void setCloseProfitByDate(double closeProfitByDate) {
		this.closeProfitByDate = closeProfitByDate;
	}

	public double getCloseProfitByTrade() {
		return closeProfitByTrade;
	}

	public void setCloseProfitByTrade(double closeProfitByTrade) {
		this.closeProfitByTrade = closeProfitByTrade;
	}

	public double getPositionProfitByDate() {
		return positionProfitByDate;
	}

	public void setPositionProfitByDate(double positionProfitByDate) {
		this.positionProfitByDate = positionProfitByDate;
	}

	public double getPositionProfitByTrade() {
		return positionProfitByTrade;
	}

	public void setPositionProfitByTrade(double positionProfitByTrade) {
		this.positionProfitByTrade = positionProfitByTrade;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public double getExchMargin() {
		return exchMargin;
	}

	public void setExchMargin(double exchMargin) {
		this.exchMargin = exchMargin;
	}

	public double getMarginRateByMoney() {
		return marginRateByMoney;
	}

	public void setMarginRateByMoney(double marginRateByMoney) {
		this.marginRateByMoney = marginRateByMoney;
	}

	public double getMarginRateByVolume() {
		return marginRateByVolume;
	}

	public void setMarginRateByVolume(double marginRateByVolume) {
		this.marginRateByVolume = marginRateByVolume;
	}

	public double getLastSettlementPrice() {
		return lastSettlementPrice;
	}

	public void setLastSettlementPrice(double lastSettlementPrice) {
		this.lastSettlementPrice = lastSettlementPrice;
	}

	public double getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(double settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public int getCloseVolume() {
		return closeVolume;
	}

	public void setCloseVolume(int closeVolume) {
		this.closeVolume = closeVolume;
	}

	public double getCloseAmount() {
		return closeAmount;
	}

	public void setCloseAmount(double closeAmount) {
		this.closeAmount = closeAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvestorPositionDetail [id=");
		builder.append(id);
		builder.append(", instrumentID=");
		builder.append(instrumentID);
		builder.append(", brokerID=");
		builder.append(brokerID);
		builder.append(", investorID=");
		builder.append(investorID);
		builder.append(", hedgeFlag=");
		builder.append(hedgeFlag);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", tradeID=");
		builder.append(tradeID);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", openPrice=");
		builder.append(openPrice);
		builder.append(", tradingDay=");
		builder.append(tradingDay);
		builder.append(", settlementID=");
		builder.append(settlementID);
		builder.append(", tradeType=");
		builder.append(tradeType);
		builder.append(", combInstrumentID=");
		builder.append(combInstrumentID);
		builder.append(", exchangeID=");
		builder.append(exchangeID);
		builder.append(", closeProfitByDate=");
		builder.append(closeProfitByDate);
		builder.append(", closeProfitByTrade=");
		builder.append(closeProfitByTrade);
		builder.append(", positionProfitByDate=");
		builder.append(positionProfitByDate);
		builder.append(", positionProfitByTrade=");
		builder.append(positionProfitByTrade);
		builder.append(", margin=");
		builder.append(margin);
		builder.append(", exchMargin=");
		builder.append(exchMargin);
		builder.append(", marginRateByMoney=");
		builder.append(marginRateByMoney);
		builder.append(", marginRateByVolume=");
		builder.append(marginRateByVolume);
		builder.append(", lastSettlementPrice=");
		builder.append(lastSettlementPrice);
		builder.append(", settlementPrice=");
		builder.append(settlementPrice);
		builder.append(", closeVolume=");
		builder.append(closeVolume);
		builder.append(", closeAmount=");
		builder.append(closeAmount);
		builder.append("]");
		return builder.toString();
	}

	
}

package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Tick数据
 * @author Elvis
 *
 */
@Document
public class Tick implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3566030903350065938L;
	
	@Id
	private String id;
	/**
	 * 时间戳, 格式2016101310350000
	 */
	private Long timeTag;
	
	/**
	 * 合约
	 */
	private String instrumentId;
	
	/**
	 * 申买量
	 */
	private Integer bidVolume;
	
	/**
	 * 申买价
	 */
	private Double bikPrice;
	
	/**
	 * 申卖量
	 */
	private Integer askVolume;
	
	/**
	 * 申卖价
	 */
	private Double askPrice;
	
	/**
	 * 交易所代码
	 */
	private String exchangeId;
	
	/**
	 * 合约在交易所的代码 
	 */
	private String exchangeInstId;
	
	/**
	 * 最新价
	 */
	private Double lastPrice;
	
	/**
	 * 开盘价
	 */
	private Double openPrice;
	
	/**
	 * 收盘价
	 */
	private Double closePrice;
	
	/**
	 * 最高价
	 */
	private Double highestPrice;
	
	/**
	 * 最低价
	 */
	private Double lowestPrice;
	
	/**
	 * 均价
	 */
	private Double avgragePrice;
	
	/**
	 * 成交额
	 */
	private Double turnover;
	
	/**
	 * 成交量
	 */
	private Integer volume;
	
	/**
	 * 持仓量
	 */
	private Double openInterest;
	
	/**
	 * 昨收盘价
	 */
	private Double preClosePrice;
	
	/**
	 * 昨持仓量
	 */
	private Double preOpenInterest;
	
	/**
	 * 昨结算价
	 */
	private Double preSettlementPrice;
	
	/**
	 * 结算价
	 */
	private Double settlementPrice;
	
	/**
	 * 跌停价
	 */
	private Double lowerLimitPrice;
	
	/**
	 * 涨停价
	 */
	private Double upperLimitPrice;
	
	/**
	 * 交易日
	 */
	private String tradingDay;
	
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	/**
	 * 更新毫秒数
	 */
	private int updateMillsec;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimeTag() {
		return timeTag;
	}

	public void setTimeTag(Long timeTag) {
		this.timeTag = timeTag;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public Integer getBidVolume() {
		return bidVolume;
	}

	public void setBidVolume(Integer bidVolume) {
		this.bidVolume = bidVolume;
	}

	public Double getBikPrice() {
		return bikPrice;
	}

	public void setBikPrice(Double bikPrice) {
		this.bikPrice = bikPrice;
	}

	public Integer getAskVolume() {
		return askVolume;
	}

	public void setAskVolume(Integer askVolume) {
		this.askVolume = askVolume;
	}

	public Double getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(Double askPrice) {
		this.askPrice = askPrice;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getExchangeInstId() {
		return exchangeInstId;
	}

	public void setExchangeInstId(String exchangeInstId) {
		this.exchangeInstId = exchangeInstId;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	public Double getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(Double highestPrice) {
		this.highestPrice = highestPrice;
	}

	public Double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Double getAvgragePrice() {
		return avgragePrice;
	}

	public void setAvgragePrice(Double avgragePrice) {
		this.avgragePrice = avgragePrice;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getOpenInterest() {
		return openInterest;
	}

	public void setOpenInterest(Double openInterest) {
		this.openInterest = openInterest;
	}

	public Double getPreClosePrice() {
		return preClosePrice;
	}

	public void setPreClosePrice(Double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}

	public Double getPreOpenInterest() {
		return preOpenInterest;
	}

	public void setPreOpenInterest(Double preOpenInterest) {
		this.preOpenInterest = preOpenInterest;
	}

	public Double getPreSettlementPrice() {
		return preSettlementPrice;
	}

	public void setPreSettlementPrice(Double preSettlementPrice) {
		this.preSettlementPrice = preSettlementPrice;
	}

	public Double getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(Double settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public Double getLowerLimitPrice() {
		return lowerLimitPrice;
	}

	public void setLowerLimitPrice(Double lowerLimitPrice) {
		this.lowerLimitPrice = lowerLimitPrice;
	}

	public Double getUpperLimitPrice() {
		return upperLimitPrice;
	}

	public void setUpperLimitPrice(Double upperLimitPrice) {
		this.upperLimitPrice = upperLimitPrice;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public int getUpdateMillsec() {
		return updateMillsec;
	}

	public void setUpdateMillsec(int updateMillsec) {
		this.updateMillsec = updateMillsec;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tick [timeTag=");
		builder.append(timeTag);
		builder.append(", instrumentId=");
		builder.append(instrumentId);
		builder.append(", bidVolume=");
		builder.append(bidVolume);
		builder.append(", bikPrice=");
		builder.append(bikPrice);
		builder.append(", askVolume=");
		builder.append(askVolume);
		builder.append(", askPrice=");
		builder.append(askPrice);
		builder.append(", exchangeId=");
		builder.append(exchangeId);
		builder.append(", exchangeInstId=");
		builder.append(exchangeInstId);
		builder.append(", lastPrice=");
		builder.append(lastPrice);
		builder.append(", openPrice=");
		builder.append(openPrice);
		builder.append(", closePrice=");
		builder.append(closePrice);
		builder.append(", highestPrice=");
		builder.append(highestPrice);
		builder.append(", lowestPrice=");
		builder.append(lowestPrice);
		builder.append(", avgragePrice=");
		builder.append(avgragePrice);
		builder.append(", turnover=");
		builder.append(turnover);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", openInterest=");
		builder.append(openInterest);
		builder.append(", preClosePrice=");
		builder.append(preClosePrice);
		builder.append(", preOpenInterest=");
		builder.append(preOpenInterest);
		builder.append(", preSettlementPrice=");
		builder.append(preSettlementPrice);
		builder.append(", settlementPrice=");
		builder.append(settlementPrice);
		builder.append(", lowerLimitPrice=");
		builder.append(lowerLimitPrice);
		builder.append(", upperLimitPrice=");
		builder.append(upperLimitPrice);
		builder.append(", tradingDay=");
		builder.append(tradingDay);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updateMillsec=");
		builder.append(updateMillsec);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}

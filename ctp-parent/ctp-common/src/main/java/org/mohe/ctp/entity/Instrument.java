package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Instrument implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742712983990065838L;

	/**
	 * 主键
	 */
	@Id
	private String id;
	
	/**合约代码*/
	private String instrumentID;
		
	/**交易所代码*/
	private String exchangeID;
		
	/**合约在交易所的代码*/
	private String exchangeInstID;
		
	/**合约名称*/
	private String instrumentName;
		
	/**产品代码*/
	private String productID;
		
	/**产品类型*/
	private String productClass;
		
	/**交割年份*/
	private Integer deliveryYear;
		
	/**交割月*/
	private Integer deliveryMonth;
		
	/**市价单最大下单量*/
	private Integer maxMarketOrderVolume;
		
	/**市价单最小下单量*/
	private Integer minMarketOrderVolume;
		
	/**限价单最大下单量*/
	private Integer maxLimitOrderVolume;
		
	/**限价单最小下单量*/
	private Integer minLimitOrderVolume;
		
	/**合约数量乘数*/
	private Integer volumeMultiple;
		
	/**最小变动价位*/
	private Double priceTick;
		
	/**创建日*/
	private String createDate;
		
	/**上市日*/
	private String openDate;
		
	/**到期日*/
	private String expireDate;
		
	/**开始交割日*/
	private String startDelivDate;
		
	/**结束交割日*/
	private String endDelivDate;
		
	/**合约生命周期状态*/
	private String instLifePhase;
		
	/**当前是否交易*/
	private Integer isTrading;
		
	/**持仓类型*/
	private String positionType;
		
	/**持仓日期类型*/
	private String positionDateType;
		
	/**多头保证金率*/
	private Double longMarginRatio;
		
	/**空头保证金率*/
	private Double shortMarginRatio;
		
	/**是否使用大额单边保证金算法*/
	private String maxMarginSideAlgorithm;
		
	/**基础商品代码*/
	private String underlyingInstrID;
		
	/**执行价*/
	private Double strikePrice;
		
	/**期权类型*/
	private String optionsType;
		
	/**合约基础商品乘数*/
	private Double underlyingMultiple;
		
	/**组合类型*/
	private String combinationType;

	
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

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getExchangeInstID() {
		return exchangeInstID;
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID = exchangeInstID;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public Integer getDeliveryYear() {
		return deliveryYear;
	}

	public void setDeliveryYear(Integer deliveryYear) {
		this.deliveryYear = deliveryYear;
	}

	public Integer getDeliveryMonth() {
		return deliveryMonth;
	}

	public void setDeliveryMonth(Integer deliveryMonth) {
		this.deliveryMonth = deliveryMonth;
	}

	public Integer getMaxMarketOrderVolume() {
		return maxMarketOrderVolume;
	}

	public void setMaxMarketOrderVolume(Integer maxMarketOrderVolume) {
		this.maxMarketOrderVolume = maxMarketOrderVolume;
	}

	public Integer getMinMarketOrderVolume() {
		return minMarketOrderVolume;
	}

	public void setMinMarketOrderVolume(Integer minMarketOrderVolume) {
		this.minMarketOrderVolume = minMarketOrderVolume;
	}

	public Integer getMaxLimitOrderVolume() {
		return maxLimitOrderVolume;
	}

	public void setMaxLimitOrderVolume(Integer maxLimitOrderVolume) {
		this.maxLimitOrderVolume = maxLimitOrderVolume;
	}

	public Integer getMinLimitOrderVolume() {
		return minLimitOrderVolume;
	}

	public void setMinLimitOrderVolume(Integer minLimitOrderVolume) {
		this.minLimitOrderVolume = minLimitOrderVolume;
	}

	public Integer getVolumeMultiple() {
		return volumeMultiple;
	}

	public void setVolumeMultiple(Integer volumeMultiple) {
		this.volumeMultiple = volumeMultiple;
	}

	public Double getPriceTick() {
		return priceTick;
	}

	public void setPriceTick(Double priceTick) {
		this.priceTick = priceTick;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getStartDelivDate() {
		return startDelivDate;
	}

	public void setStartDelivDate(String startDelivDate) {
		this.startDelivDate = startDelivDate;
	}

	public String getEndDelivDate() {
		return endDelivDate;
	}

	public void setEndDelivDate(String endDelivDate) {
		this.endDelivDate = endDelivDate;
	}

	public String getInstLifePhase() {
		return instLifePhase;
	}

	public void setInstLifePhase(String instLifePhase) {
		this.instLifePhase = instLifePhase;
	}

	public Integer getIsTrading() {
		return isTrading;
	}

	public void setIsTrading(Integer isTrading) {
		this.isTrading = isTrading;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getPositionDateType() {
		return positionDateType;
	}

	public void setPositionDateType(String positionDateType) {
		this.positionDateType = positionDateType;
	}

	public Double getLongMarginRatio() {
		return longMarginRatio;
	}

	public void setLongMarginRatio(Double longMarginRatio) {
		this.longMarginRatio = longMarginRatio;
	}

	public Double getShortMarginRatio() {
		return shortMarginRatio;
	}

	public void setShortMarginRatio(Double shortMarginRatio) {
		this.shortMarginRatio = shortMarginRatio;
	}

	public String getMaxMarginSideAlgorithm() {
		return maxMarginSideAlgorithm;
	}

	public void setMaxMarginSideAlgorithm(String maxMarginSideAlgorithm) {
		this.maxMarginSideAlgorithm = maxMarginSideAlgorithm;
	}

	public String getUnderlyingInstrID() {
		return underlyingInstrID;
	}

	public void setUnderlyingInstrID(String underlyingInstrID) {
		this.underlyingInstrID = underlyingInstrID;
	}

	public Double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getOptionsType() {
		return optionsType;
	}

	public void setOptionsType(String optionsType) {
		this.optionsType = optionsType;
	}

	public Double getUnderlyingMultiple() {
		return underlyingMultiple;
	}

	public void setUnderlyingMultiple(Double underlyingMultiple) {
		this.underlyingMultiple = underlyingMultiple;
	}

	public String getCombinationType() {
		return combinationType;
	}

	public void setCombinationType(String combinationType) {
		this.combinationType = combinationType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instrument [id=");
		builder.append(id);
		builder.append(", instrumentID=");
		builder.append(instrumentID);
		builder.append(", exchangeID=");
		builder.append(exchangeID);
		builder.append(", exchangeInstID=");
		builder.append(exchangeInstID);
		builder.append(", instrumentName=");
		builder.append(instrumentName);
		builder.append(", productID=");
		builder.append(productID);
		builder.append(", productClass=");
		builder.append(productClass);
		builder.append(", deliveryYear=");
		builder.append(deliveryYear);
		builder.append(", deliveryMonth=");
		builder.append(deliveryMonth);
		builder.append(", maxMarketOrderVolume=");
		builder.append(maxMarketOrderVolume);
		builder.append(", minMarketOrderVolume=");
		builder.append(minMarketOrderVolume);
		builder.append(", maxLimitOrderVolume=");
		builder.append(maxLimitOrderVolume);
		builder.append(", minLimitOrderVolume=");
		builder.append(minLimitOrderVolume);
		builder.append(", volumeMultiple=");
		builder.append(volumeMultiple);
		builder.append(", priceTick=");
		builder.append(priceTick);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", expireDate=");
		builder.append(expireDate);
		builder.append(", startDelivDate=");
		builder.append(startDelivDate);
		builder.append(", endDelivDate=");
		builder.append(endDelivDate);
		builder.append(", instLifePhase=");
		builder.append(instLifePhase);
		builder.append(", isTrading=");
		builder.append(isTrading);
		builder.append(", positionType=");
		builder.append(positionType);
		builder.append(", positionDateType=");
		builder.append(positionDateType);
		builder.append(", longMarginRatio=");
		builder.append(longMarginRatio);
		builder.append(", shortMarginRatio=");
		builder.append(shortMarginRatio);
		builder.append(", maxMarginSideAlgorithm=");
		builder.append(maxMarginSideAlgorithm);
		builder.append(", underlyingInstrID=");
		builder.append(underlyingInstrID);
		builder.append(", strikePrice=");
		builder.append(strikePrice);
		builder.append(", optionsType=");
		builder.append(optionsType);
		builder.append(", underlyingMultiple=");
		builder.append(underlyingMultiple);
		builder.append(", combinationType=");
		builder.append(combinationType);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

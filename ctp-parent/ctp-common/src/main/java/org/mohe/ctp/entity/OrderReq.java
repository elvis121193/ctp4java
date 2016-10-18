package org.mohe.ctp.entity;

import org.mohe.ctp.enums.ThostFtdcDirectionType;
import org.mohe.ctp.enums.ThostFtdcOffsetFlagType;
import org.mohe.ctp.enums.ThostFtdcOrderPriceTypeType;

public class OrderReq {
	
	private String symbol;
	
	private String exchange;
	
	private float price;
	
	private int volume;
	
	private ThostFtdcOrderPriceTypeType priceType;
	
	private ThostFtdcDirectionType direction;
	
	private ThostFtdcOffsetFlagType offset;
	
	private String productClass;
	
	private String currency;
	
	private String expiry;
	
	private float strikePrice;
	
	private String optionType;

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

	public ThostFtdcOrderPriceTypeType getPriceType() {
		return priceType;
	}

	public void setPriceType(ThostFtdcOrderPriceTypeType priceType) {
		this.priceType = priceType;
	}

	public ThostFtdcDirectionType getDirection() {
		return direction;
	}

	public void setDirection(ThostFtdcDirectionType direction) {
		this.direction = direction;
	}

	public ThostFtdcOffsetFlagType getOffset() {
		return offset;
	}

	public void setOffset(ThostFtdcOffsetFlagType offset) {
		this.offset = offset;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public float getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	
	

}

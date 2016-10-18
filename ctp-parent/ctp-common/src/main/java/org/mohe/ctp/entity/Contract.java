package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contract extends BaseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6961103226926018958L;

	private String symbol;
	
	private String exchange;
	
	private String vtSymbol;
	
	private String name;
	
	private String productClass;
	
	private int size;
	
	private float priceTick;
	
	private float strikePrice;
	
	private String underlyingSymbol;
	
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

	public String getVtSymbol() {
		return vtSymbol;
	}

	public void setVtSymbol(String vtSymbol) {
		this.vtSymbol = vtSymbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getPriceTick() {
		return priceTick;
	}

	public void setPriceTick(float priceTick) {
		this.priceTick = priceTick;
	}

	public float getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getUnderlyingSymbol() {
		return underlyingSymbol;
	}

	public void setUnderlyingSymbol(String underlyingSymbol) {
		this.underlyingSymbol = underlyingSymbol;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	
}

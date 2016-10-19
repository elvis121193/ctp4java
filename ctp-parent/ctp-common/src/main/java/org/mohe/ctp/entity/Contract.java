package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contract extends BaseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6961103226926018958L;
	@Id
	private String symbol;
	
	private String name;
	
	private char productClass;
	
	private int size;
	
	private float priceTick;
	
	private float strikePrice;
	
	private String underlyingSymbol;
	
	private char optionType;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getProductClass() {
		return productClass;
	}

	public void setProductClass(char productClass) {
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

	public char getOptionType() {
		return optionType;
	}

	public void setOptionType(char optionType) {
		this.optionType = optionType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contract [symbol=");
		builder.append(symbol);
		builder.append(", name=");
		builder.append(name);
		builder.append(", productClass=");
		builder.append(productClass);
		builder.append(", size=");
		builder.append(size);
		builder.append(", priceTick=");
		builder.append(priceTick);
		builder.append(", strikePrice=");
		builder.append(strikePrice);
		builder.append(", underlyingSymbol=");
		builder.append(underlyingSymbol);
		builder.append(", optionType=");
		builder.append(optionType);
		builder.append("]");
		return builder.toString();
	}

	
}

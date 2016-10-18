package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Position extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6803299283060162020L;

	private String symbol;
	
	private String exchange;
	
	private String vtSymbol;
	
	private String direction;
	
	private int position;
	
	private int frozen;
	
	private float price;
	
	private String vtPositionName;
	
	private int ydPosition;

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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getFrozen() {
		return frozen;
	}

	public void setFrozen(int frozen) {
		this.frozen = frozen;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVtPositionName() {
		return vtPositionName;
	}

	public void setVtPositionName(String vtPositionName) {
		this.vtPositionName = vtPositionName;
	}

	public int getYdPosition() {
		return ydPosition;
	}

	public void setYdPosition(int ydPosition) {
		this.ydPosition = ydPosition;
	}
	
	
}

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

	private char direction;
	
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

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [symbol=");
		builder.append(symbol);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", position=");
		builder.append(position);
		builder.append(", frozen=");
		builder.append(frozen);
		builder.append(", price=");
		builder.append(price);
		builder.append(", vtPositionName=");
		builder.append(vtPositionName);
		builder.append(", ydPosition=");
		builder.append(ydPosition);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

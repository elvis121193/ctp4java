package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1937489621176286614L;

	@Id
	private String accountId;
	
	private float preBalance;
	
	private float balance;
	
	private float available;
	
	private float commission;
	
	private float margin;
	
	private float closeProfit;
	
	private float positionProfit;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public float getPreBalance() {
		return preBalance;
	}

	public void setPreBalance(float preBalance) {
		this.preBalance = preBalance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getAvailable() {
		return available;
	}

	public void setAvailable(float available) {
		this.available = available;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getMargin() {
		return margin;
	}

	public void setMargin(float margin) {
		this.margin = margin;
	}

	public float getCloseProfit() {
		return closeProfit;
	}

	public void setCloseProfit(float closeProfit) {
		this.closeProfit = closeProfit;
	}

	public float getPositionProfit() {
		return positionProfit;
	}

	public void setPositionProfit(float positionProfit) {
		this.positionProfit = positionProfit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", preBalance=");
		builder.append(preBalance);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", available=");
		builder.append(available);
		builder.append(", commission=");
		builder.append(commission);
		builder.append(", margin=");
		builder.append(margin);
		builder.append(", closeProfit=");
		builder.append(closeProfit);
		builder.append(", positionProfit=");
		builder.append(positionProfit);
		builder.append("]");
		return builder.toString();
	}
	
	
}

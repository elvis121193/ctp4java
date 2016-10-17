package org.mohe.ctp.dto;

public class AccountDTO extends BaseDTO{

	private String accountId;
	
	private String vtAccountId;
	
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

	public String getVtAccountId() {
		return vtAccountId;
	}

	public void setVtAccountId(String vtAccountId) {
		this.vtAccountId = vtAccountId;
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
	
	
}

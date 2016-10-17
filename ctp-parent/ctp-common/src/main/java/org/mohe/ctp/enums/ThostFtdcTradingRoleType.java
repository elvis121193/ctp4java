package org.mohe.ctp.enums;

/**
 * 交易角色类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcTradingRoleType {
	/** 代理 */
	THOST_FTDC_ER_Broker('1'),
	/** 自营 */
	THOST_FTDC_ER_Host('2'),
	/** 做市商 */
	THOST_FTDC_ER_Maker('3');

	ThostFtdcTradingRoleType(char code) {
		this.code = code;
	}

	private char code;

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}
}

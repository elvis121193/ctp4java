package org.mohe.ctp.enums;

/**
 * 交易所属性类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcExchangePropertyType {
	/**
	 * 正常
	 */
	THOST_FTDC_EXP_Normal('0'),
	/**
	 * 根据成交生成报单
	 */
	THOST_FTDC_EXP_GenOrderByTrade('1');

	ThostFtdcExchangePropertyType(char code) {
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

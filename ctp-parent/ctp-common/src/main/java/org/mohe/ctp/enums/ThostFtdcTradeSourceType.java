package org.mohe.ctp.enums;

/**
 * 成交来源类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcTradeSourceType {
	/** 来自交易所普通回报 */
	THOST_FTDC_TSRC_NORMAL('0'),
	/** 来自查询 */
	THOST_FTDC_TSRC_QUERY('1');

	ThostFtdcTradeSourceType(char code) {
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

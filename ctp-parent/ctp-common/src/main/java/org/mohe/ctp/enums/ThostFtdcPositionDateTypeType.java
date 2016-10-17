package org.mohe.ctp.enums;

/**
 * 持仓日期类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcPositionDateTypeType {
	/** 使用历史持仓 */
	THOST_FTDC_PDT_UseHistory('1'),
	/** 不使用历史持仓 */
	THOST_FTDC_PDT_NoUseHistory('2');

	ThostFtdcPositionDateTypeType(char code) {
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

package org.mohe.ctp.enums;

/**
 * 持仓日期类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcPositionDateType {
	/** 今日持仓 */
	THOST_FTDC_PSD_Today('1'),
	/** 历史持仓 */
	THOST_FTDC_PSD_History('2');

	ThostFtdcPositionDateType(char code) {
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

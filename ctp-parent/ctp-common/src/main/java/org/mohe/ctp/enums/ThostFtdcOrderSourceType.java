package org.mohe.ctp.enums;

/**
 * 报单来源类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderSourceType {
	/** 来自参与者 */
	THOST_FTDC_OSRC_Participant('0'),
	/** 来自管理员 */
	THOST_FTDC_OSRC_Administrator('1');

	ThostFtdcOrderSourceType(char code) {
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

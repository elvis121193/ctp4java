package org.mohe.ctp.enums;

/**
 * 期权类型
 * @author Elvis
 *
 */
public enum ThostFtdcOptionsTypeType {
	/** 看涨*/
	THOST_FTDC_CP_CallOptions('1'),
	/** 看跌 */
	THOST_FTDC_CP_PutOptions('2');

	ThostFtdcOptionsTypeType(char code) {
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

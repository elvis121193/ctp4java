package org.mohe.ctp.enums;

/**
 * 持仓类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcPositionTypeType {
	/** 净持仓 */
	THOST_FTDC_PT_Net('1'),
	/** 综合持仓 */
	THOST_FTDC_PT_Gross('2');

	ThostFtdcPositionTypeType(char code) {
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

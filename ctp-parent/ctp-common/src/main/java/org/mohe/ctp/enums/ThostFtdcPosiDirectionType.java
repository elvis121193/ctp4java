package org.mohe.ctp.enums;

/**
 * 持仓多空方向类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcPosiDirectionType {
	/** 净 */
	THOST_FTDC_PD_Net('1'),
	/** 多头 */
	THOST_FTDC_PD_Long('2'),
	/** 空头 */
	THOST_FTDC_PD_Short('3');

	ThostFtdcPosiDirectionType(char code) {
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

package org.mohe.ctp.enums;

/**
 * 交易编码类型类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcExClientIDTypeType {
	/** 套保 */
	THOST_FTDC_ECIDT_Hedge('1'),
	/** 套利 */
	THOST_FTDC_ECIDT_Arbitrage('2'),
	/** 投机 */
	THOST_FTDC_ECIDT_Speculation('3');

	ThostFtdcExClientIDTypeType(char code) {
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

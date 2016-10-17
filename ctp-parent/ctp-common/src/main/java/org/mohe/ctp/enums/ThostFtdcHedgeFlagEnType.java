package org.mohe.ctp.enums;

/**
 * 
 * 投机套保标志类型
 * @author Elvis
 *
 */
public enum ThostFtdcHedgeFlagEnType {
	/** 投机*/
	THOST_FTDC_HFEN_Speculation('1'),
	/** 套利 */
	THOST_FTDC_HFEN_Arbitrage('2'),
	/** 套期保值 */
	THOST_FTDC_HFEN_Hedge('3');

	ThostFtdcHedgeFlagEnType(char code) {
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

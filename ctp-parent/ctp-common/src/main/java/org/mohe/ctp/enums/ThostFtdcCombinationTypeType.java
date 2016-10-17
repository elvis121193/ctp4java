package org.mohe.ctp.enums;

/**
 * 组合类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcCombinationTypeType {
	/** 期货组合 */
	THOST_FTDC_COMBT_Future('0'),
	/** 垂直价差BUL */
	THOST_FTDC_COMBT_BUL('1'),
	/** 垂直价差BER */
	THOST_FTDC_COMBT_BER('2'),
	/** 跨式组合 */
	THOST_FTDC_COMBT_STD('3'),
	/** 宽跨式组合 */
	THOST_FTDC_COMBT_STG('4'),
	/** 备兑组合 */
	THOST_FTDC_COMBT_PRT('5'),
	/** 时间价差组合 */
	THOST_FTDC_COMBT_CLD('6');

	ThostFtdcCombinationTypeType(char code) {
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

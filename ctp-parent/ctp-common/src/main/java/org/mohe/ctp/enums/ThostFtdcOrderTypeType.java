package org.mohe.ctp.enums;

/**
 * 报单类型类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderTypeType {
	/** 正常 */
	THOST_FTDC_ORDT_Normal('0'),
	/** 报价衍生 */
	THOST_FTDC_ORDT_DeriveFromQuote('1'),
	/** 组合衍生 */
	THOST_FTDC_ORDT_DeriveFromCombination('2'),
	/** 组合报单 */
	THOST_FTDC_ORDT_Combination('3'),
	/** 条件单 */
	THOST_FTDC_ORDT_ConditionalOrder('4'),
	/** 互换单 */
	THOST_FTDC_ORDT_Swap('5');
	
	ThostFtdcOrderTypeType(char code) {
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

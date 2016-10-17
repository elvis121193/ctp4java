package org.mohe.ctp.enums;

/**
 * 产品类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcProductClassType {
	/** 期货 */
	THOST_FTDC_PC_Futures('1'),
	/** 期货期权 */
	THOST_FTDC_PC_Options('2'),
	/** 组合 */
	THOST_FTDC_PC_Combination('3'),
	/** 即期 */
	THOST_FTDC_PC_Spot('4'),
	/** 期转现 */
	THOST_FTDC_PC_EFP('5'),
	/** 现货期权 */
	THOST_FTDC_PC_SpotOption('6'),
	/** 个股期权 */
	THOST_FTDC_PC_ETFOption('7'),
	/** 证券 */
	THOST_FTDC_PC_Stock('8');

	ThostFtdcProductClassType(char code) {
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

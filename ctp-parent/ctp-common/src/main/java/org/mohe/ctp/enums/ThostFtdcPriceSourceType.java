package org.mohe.ctp.enums;

/**
 * 成交价来源类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcPriceSourceType {
	/** 前成交价 */
	THOST_FTDC_PSRC_LastPrice('0'),
	/** 买委托价 */
	THOST_FTDC_PSRC_Buy('1'),
	/** 卖委托价 */
	THOST_FTDC_PSRC_Sell('2');

	ThostFtdcPriceSourceType(char code) {
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

package org.mohe.ctp.enums;

/**
 * 买卖方向
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcDirectionType {
	/** 买 */
	THOST_FTDC_D_Buy('0'),
	/** 卖 */
	THOST_FTDC_D_Sell('1');

	ThostFtdcDirectionType(char code) {
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

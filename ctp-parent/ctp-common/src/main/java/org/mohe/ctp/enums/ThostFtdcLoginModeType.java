package org.mohe.ctp.enums;

/**
 * 登录模式类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcLoginModeType {
	/**
	 * 交易
	 */
	THOST_FTDC_LM_Trade('0'),
	/**
	 * 转账
	 */
	THOST_FTDC_LM_Transfer('1');

	private char code;

	ThostFtdcLoginModeType(char code) {
		this.code = code;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}

}

package org.mohe.ctp.enums;

/**
 * 大额单边保证金算法类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcMaxMarginSideAlgorithmType {
	/** 不使用大额单边保证金算法 */
	THOST_FTDC_MMSA_NO('0'),
	/** 使用大额单边保证金算法 */
	THOST_FTDC_MMSA_YES('1');

	ThostFtdcMaxMarginSideAlgorithmType(char code) {
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

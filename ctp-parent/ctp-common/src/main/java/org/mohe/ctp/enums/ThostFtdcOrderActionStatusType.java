package org.mohe.ctp.enums;

/**
 * 报单操作状态类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderActionStatusType {
	/** 已经提交 */
	THOST_FTDC_OAS_Submitted('a'),
	/** 已经接受 */
	THOST_FTDC_OAS_Accepted('b'),
	/** 已经被拒绝 */
	THOST_FTDC_OAS_Rejected('c');

	ThostFtdcOrderActionStatusType(char code) {
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

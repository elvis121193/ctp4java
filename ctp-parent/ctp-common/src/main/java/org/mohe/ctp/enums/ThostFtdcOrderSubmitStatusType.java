package org.mohe.ctp.enums;

/**
 * 报单提交状态类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderSubmitStatusType {
	/** 已经提交 */
	THOST_FTDC_OSS_InsertSubmitted('0'),
	/** 撤单已经提交 */
	THOST_FTDC_OSS_CancelSubmitted('1'),
	/** 修改已经提交 */
	THOST_FTDC_OSS_ModifySubmitted('2'),
	/** 已经接受 */
	THOST_FTDC_OSS_Accepted('3'),
	/** 报单已经被拒绝 */
	THOST_FTDC_OSS_InsertRejected('4'),
	/** 撤单已经被拒绝 */
	THOST_FTDC_OSS_CancelRejected('5'),
	/** 改单已经被拒绝 */
	THOST_FTDC_OSS_ModifyRejected('6');

	ThostFtdcOrderSubmitStatusType(char code) {
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

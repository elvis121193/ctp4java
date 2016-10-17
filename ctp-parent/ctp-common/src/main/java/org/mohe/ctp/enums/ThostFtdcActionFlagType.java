package org.mohe.ctp.enums;

/**
 * 操作标志类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcActionFlagType {
	/**
	 * 删除
	 */
	THOST_FTDC_AF_Delete('0'),
	/**
	 * 修改
	 */
	THOST_FTDC_AF_Modify('3');

	ThostFtdcActionFlagType(char code) {
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

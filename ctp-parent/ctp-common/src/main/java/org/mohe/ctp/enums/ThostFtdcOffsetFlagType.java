package org.mohe.ctp.enums;

/**
 * 开平标志类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOffsetFlagType {
	/** 开仓 */
	THOST_FTDC_OF_Open('0'),
	/** 平仓 */
	THOST_FTDC_OF_Close('1'),
	/** 强平 */
	THOST_FTDC_OF_ForceClose('2'),
	/** 平今 */
	THOST_FTDC_OF_CloseToday('3'),
	/** 平昨 */
	THOST_FTDC_OF_CloseYesterday('4'),
	/** 强减 */
	THOST_FTDC_OF_ForceOff('5'),
	/** 本地强平 */
	THOST_FTDC_OF_LocalForceClose('6');

	ThostFtdcOffsetFlagType(char code) {
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

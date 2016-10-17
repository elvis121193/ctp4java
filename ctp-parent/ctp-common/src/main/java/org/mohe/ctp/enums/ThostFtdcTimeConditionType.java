package org.mohe.ctp.enums;

/**
 * 有效期类型
 * @author Elvis
 *
 */
public enum ThostFtdcTimeConditionType {
	/** 立即完成，否则撤销 */
	THOST_FTDC_TC_IOC('1'),
	/** 本节有效 */
	THOST_FTDC_TC_GFS('2'),
	/** 当日有效 */
	THOST_FTDC_TC_GFD('3'),
	/** 指定日期前有效 */
	THOST_FTDC_TC_GTD('4'),
	/** 撤销前有效 */
	THOST_FTDC_TC_GTC('5'),
	/** 集合竞价有效 */
	THOST_FTDC_TC_GFA('6');

	ThostFtdcTimeConditionType(char code) {
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

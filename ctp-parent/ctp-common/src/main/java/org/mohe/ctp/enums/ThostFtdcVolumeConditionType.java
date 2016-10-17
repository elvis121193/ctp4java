package org.mohe.ctp.enums;

/**
 * 成交量类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcVolumeConditionType {
	/** 任何数量 */
	THOST_FTDC_VC_AV('1'),
	/** 最小数量 */
	THOST_FTDC_VC_MV('2'),
	/** 全部数量 */
	THOST_FTDC_VC_CV('3');

	ThostFtdcVolumeConditionType(char code) {
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

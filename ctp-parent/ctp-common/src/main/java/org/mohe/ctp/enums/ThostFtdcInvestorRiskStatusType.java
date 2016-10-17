package org.mohe.ctp.enums;

/**
 * 投资者范围类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcInvestorRiskStatusType {
	/** 所有 */
	THOST_FTDC_IR_All('1'),
	/** 投资者组 */
	THOST_FTDC_IR_Group('2'),
	/** 单一投资者 */
	THOST_FTDC_IR_Single('3');

	ThostFtdcInvestorRiskStatusType(char code) {
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

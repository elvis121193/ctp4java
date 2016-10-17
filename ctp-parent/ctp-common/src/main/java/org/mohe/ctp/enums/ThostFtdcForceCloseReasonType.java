package org.mohe.ctp.enums;

/**
 * 强平原因类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcForceCloseReasonType {
	/** 非强平 */
	THOST_FTDC_FCC_NotForceClose('0'),
	/** 资金不足 */
	THOST_FTDC_FCC_LackDeposit('1'),
	/** 客户超仓 */
	THOST_FTDC_FCC_ClientOverPositionLimit('2'),
	/** 会员超仓 */
	THOST_FTDC_FCC_MemberOverPositionLimit('3'),
	/** 持仓非整数倍 */
	THOST_FTDC_FCC_NotMultiple('4'),
	/** 违规 */
	THOST_FTDC_FCC_Violation('5'),
	/** 其它 */
	THOST_FTDC_FCC_Other('6'),
	/** 自然人临近交割 */
	THOST_FTDC_FCC_PersonDeliv('7');
	
	ThostFtdcForceCloseReasonType(char code) {
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

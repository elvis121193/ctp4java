package org.mohe.ctp.enums;

/**
 * 合约生命周期状态类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcInstLifePhaseType {
	/** 未上市 */
	THOST_FTDC_IP_NotStart('0'),
	/** 上市 */
	THOST_FTDC_IP_Started('1'),
	/** 停牌 */
	THOST_FTDC_IP_Pause('2'),
	/** 到期 */
	THOST_FTDC_IP_Expired('3');

	ThostFtdcInstLifePhaseType(char code) {
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

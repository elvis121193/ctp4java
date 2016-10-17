package org.mohe.ctp.enums;

/**
 * 成交类型类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcTradeTypeType {
	/** 组合持仓拆分为单一持仓,初始化不应包含该类型的持仓 */
	THOST_FTDC_TRDT_SplitCombination('#'),
	/** 普通成交 */
	THOST_FTDC_TRDT_Common('0'),
	/** 期权执行 */
	THOST_FTDC_TRDT_OptionsExecution('1'),
	/** OTC成交 */
	THOST_FTDC_TRDT_OTC('2'),
	/** 期转现衍生成交 */
	THOST_FTDC_TRDT_EFPDerived('3'),
	/** 组合衍生成交 */
	THOST_FTDC_TRDT_CombinationDerived('4');

	ThostFtdcTradeTypeType(char code) {
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

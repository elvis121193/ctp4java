package org.mohe.ctp.enums;

/**
 * 触发条件类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcContingentConditionType {
	/** 立即 */
	THOST_FTDC_CC_Immediately('1'),
	/** 止损 */
	THOST_FTDC_CC_Touch('2'),
	/** 止赢 */
	THOST_FTDC_CC_TouchProfit('3'),
	/** 预埋单 */
	THOST_FTDC_CC_ParkedOrder('4'),
	/** 最新价大于条件价 */
	THOST_FTDC_CC_LastPriceGreaterThanStopPrice('5'),
	/** 最新价大于等于条件价 */
	THOST_FTDC_CC_LastPriceGreaterEqualStopPrice('6'),
	/** 最新价小于条件价 */
	THOST_FTDC_CC_LastPriceLesserThanStopPrice('7'),
	/** 最新价小于等于条件价 */
	THOST_FTDC_CC_LastPriceLesserEqualStopPrice('8'),
	/** 卖一价大于条件价 */
	THOST_FTDC_CC_AskPriceGreaterThanStopPrice('9'),
	/** 卖一价大于等于条件价 */
	THOST_FTDC_CC_AskPriceGreaterEqualStopPrice('A'),
	/** 卖一价小于条件价 */
	THOST_FTDC_CC_AskPriceLesserThanStopPrice('B'),
	/** 卖一价小于等于条件价 */
	THOST_FTDC_CC_AskPriceLesserEqualStopPrice('C'),
	/** 买一价大于条件价 */
	THOST_FTDC_CC_BidPriceGreaterThanStopPrice('D'),
	/** 买一价大于等于条件价 */
	THOST_FTDC_CC_BidPriceGreaterEqualStopPrice('E'),
	/** 买一价小于条件价 */
	THOST_FTDC_CC_BidPriceLesserThanStopPrice('F'),
	/** 买一价小于等于条件价 */
	THOST_FTDC_CC_BidPriceLesserEqualStopPrice('H');

	ThostFtdcContingentConditionType(char code) {
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

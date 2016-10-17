package org.mohe.ctp.enums;

/**
 * 报单状态类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderStatusType {
	/** 全部成交 */
	THOST_FTDC_OST_AllTraded('0'),
	/** 部分成交还在队列中 */
	THOST_FTDC_OST_PartTradedQueueing('1'),
	/** 部分成交不在队列中 */
	THOST_FTDC_OST_PartTradedNotQueueing('2'),
	/** 未成交还在队列中 */
	THOST_FTDC_OST_NoTradeQueueing('3'),
	/** 未成交不在队列中 */
	THOST_FTDC_OST_NoTradeNotQueueing('4'),
	/** 撤单 */
	THOST_FTDC_OST_Canceled('5'),
	/** 未知 */
	THOST_FTDC_OST_Unknown('a'),
	/** 尚未触发 */
	THOST_FTDC_OST_NotTouched('b'),
	/** 已触发 */
	THOST_FTDC_OST_Touched('c');

	ThostFtdcOrderStatusType(char code) {
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

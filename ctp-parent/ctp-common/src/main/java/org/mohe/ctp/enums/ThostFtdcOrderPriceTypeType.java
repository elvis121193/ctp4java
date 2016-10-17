package org.mohe.ctp.enums;

/**
 * @author Elvis
 * 
 */
public enum ThostFtdcOrderPriceTypeType {
	/** 任意价 */
	THOST_FTDC_OPT_AnyPrice('1'),
	/** 限价 */
	THOST_FTDC_OPT_LimitPrice('2'),
	/** 最优价 */
	THOST_FTDC_OPT_BestPrice('3'),
	/** 最新价 */
	THOST_FTDC_OPT_LastPrice('4'),
	/** 最新价浮动上浮1个ticks */
	THOST_FTDC_OPT_LastPricePlusOneTicks('5'),
	/** 最新价浮动上浮2个ticks */
	THOST_FTDC_OPT_LastPricePlusTwoTicks('6'),
	/** 最新价浮动上浮3个ticks */
	THOST_FTDC_OPT_LastPricePlusThreeTicks('7'),
	/** 卖一价 */
	THOST_FTDC_OPT_AskPrice1('8'),
	/** 卖一价浮动上浮1个ticks */
	THOST_FTDC_OPT_AskPrice1PlusOneTicks('9'),
	/** 卖一价浮动上浮2个ticks */
	THOST_FTDC_OPT_AskPrice1PlusTwoTicks('A'),
	/** 卖一价浮动上浮3个ticks */
	THOST_FTDC_OPT_AskPrice1PlusThreeTicks('B'),
	/** 买一价 */
	THOST_FTDC_OPT_BidPrice1('C'),
	/** 买一价浮动上浮1个ticks */
	THOST_FTDC_OPT_BidPrice1PlusOneTicks('D'),
	/** 买一价浮动上浮2个ticks */
	THOST_FTDC_OPT_BidPrice1PlusTwoTicks('E'),
	/** 买一价浮动上浮3个ticks */
	THOST_FTDC_OPT_BidPrice1PlusThreeTicks('F'),
	/** 五档价 */
	THOST_FTDC_OPT_FiveLevelPrice('G'),
	/** 本方最优价 */
	THOST_FTDC_OPT_BestPriceThisSide('H');

	ThostFtdcOrderPriceTypeType(char code) {
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

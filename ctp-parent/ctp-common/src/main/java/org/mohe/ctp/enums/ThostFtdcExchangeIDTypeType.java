package org.mohe.ctp.enums;

/**
 * 交易所编号类型
 * 
 * @author Elvis
 * 
 */
public enum ThostFtdcExchangeIDTypeType {
	/** 上海期货交易所 */
	THOST_FTDC_EIDT_SHFE('S'),
	/** 郑州商品交易所 */
	THOST_FTDC_EIDT_CZCE('Z'),
	/** 大连商品交易所 */
	THOST_FTDC_EIDT_DCE('D'),
	/** 中国金融期货交易所 */
	THOST_FTDC_EIDT_CFFEX('J'),
	/** 上海国际能源交易中心股份有限公司 */
	THOST_FTDC_EIDT_INE('N'),
	/** 上海证券交易所 */
	THOST_FTDC_EIDT_SSE('A'),
	/** 深圳证券交易所 */
	THOST_FTDC_EIDT_SZSE('E');

	ThostFtdcExchangeIDTypeType(char code) {
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

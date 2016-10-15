package cn.yiwang.ctp.struct;

/**
 * 发给做市商的询价请求
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPForQuoteRsp extends CTPField {
    /** 交易日 char[9] */
    public String TradingDay;
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 询价编号 char[9] */
    public String ForQuoteSysID;
    /** 询价时间 char[9] */
    public String ForQuoteTime;
    /** 业务日期 char[9] */
    public String ActionDay;
    /** 交易所代码 char[9] */
    public String ExchangeID;
}

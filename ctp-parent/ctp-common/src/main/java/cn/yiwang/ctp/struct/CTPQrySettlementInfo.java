package cn.yiwang.ctp.struct;

/**
 * 查询投资者结算结果
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPQrySettlementInfo extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 交易日 char[9] */
    public String TradingDay;
}

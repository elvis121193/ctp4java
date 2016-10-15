package cn.yiwang.ctp.struct;

/**
 * 查询资金账户
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPQryTradingAccount extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 币种代码 char[4] */
    public String CurrencyID;
}

package cn.yiwang.ctp.struct;

/**
 * 查询投资者持仓明细
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPQryInvestorPositionDetail extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 合约代码 char[31] */
    public String InstrumentID;
}

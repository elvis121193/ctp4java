package cn.yiwang.ctp.struct;

/**
 * 投资者结算结果确认信息
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPSettlementInfoConfirm extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 确认日期 char[9] */
    public String ConfirmDate;
    /** 确认时间 char[9] */
    public String ConfirmTime;
}

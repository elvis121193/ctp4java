package cn.yiwang.ctp.struct;

/**
 * 投资者结算结果
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPSettlementInfo extends CTPField {
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 序号 */
    public int SequenceNo;
    /** 消息正文 char[501] */
    public String Content;
}

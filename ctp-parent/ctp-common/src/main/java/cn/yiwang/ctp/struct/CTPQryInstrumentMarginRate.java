package cn.yiwang.ctp.struct;

/**
 * 查询合约保证金率
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPQryInstrumentMarginRate extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 投机套保标志 [投机/套利/套保] */
    public char HedgeFlag = CTPConst.THOST_FTDC_HF_Speculation;
}

package cn.yiwang.ctp.struct;

/**
 * 合约保证金率
 * 
 * @author Wang
 * @version
 */
public class CTPInstrumentMarginRate extends CTPField {
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 投资者范围 [所有/投资者组/单一投资者] */
    public char InvestorRange = CTPConst.THOST_FTDC_IR_All;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 投机套保标志 [投机/套利/套保] */
    public char HedgeFlag = CTPConst.THOST_FTDC_HF_Speculation;
    /** 多头保证金率 */
    public float LongMarginRatioByMoney;
    /** 多头保证金费 */
    public float LongMarginRatioByVolume;
    /** 空头保证金率 */
    public float ShortMarginRatioByMoney;
    /** 空头保证金费 */
    public float ShortMarginRatioByVolume;
    /** 是否相对交易所收取 */
    public int IsRelative;
}

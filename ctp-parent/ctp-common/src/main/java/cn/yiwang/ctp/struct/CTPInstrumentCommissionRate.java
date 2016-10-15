package cn.yiwang.ctp.struct;

/**
 * 合约手续费率
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInstrumentCommissionRate extends CTPField {
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 投资者范围 [所有/投资者组/单一投资者] */
    public char InvestorRange = CTPConst.THOST_FTDC_IR_All;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 开仓手续费率 */
    public float OpenRatioByMoney;
    /** 开仓手续费 */
    public float OpenRatioByVolume;
    /** 平仓手续费率 */
    public float CloseRatioByMoney;
    /** 平仓手续费 */
    public float CloseRatioByVolume;
    /** 平今手续费率 */
    public float CloseTodayRatioByMoney;
    /** 平今手续费 */
    public float CloseTodayRatioByVolume;

}

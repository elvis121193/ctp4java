package cn.yiwang.ctp.struct;

/**
 * 交易所
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPExchange extends CTPField {
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 交易所名称 char[61] */
    public String ExchangeName;
    /** 交易所属性 [正常/根据成交生成报单] */
    public int ExchangeProperty = CTPConst.THOST_FTDC_EXP_Normal;

}

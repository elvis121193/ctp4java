package cn.yiwang.ctp.struct;

/**
 * 查询合约
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPQryInstrument {
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 合约在交易所的代码 char[31] */
    public String ExchangeInstID;
    /** 产品代码 char[31] */
    public String ProductID;
}

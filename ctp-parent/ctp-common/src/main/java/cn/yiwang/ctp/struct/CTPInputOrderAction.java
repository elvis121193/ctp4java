package cn.yiwang.ctp.struct;

/**
 * 输入报单操作
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInputOrderAction extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 报单操作引用 */
    public int OrderActionRef;
    /** 报单引用 char[13] */
    public String OrderRef;
    /** 请求编号 */
    public int RequestID;
    /** 前置编号 */
    public int FrontID;
    /** 会话编号 */
    public int SessionID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 报单编号 char[21] */
    public String OrderSysID;
    /** 操作标志 [删除/修改] */
    public char ActionFlag = CTPConst.THOST_FTDC_AF_Delete;
    /** 价格 */
    public float LimitPrice;
    /** 数量变化 */
    public int VolumeChange;
    /** 用户代码 char[16] */
    public String UserID;
    /** 合约代码 char[31] */
    public String InstrumentID;

}

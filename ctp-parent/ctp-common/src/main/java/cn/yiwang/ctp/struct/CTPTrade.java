package cn.yiwang.ctp.struct;

/**
 * 成交
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPTrade extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 报单引用 char[13] */
    public String OrderRef;
    /** 用户代码 char[16] */
    public String UserID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 成交编号 char[21] */
    public String TradeID;
    /** 买卖方向 [买/卖]*/
    public char Direction = CTPConst.THOST_FTDC_D_Buy;
    /** 报单编号 char[21] */
    public String OrderSysID;
    /** 会员代码 char[11] */
    public String ParticipantID;
    /** 客户代码 char[11] */
    public String ClientID;
    /** 交易角色 [代理/自营/做市商]*/
    public char TradingRole = CTPConst.THOST_FTDC_ER_Broker;
    /** 合约在交易所的代码 char[31] */
    public String ExchangeInstID;
    /** 开平标志 [开仓/平仓/强平/平今/平昨/强减/本地强平]*/
    public char OffsetFlag = CTPConst.THOST_FTDC_OF_Open;
    /** 投机套保标志 [投机/套利/套保]*/
    public char HedgeFlag = CTPConst.THOST_FTDC_HF_Speculation;
    /** 价格 */
    public float Price;
    /** 数量 */
    public int Volume;
    /** 成交时期 char[9] */
    public String TradeDate;
    /** 成交时间 char[9] */
    public String TradeTime;
    /** 成交类型 [普通成交/期权执行/OTC成交/期转现衍生成交/组合衍生成交]*/
    public char TradeType = CTPConst.THOST_FTDC_TRDT_Common;
    /** 成交价来源 [前成交价/买委托价/卖委托价]*/
    public char PriceSource = CTPConst.THOST_FTDC_PSRC_LastPrice;
    /** 交易所交易员代码 char[21] */
    public String TraderID;
    /** 本地报单编号 char[13] */
    public String OrderLocalID;
    /** 结算会员编号 char[11] */
    public String ClearingPartID;
    /** 业务单元 char[21] */
    public String BusinessUnit;
    /** 序号 */
    public int SequenceNo;
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 经纪公司报单编号 */
    public int BrokerOrderSeq;
    /** 成交来源 [来自交易所普通回报/来自查询]*/
    public char TradeSource = CTPConst.THOST_FTDC_TSRC_NORMAL;
}

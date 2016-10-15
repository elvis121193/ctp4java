package cn.yiwang.ctp.struct;

/**
 * 报单
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPOrder extends CTPField {
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
    /**
     * 报单价格条件 [任意价/限价/最优价/最新价/最新价浮动上浮1个ticks/最新价浮动上浮2个ticks/最新价浮动上浮3个ticks/卖一价/
     * 卖一价浮动上浮1个ticks
     * /卖一价浮动上浮2个ticks/卖一价浮动上浮3个ticks/买一价/买一价浮动上浮1个ticks/买一价浮动上浮2个ticks
     * /买一价浮动上浮3个ticks/五档价]
     */
    public char OrderPriceType = CTPConst.THOST_FTDC_OPT_AnyPrice;
    /** 买卖方向 [买/卖] */
    public char Direction = CTPConst.THOST_FTDC_D_Buy;
    /** 组合开平标志 char[5] */
    public String CombOffsetFlag;
    /** 组合投机套保标志 char[5] */
    public String CombHedgeFlag;
    /** 价格 */
    public float LimitPrice;
    /** 数量 */
    public int VolumeTotalOriginal;
    /** 有效期类型 [立即完成，否则撤销/本节有效/当日有效/指定日期前有效/撤销前有效/集合竞价有效] */
    public char TimeCondition = CTPConst.THOST_FTDC_TC_IOC;
    /** GTD日期 char[9] */
    public String GTDDate;
    /** 成交量类型 [任何数量/最小数量/全部数量] */
    public char VolumeCondition = CTPConst.THOST_FTDC_VC_AV;
    /** 最小成交量 */
    public int MinVolume;
    /**
     * 触发条件 [立即/止损/止赢/预埋单/最新价大于条件价/最新价大于等于条件价/最新价小于条件价/最新价小于等于条件价/卖一价大于条件价/
     * 卖一价大于等于条件价/卖一价小于条件价/卖一价小于等于条件价/买一价大于条件价/买一价大于等于条件价/买一价小于条件价/买一价小于等于条件价/]
     */
    public char ContingentCondition = CTPConst.THOST_FTDC_CC_Immediately;
    /** 止损价 */
    public float StopPrice;
    /** 强平原因 [非强平/资金不足/客户超仓/会员超仓/持仓非整数倍/违规/其它/自然人临近交割] */
    public char ForceCloseReason = CTPConst.THOST_FTDC_FCC_NotForceClose;
    /** 自动挂起标志 */
    public int IsAutoSuspend;
    /** 业务单元 char[21] */
    public String BusinessUnit;
    /** 请求编号 */
    public int RequestID;
    /** 本地报单编号 char[13] */
    public String OrderLocalID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 会员代码 char[11] */
    public String ParticipantID;
    /** 客户代码 char[11] */
    public String ClientID;
    /** 合约在交易所的代码 char[31] */
    public String ExchangeInstID;
    /** 交易所交易员代码 char[21] */
    public String TraderID;
    /** 安装编号 */
    public int InstallID;
    /** 报单提交状态 [已经提交/撤单已经提交/修改已经提交/已经接受/报单已经被拒绝/撤单已经被拒绝/改单已经被拒绝/] */
    public char OrderSubmitStatus = CTPConst.THOST_FTDC_OSS_InsertSubmitted;
    /** 报单提示序号 */
    public int NotifySequence;
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 报单编号 char[21] */
    public String OrderSysID;
    /** 报单来源 [来自参与者/来自管理员] */
    public char OrderSource = CTPConst.THOST_FTDC_OSRC_Participant;
    /** 报单状态 [全部成交/部分成交还在队列中/部分成交不在队列中/未成交还在队列中/未成交不在队列中/撤单/未知/尚未触发/已触发] */
    public char OrderStatus = CTPConst.THOST_FTDC_OST_AllTraded;
    /** 报单类型 [正常/报价衍生/组合衍生/组合报单/条件单/互换单] */
    public char OrderType = CTPConst.THOST_FTDC_ORDT_Normal;
    /** 今成交数量 */
    public int VolumeTraded;
    /** 剩余数量 */
    public int VolumeTotal;
    /** 报单日期 char[9] */
    public String InsertDate;
    /** 委托时间 char[9] */
    public String InsertTime;
    /** 激活时间 char[9] */
    public String ActiveTime;
    /** 挂起时间 char[9] */
    public String SuspendTime;
    /** 最后修改时间 char[9] */
    public String UpdateTime;
    /** 撤销时间 char[9] */
    public String CancelTime;
    /** 最后修改交易所交易员代码 char[21] */
    public String ActiveTraderID;
    /** 结算会员编号 char[11] */
    public String ClearingPartID;
    /** 序号 */
    public int SequenceNo;
    /** 前置编号 */
    public int FrontID;
    /** 会话编号 */
    public int SessionID;
    /** 用户端产品信息 char[11] */
    public String UserProductInfo;
    /** 状态信息 char[81] */
    public String StatusMsg;
    /** 用户强评标志 */
    public int UserForceClose;
    /** 操作用户代码 char[16] */
    public String ActiveUserID;
    /** 经纪公司报单编号 */
    public int BrokerOrderSeq;
    /** 相关报单 char[21] */
    public String RelativeOrderSysID;
    /** 郑商所成交数量 */
    public int ZCETotalTradedVolume;
    /** 互换单标志 */
    public int IsSwapOrder;
}

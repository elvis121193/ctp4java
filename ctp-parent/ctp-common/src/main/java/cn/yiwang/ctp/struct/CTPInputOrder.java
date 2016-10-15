package cn.yiwang.ctp.struct;

/**
 * 输入报单
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInputOrder extends CTPField {
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
    /** 用户强评标志 */
    public int UserForceClose;
    /** 互换单标志 */
    public int IsSwapOrder;
}

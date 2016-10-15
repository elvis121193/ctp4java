package cn.yiwang.ctp.struct;

public class CTPConst {

    /** NO */
    public static final int THOST_FTDC_NO = 0;
    /** YES */
    public static final int THOST_FTDC_YES = 1;

    /** 从本交易日开始重传 */
    public static final int THOST_TERT_RESTART = 0;
    /** 从上次收到的续传 */
    public static final int THOST_TERT_RESUME = 1;
    /** 只传送登录后公共流的内容 */
    public static final int THOST_TERT_QUICK = 2;

    /** 登录模式-交易 */
    public static final char THOST_FTDC_LM_Trade = '0';
    /** 登录模式-转账 */
    public static final char THOST_FTDC_LM_Transfer = '1';

    /** 交易所属性-正常 */
    public static final char THOST_FTDC_EXP_Normal = '0';
    /** 交易所属性-根据成交生成报单 */
    public static final char THOST_FTDC_EXP_GenOrderByTrade = '1';

    /** 产品类型-期货 */
    public static final char THOST_FTDC_PC_Futures = '1';
    /** 产品类型-期权 */
    public static final char THOST_FTDC_PC_Options = '2';
    /** 产品类型-组合 */
    public static final char THOST_FTDC_PC_Combination = '3';
    /** 产品类型-即期 */
    public static final char THOST_FTDC_PC_Spot = '4';
    /** 产品类型-期转现 */
    public static final char THOST_FTDC_PC_EFP = '5';
    /** 产品类型-现货期权 */
    public static final char THOST_FTDC_PC_SpotOption = '6';

    /** 合约生命周期状态-未上市 */
    public static final char THOST_FTDC_IP_NotStart = '0';
    /** 合约生命周期状态-上市 */
    public static final char THOST_FTDC_IP_Started = '1';
    /** 合约生命周期状态-停牌 */
    public static final char THOST_FTDC_IP_Pause = '2';
    /** 合约生命周期状态-到期 */
    public static final char THOST_FTDC_IP_Expired = '3';

    /** 持仓类型-净持仓 */
    public static final char THOST_FTDC_PT_Net = '1';
    /** 持仓类型-综合持仓 */
    public static final char THOST_FTDC_PT_Gross = '2';

    /** 持仓日期类型-使用历史持仓 */
    public static final char THOST_FTDC_PDT_UseHistory = '1';
    /** 持仓日期类型-不使用历史持仓 */
    public static final char THOST_FTDC_PDT_NoUseHistory = '2';

    /** 是否使用大额单边保证金算法-不使用大额单边保证金算法 */
    public static final char THOST_FTDC_MMSA_NO = '0';
    /** 是否使用大额单边保证金算法-使用大额单边保证金算法 */
    public static final char THOST_FTDC_MMSA_YES = '1';

    /** 期权类型-看涨 */
    public static final char THOST_FTDC_CP_CallOptions = '1';
    /** 期权类型-看跌 */
    public static final char THOST_FTDC_CP_PutOptions = '2';

    /** 组合类型-期货组合 */
    public static final char THOST_FTDC_COMBT_Future = '0';
    /** 组合类型-垂直价差BUL */
    public static final char THOST_FTDC_COMBT_BUL = '1';
    /** 组合类型-垂直价差BER */
    public static final char THOST_FTDC_COMBT_BER = '2';
    /** 组合类型-跨式组合 */
    public static final char THOST_FTDC_COMBT_STD = '3';
    /** 组合类型-宽跨式组合 */
    public static final char THOST_FTDC_COMBT_STG = '4';
    /** 组合类型-备兑组合 */
    public static final char THOST_FTDC_COMBT_PRT = '5';
    /** 组合类型-时间价差组合 */
    public static final char THOST_FTDC_COMBT_CLD = '6';

    /** 报单价格条件-任意价 */
    public static final char THOST_FTDC_OPT_AnyPrice = '1';
    /** 报单价格条件-限价 */
    public static final char THOST_FTDC_OPT_LimitPrice = '2';
    /** 报单价格条件-最优价 */
    public static final char THOST_FTDC_OPT_BestPrice = '3';
    /** 报单价格条件-最新价 */
    public static final char THOST_FTDC_OPT_LastPrice = '4';
    /** 报单价格条件-最新价浮动上浮1个ticks */
    public static final char THOST_FTDC_OPT_LastPricePlusOneTicks = '5';
    /** 报单价格条件-最新价浮动上浮2个ticks */
    public static final char THOST_FTDC_OPT_LastPricePlusTwoTicks = '6';
    /** 报单价格条件-最新价浮动上浮3个ticks */
    public static final char THOST_FTDC_OPT_LastPricePlusThreeTicks = '7';
    /** 报单价格条件-卖一价 */
    public static final char THOST_FTDC_OPT_AskPrice1 = '8';
    /** 报单价格条件-卖一价浮动上浮1个ticks */
    public static final char THOST_FTDC_OPT_AskPrice1PlusOneTicks = '9';
    /** 报单价格条件-卖一价浮动上浮2个ticks */
    public static final char THOST_FTDC_OPT_AskPrice1PlusTwoTicks = 'A';
    /** 报单价格条件-卖一价浮动上浮3个ticks */
    public static final char THOST_FTDC_OPT_AskPrice1PlusThreeTicks = 'B';
    /** 报单价格条件-买一价 */
    public static final char THOST_FTDC_OPT_BidPrice1 = 'C';
    /** 报单价格条件-买一价浮动上浮1个ticks */
    public static final char THOST_FTDC_OPT_BidPrice1PlusOneTicks = 'D';
    /** 报单价格条件-买一价浮动上浮2个ticks */
    public static final char THOST_FTDC_OPT_BidPrice1PlusTwoTicks = 'E';
    /** 报单价格条件-买一价浮动上浮3个ticks */
    public static final char THOST_FTDC_OPT_BidPrice1PlusThreeTicks = 'F';
    /** 报单价格条件-五档价 */
    public static final char THOST_FTDC_OPT_FiveLevelPrice = 'G';

    /** 买 */
    public static final char THOST_FTDC_D_Buy = '0';
    /** 卖 */
    public static final char THOST_FTDC_D_Sell = '1';

    /** 有效期类型-立即完成，否则撤销 */
    public static final char THOST_FTDC_TC_IOC = '1';
    /** 有效期类型-本节有效 */
    public static final char THOST_FTDC_TC_GFS = '2';
    /** 有效期类型-当日有效 */
    public static final char THOST_FTDC_TC_GFD = '3';
    /** 有效期类型-指定日期前有效 */
    public static final char THOST_FTDC_TC_GTD = '4';
    /** 有效期类型-撤销前有效 */
    public static final char THOST_FTDC_TC_GTC = '5';
    /** 有效期类型-集合竞价有效 */
    public static final char THOST_FTDC_TC_GFA = '6';

    /** 成交量类型-任何数量 */
    public static final char THOST_FTDC_VC_AV = '1';
    /** 成交量类型-最小数量 */
    public static final char THOST_FTDC_VC_MV = '2';
    /** 成交量类型-全部数量 */
    public static final char THOST_FTDC_VC_CV = '3';

    /** 触发条件-立即 */
    public static final char THOST_FTDC_CC_Immediately = '1';
    /** 触发条件-止损 */
    public static final char THOST_FTDC_CC_Touch = '2';
    /** 触发条件-止赢 */
    public static final char THOST_FTDC_CC_TouchProfit = '3';
    /** 触发条件-预埋单 */
    public static final char THOST_FTDC_CC_ParkedOrder = '4';
    /** 触发条件-最新价大于条件价 */
    public static final char THOST_FTDC_CC_LastPriceGreaterThanStopPrice = '5';
    /** 触发条件-最新价大于等于条件价 */
    public static final char THOST_FTDC_CC_LastPriceGreaterEqualStopPrice = '6';
    /** 触发条件-最新价小于条件价 */
    public static final char THOST_FTDC_CC_LastPriceLesserThanStopPrice = '7';
    /** 触发条件-最新价小于等于条件价 */
    public static final char THOST_FTDC_CC_LastPriceLesserEqualStopPrice = '8';
    /** 触发条件-卖一价大于条件价 */
    public static final char THOST_FTDC_CC_AskPriceGreaterThanStopPrice = '9';
    /** 触发条件-卖一价大于等于条件价 */
    public static final char THOST_FTDC_CC_AskPriceGreaterEqualStopPrice = 'A';
    /** 触发条件-卖一价小于条件价 */
    public static final char THOST_FTDC_CC_AskPriceLesserThanStopPrice = 'B';
    /** 触发条件-卖一价小于等于条件价 */
    public static final char THOST_FTDC_CC_AskPriceLesserEqualStopPrice = 'C';
    /** 触发条件-买一价大于条件价 */
    public static final char THOST_FTDC_CC_BidPriceGreaterThanStopPrice = 'D';
    /** 触发条件-买一价大于等于条件价 */
    public static final char THOST_FTDC_CC_BidPriceGreaterEqualStopPrice = 'E';
    /** 触发条件-买一价小于条件价 */
    public static final char THOST_FTDC_CC_BidPriceLesserThanStopPrice = 'F';
    /** 触发条件-买一价小于等于条件价 */
    public static final char THOST_FTDC_CC_BidPriceLesserEqualStopPrice = 'H';

    /** 强平原因-非强平 */
    public static final char THOST_FTDC_FCC_NotForceClose = '0';
    /** 强平原因-资金不足 */
    public static final char THOST_FTDC_FCC_LackDeposit = '1';
    /** 强平原因-客户超仓 */
    public static final char THOST_FTDC_FCC_ClientOverPositionLimit = '2';
    /** 强平原因-会员超仓 */
    public static final char THOST_FTDC_FCC_MemberOverPositionLimit = '3';
    /** 强平原因-持仓非整数倍 */
    public static final char THOST_FTDC_FCC_NotMultiple = '4';
    /** 强平原因-违规 */
    public static final char THOST_FTDC_FCC_Violation = '5';
    /** 强平原因-其它 */
    public static final char THOST_FTDC_FCC_Other = '6';
    /** 强平原因-自然人临近交割 */
    public static final char THOST_FTDC_FCC_PersonDeliv = '7';

    /** 报单提交状态-已经提交 */
    public static final char THOST_FTDC_OSS_InsertSubmitted = '0';
    /** 报单提交状态-撤单已经提交 */
    public static final char THOST_FTDC_OSS_CancelSubmitted = '1';
    /** 报单提交状态-修改已经提交 */
    public static final char THOST_FTDC_OSS_ModifySubmitted = '2';
    /** 报单提交状态-已经接受 */
    public static final char THOST_FTDC_OSS_Accepted = '3';
    /** 报单提交状态-报单已经被拒绝 */
    public static final char THOST_FTDC_OSS_InsertRejected = '4';
    /** 报单提交状态-撤单已经被拒绝 */
    public static final char THOST_FTDC_OSS_CancelRejected = '5';
    /** 报单提交状态-改单已经被拒绝 */
    public static final char THOST_FTDC_OSS_ModifyRejected = '6';

    /** 报单来源-来自参与者 */
    public static final char THOST_FTDC_OSRC_Participant = '0';
    /** 报单来源-来自管理员 */
    public static final char THOST_FTDC_OSRC_Administrator = '1';

    /** 报单状态-全部成交 */
    public static final char THOST_FTDC_OST_AllTraded = '0';
    /** 报单状态-部分成交还在队列中 */
    public static final char THOST_FTDC_OST_PartTradedQueueing = '1';
    /** 报单状态-部分成交不在队列中 */
    public static final char THOST_FTDC_OST_PartTradedNotQueueing = '2';
    /** 报单状态-未成交还在队列中 */
    public static final char THOST_FTDC_OST_NoTradeQueueing = '3';
    /** 报单状态-未成交不在队列中 */
    public static final char THOST_FTDC_OST_NoTradeNotQueueing = '4';
    /** 报单状态-撤单 */
    public static final char THOST_FTDC_OST_Canceled = '5';
    /** 报单状态-未知 */
    public static final char THOST_FTDC_OST_Unknown = 'a';
    /** 报单状态-尚未触发 */
    public static final char THOST_FTDC_OST_NotTouched = 'b';
    /** 报单状态-已触发 */
    public static final char THOST_FTDC_OST_Touched = 'c';

    /** 报单类型-正常 */
    public static final char THOST_FTDC_ORDT_Normal = '0';
    /** 报单类型-报价衍生 */
    public static final char THOST_FTDC_ORDT_DeriveFromQuote = '1';
    /** 报单类型-组合衍生 */
    public static final char THOST_FTDC_ORDT_DeriveFromCombination = '2';
    /** 报单类型-组合报单 */
    public static final char THOST_FTDC_ORDT_Combination = '3';
    /** 报单类型-条件单 */
    public static final char THOST_FTDC_ORDT_ConditionalOrder = '4';
    /** 报单类型-互换单 */
    public static final char THOST_FTDC_ORDT_Swap = '5';

    /** 交易角色-代理 */
    public static final char THOST_FTDC_ER_Broker = '1';
    /** 交易角色-自营 */
    public static final char THOST_FTDC_ER_Host = '2';
    /** 交易角色-做市商 */
    public static final char THOST_FTDC_ER_Maker = '3';

    /** 开平标志-开仓 */
    public static final char THOST_FTDC_OF_Open = '0';
    /** 开平标志-平仓 */
    public static final char THOST_FTDC_OF_Close = '1';
    /** 开平标志-强平 */
    public static final char THOST_FTDC_OF_ForceClose = '2';
    /** 开平标志-平今 */
    public static final char THOST_FTDC_OF_CloseToday = '3';
    /** 开平标志-平昨 */
    public static final char THOST_FTDC_OF_CloseYesterday = '4';
    /** 开平标志-强减 */
    public static final char THOST_FTDC_OF_ForceOff = '5';
    /** 开平标志-本地强平 */
    public static final char THOST_FTDC_OF_LocalForceClose = '6';

    /** 投机套保标志-投机 */
    public static final char THOST_FTDC_HF_Speculation = '1';
    /** 投机套保标志-套利 */
    public static final char THOST_FTDC_HF_Arbitrage = '2';
    /** 投机套保标志-套保 */
    public static final char THOST_FTDC_HF_Hedge = '3';

    /** 成交类型-组合持仓拆分为单一持仓,初始化不应包含该类型的持仓 */
    public static final char THOST_FTDC_TRDT_SplitCombination = '#';
    /** 成交类型-普通成交 */
    public static final char THOST_FTDC_TRDT_Common = '0';
    /** 成交类型-期权执行 */
    public static final char THOST_FTDC_TRDT_OptionsExecution = '1';
    /** 成交类型-OTC成交 */
    public static final char THOST_FTDC_TRDT_OTC = '2';
    /** 成交类型-期转现衍生成交 */
    public static final char THOST_FTDC_TRDT_EFPDerived = '3';
    /** 成交类型-组合衍生成交 */
    public static final char THOST_FTDC_TRDT_CombinationDerived = '4';

    /** 成交价来源-成交价 */
    public static final char THOST_FTDC_PSRC_LastPrice = '0';
    /** 成交价来源-买委托价 */
    public static final char THOST_FTDC_PSRC_Buy = '1';
    /** 成交价来源-卖委托价 */
    public static final char THOST_FTDC_PSRC_Sell = '2';

    /** 成交来源-来自交易所普通回报 */
    public static final char THOST_FTDC_TSRC_NORMAL = '0';
    /** 成交来源-来自查询 */
    public static final char THOST_FTDC_TSRC_QUERY = '1';

    /** 持仓多空方向-净 */
    public static final char THOST_FTDC_PD_Net = '1';
    /** 持仓多空方向-多头 */
    public static final char THOST_FTDC_PD_Long = '2';
    /** 持仓多空方向-空头 */
    public static final char THOST_FTDC_PD_Short = '3';

    /** 持仓日期-今日持仓 */
    public static final char THOST_FTDC_PSD_Today = '1';
    /** 持仓日期-历史持仓 */
    public static final char THOST_FTDC_PSD_History = '2';

    /** 操作标志-删除 */
    public static final char THOST_FTDC_AF_Delete = '0';
    /** 操作标志-修改 */
    public static final char THOST_FTDC_AF_Modify = '3';

    /** 报单操作状态-已经提交 */
    public static final char THOST_FTDC_OAS_Submitted = 'a';
    /** 报单操作状态-已经接受 */
    public static final char THOST_FTDC_OAS_Accepted = 'b';
    /** 报单操作状态-已经被拒绝 */
    public static final char THOST_FTDC_OAS_Rejected = 'c';

    /** 投资者范围-所有 */
    public static final char THOST_FTDC_IR_All = '1';
    /** 投资者范围-投资者组 */
    public static final char THOST_FTDC_IR_Group = '2';
    /** 投资者范围-单一投资者 */
    public static final char THOST_FTDC_IR_Single = '3';

    /** 交易所编号-上海期货交易所 */
    public static final char THOST_FTDC_EIDT_SHFE = 'S';
    /** 交易所编号-郑州商品交易所 */
    public static final char THOST_FTDC_EIDT_CZCE = 'Z';
    /** 交易所编号-大连商品交易所 */
    public static final char THOST_FTDC_EIDT_DCE = 'D';
    /** 交易所编号-中国金融期货交易所 */
    public static final char THOST_FTDC_EIDT_CFFEX = 'J';
    /** 交易所编号-上海国际能源交易中心股份有限公司 */
    public static final char THOST_FTDC_EIDT_INE = 'N';

    /** 交易编码类型-套保 */
    public static final char THOST_FTDC_ECIDT_Hedge = '1';
    /** 交易编码类型-套利 */
    public static final char THOST_FTDC_ECIDT_Arbitrage = '2';
    /** 交易编码类型-投机 */
    public static final char THOST_FTDC_ECIDT_Speculation = '3';

}

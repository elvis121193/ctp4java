package cn.yiwang.ctp.struct;

/**
 * 投资者持仓
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInvestorPosition extends CTPField {
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 持仓多空方向[净/多头/空头] */
    public char PosiDirection = CTPConst.THOST_FTDC_PD_Net;
    /** 投机套保标志[投机/套利/套保] */
    public char HedgeFlag = CTPConst.THOST_FTDC_HF_Speculation;
    /** 持仓日期[今日持仓/历史持仓] */
    public char PositionDate = CTPConst.THOST_FTDC_PSD_Today;
    /** 上日持仓 */
    public int YdPosition;
    /** 今日持仓 */
    public int Position;
    /** 多头冻结 */
    public int LongFrozen;
    /** 空头冻结 */
    public int ShortFrozen;
    /** 开仓冻结金额 */
    public float LongFrozenAmount;
    /** 开仓冻结金额 */
    public float ShortFrozenAmount;
    /** 开仓量 */
    public int OpenVolume;
    /** 平仓量 */
    public int CloseVolume;
    /** 开仓金额 */
    public float OpenAmount;
    /** 平仓金额 */
    public float CloseAmount;
    /** 持仓成本 */
    public float PositionCost;
    /** 上次占用的保证金 */
    public float PreMargin;
    /** 占用的保证金 */
    public float UseMargin;
    /** 冻结的保证金 */
    public float FrozenMargin;
    /** 冻结的资金 */
    public float FrozenCash;
    /** 冻结的手续费 */
    public float FrozenCommission;
    /** 资金差额 */
    public float CashIn;
    /** 手续费 */
    public float Commission;
    /** 平仓盈亏 */
    public float CloseProfit;
    /** 持仓盈亏 */
    public float PositionProfit;
    /** 上次结算价 */
    public float PreSettlementPrice;
    /** 本次结算价 */
    public float SettlementPrice;
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 开仓成本 */
    public float OpenCost;
    /** 交易所保证金 */
    public float ExchangeMargin;
    /** 组合成交形成的持仓 */
    public int CombPosition;
    /** 组合多头冻结 */
    public int CombLongFrozen;
    /** 组合空头冻结 */
    public int CombShortFrozen;
    /** 逐日盯市平仓盈亏 */
    public float CloseProfitByDate;
    /** 逐笔对冲平仓盈亏 */
    public float CloseProfitByTrade;
    /** 今日持仓 */
    public int TodayPosition;
    /** 保证金率 */
    public float MarginRateByMoney;
    /** 保证金率(按手数) */
    public float MarginRateByVolume;
    /** 执行冻结 */
    public int StrikeFrozen;
    /** 执行冻结金额 */
    public float StrikeFrozenAmount;
    /** 放弃执行冻结 */
    public int AbandonFrozen;

}

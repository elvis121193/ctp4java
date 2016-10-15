package cn.yiwang.ctp.struct;

/**
 * 投资者持仓明细
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInvestorPositionDetail extends CTPField {
    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 投资者代码 char[13] */
    public String InvestorID;
    /** 投机套保标志[投机/套利/套保] */
    public char HedgeFlag = CTPConst.THOST_FTDC_HF_Speculation;
    /** 买卖[买/卖] */
    public char Direction = CTPConst.THOST_FTDC_D_Buy;
    /** 开仓日期 char[9] */
    public String OpenDate;
    /** 成交编号 char[21] */
    public String TradeID;
    /** 数量 */
    public int Volume;
    /** 开仓价 */
    public float OpenPrice;
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 成交类型 [普通成交/期权执行/OTC成交/期转现衍生成交/组合衍生成交] */
    public char TradeType = CTPConst.THOST_FTDC_TRDT_Common;
    /** 组合合约代码 char[31] */
    public String CombInstrumentID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 逐日盯市平仓盈亏 */
    public float CloseProfitByDate;
    /** 逐笔对冲平仓盈亏 */
    public float CloseProfitByTrade;
    /** 逐日盯市持仓盈亏 */
    public float PositionProfitByDate;
    /** 逐笔对冲持仓盈亏 */
    public float PositionProfitByTrade;
    /** 投资者保证金 */
    public float Margin;
    /** 交易所保证金 */
    public float ExchMargin;
    /** 保证金率 */
    public float MarginRateByMoney;
    /** 保证金率(按手数) */
    public float MarginRateByVolume;
    /** 昨结算价 */
    public float LastSettlementPrice;
    /** 结算价 */
    public float SettlementPrice;
    /** 平仓量 */
    public int CloseVolume;
    /** 平仓金额 */
    public float CloseAmount;
}

package cn.yiwang.ctp.struct;

/**
 * 资金账户
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPTradingAccount extends CTPField {
    /** 投资者帐号 char[13] */
    public String AccountID;
    /** 上次质押金额 */
    public float PreMortgage;
    /** 上次信用额度 */
    public float PreCredit;
    /** 上次存款额 */
    public float PreDeposit;
    /** 上次结算准备金 */
    public float PreBalance;
    /** 上次占用的保证金 */
    public float PreMargin;
    /** 利息基数 */
    public float InterestBase;
    /** 利息收入 */
    public float Interest;
    /** 入金金额 */
    public float Deposit;
    /** 出金金额 */
    public float Withdraw;
    /** 冻结的保证金 */
    public float FrozenMargin;
    /** 冻结的资金 */
    public float FrozenCash;
    /** 冻结的手续费 */
    public float FrozenCommission;
    /** 当前保证金总额 */
    public float CurrMargin;
    /** 资金差额 */
    public float CashIn;
    /** 手续费 */
    public float Commission;
    /** 平仓盈亏 */
    public float CloseProfit;
    /** 持仓盈亏 */
    public float PositionProfit;
    /** 期货结算准备金 */
    public float Balance;
    /** 可用资金 */
    public float Available;
    /** 可取资金 */
    public float WithdrawQuota;
    /** 基本准备金 */
    public float Reserve;
    /** 交易日 char[9] */
    public String TradingDay;
    /** 结算编号 */
    public int SettlementID;
    /** 信用额度 */
    public float Credit;
    /** 质押金额 */
    public float Mortgage;
    /** 交易所保证金 */
    public float ExchangeMargin;
    /** 投资者交割保证金 */
    public float DeliveryMargin;
    /** 交易所交割保证金 */
    public float ExchangeDeliveryMargin;
    /** 保底期货结算准备金 */
    public float ReserveBalance;
    /** 币种代码 char[4] */
    public String CurrencyID;
    /** 上次货币质入金额 */
    public float PreFundMortgageIn;
    /** 上次货币质出金额 */
    public float PreFundMortgageOut;
    /** 货币质入金额 */
    public float FundMortgageIn;
    /** 货币质出金额 */
    public float FundMortgageOut;
    /** 货币质押余额 */
    public float FundMortgageAvailable;
    /** 可质押货币金额 */
    public float MortgageableFund;
    /** 特殊产品占用保证金 */
    public float SpecProductMargin;
    /** 特殊产品冻结保证金 */
    public float SpecProductFrozenMargin;
    /** 特殊产品手续费 */
    public float SpecProductCommission;
    /** 特殊产品冻结手续费 */
    public float SpecProductFrozenCommission;
    /** 特殊产品持仓盈亏 */
    public float SpecProductPositionProfit;
    /** 特殊产品平仓盈亏 */
    public float SpecProductCloseProfit;
    /** 根据持仓盈亏算法计算的特殊产品持仓盈亏 */
    public float SpecProductPositionProfitByAlg;
    /** 特殊产品交易所保证金 */
    public float SpecProductExchangeMargin;

}

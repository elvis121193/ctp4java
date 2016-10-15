package cn.yiwang.ctp.struct;

/**
 * 合约
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPInstrument extends CTPField {

    /** 合约代码 char[31] */
    public String InstrumentID;
    /** 交易所代码 char[9] */
    public String ExchangeID;
    /** 合约名称 char[21] */
    public String InstrumentName;
    /** 合约在交易所的代码 char[31] */
    public String ExchangeInstID;
    /** 产品代码 char[31] */
    public String ProductID;
    /** 产品类型 [期货/期权/组合/即期/期转现/现货期权] */
    public char ProductClass = CTPConst.THOST_FTDC_PC_Futures;
    /** 交割年份 */
    public int DeliveryYear;
    /** 交割月 */
    public int DeliveryMonth;
    /** 市价单最大下单量 */
    public int MaxMarketOrderVolume;
    /** 市价单最小下单量 */
    public int MinMarketOrderVolume;
    /** 限价单最大下单量 */
    public int MaxLimitOrderVolume;
    /** 限价单最小下单量 */
    public int MinLimitOrderVolume;
    /** 合约数量乘数 */
    public int VolumeMultiple;
    /** 最小变动价位 */
    public float PriceTick;
    /** 创建日 char[9] */
    public String CreateDate;
    /** 上市日 char[9] */
    public String OpenDate;
    /** 到期日 char[9] */
    public String ExpireDate;
    /** 开始交割日 char[9] */
    public String StartDelivDate;
    /** 结束交割日 char[9] */
    public String EndDelivDate;
    /** 合约生命周期状态 [未上市/上市/停牌/到期] */
    public char InstLifePhase = CTPConst.THOST_FTDC_IP_NotStart;
    /** 当前是否交易 */
    public int IsTrading;
    /** 持仓类型 [净持仓/综合持仓] */
    public char PositionType = CTPConst.THOST_FTDC_PT_Net;
    /** 持仓日期类型 [使用历史持仓/不使用历史持仓] */
    public char PositionDateType = CTPConst.THOST_FTDC_PDT_UseHistory;
    /** 多头保证金率 */
    public float LongMarginRatio;
    /** 空头保证金率 */
    public float ShortMarginRatio;
    /** 是否使用大额单边保证金算法 [不使用大额单边保证金算法/使用大额单边保证金算法] */
    public char MaxMarginSideAlgorithm = CTPConst.THOST_FTDC_MMSA_NO;
    /** 基础商品代码 char[31] */
    public String UnderlyingInstrID;
    /** 执行价 */
    public float StrikePrice;
    /** 期权类型 [看涨/看跌] */
    public char OptionsType = CTPConst.THOST_FTDC_CP_CallOptions;
    /** 合约基础商品乘数 */
    public float UnderlyingMultiple;
    /** 组合类型 [期货组合/垂直价差BUL/垂直价差BER/跨式组合/宽跨式组合/备兑组合/时间价差组合] */
    public char CombinationType = CTPConst.THOST_FTDC_COMBT_Future;

}

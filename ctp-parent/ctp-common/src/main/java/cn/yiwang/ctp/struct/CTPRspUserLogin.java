package cn.yiwang.ctp.struct;

/**
 * 用户登录应答
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPRspUserLogin extends CTPField {
    /** 交易日 char[9] */
    public String TradingDay;
    /** 登录成功时间 char[9] */
    public String LoginTime;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 用户代码 char[16] */
    public String UserID;
    /** 交易系统名称 char[41] */
    public String SystemName;
    /** 前置编号 */
    public int FrontID;
    /** 会话编号 */
    public int SessionID;
    /** 最大报单引用 char[13] */
    public String MaxOrderRef;
    /** 上期所时间 char[9] */
    public String SHFETime;
    /** 大商所时间 char[9] */
    public String DCETime;
    /** 郑商所时间 char[9] */
    public String CZCETime;
    /** 中金所时间 char[9] */
    public String FFEXTime;
    /** 能源中心时间 char[9] */
    public String INETime;
}

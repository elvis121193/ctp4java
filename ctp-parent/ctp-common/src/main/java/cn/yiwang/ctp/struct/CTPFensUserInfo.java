package cn.yiwang.ctp.struct;

/**
 * 用户信息
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPFensUserInfo extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 用户代码 char[16] */
    public String UserID;
    /** 登录模式 [交易/转账] */
    public char LoginMode = CTPConst.THOST_FTDC_LM_Trade;
}

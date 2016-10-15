package cn.yiwang.ctp.struct;

/**
 * 用户登出请求
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPUserLogout extends CTPField {
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 用户代码 char[16] */
    public String UserID;
}

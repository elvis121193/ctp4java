package cn.yiwang.ctp.struct;

/**
 * 用户登录请求
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPReqUserLogin extends CTPField{
    /** 交易日 char[9] */
    public String TradingDay;
    /** 经纪公司代码 char[11] */
    public String BrokerID;
    /** 用户代码 char[16] */
    public String UserID;
    /** 密码 char[41] */
    public String Password;
    /** 用户端产品信息 char[11] */
    public String UserProductInfo;
    /** 接口端产品信息 char[11] */
    public String InterfaceProductInfo;
    /** 协议信息 char[11] */
    public String ProtocolInfo;
    /** Mac地址 char[21] */
    public String MacAddress;
    /** 动态密码 char[41] */
    public String OneTimePassword;
    /** 终端IP地址 char[16] */
    public String ClientIPAddress;
    /**登录备注 char[36] */
    public String LoginRemark;

}

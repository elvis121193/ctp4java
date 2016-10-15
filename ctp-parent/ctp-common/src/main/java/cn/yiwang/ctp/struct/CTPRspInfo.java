package cn.yiwang.ctp.struct;

/**
 * 响应信息
 * 
 * @author Wang
 * @version 1.0
 */
public class CTPRspInfo extends CTPField {
    /** 发送成功 */
    public static final int SUCCESS = 0;
    
    /** 错误代码 */
    public int ErrorID;
    /** 错误信息 char[81] */
    public String ErrorMsg;
}

package cn.yiwang.ctp;

import cn.yiwang.ctp.struct.CTPDepthMarketData;
import cn.yiwang.ctp.struct.CTPForQuoteRsp;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSpecificInstrument;
import cn.yiwang.ctp.struct.CTPUserLogout;

/**
 * CTP行情回调接口
 * 
 * @author Wang
 * @version 1.0
 */
public interface CThostFtdcMdSpi {

    /**
     * 当客户端与交易后台建立起通信连接时（还未登录前），该方法被调用。
     */
    public void onFrontConnected();

    /**
     * 当客户端与交易后台通信连接断开时，该方法被调用。当发生这个情况后，API会自动重新连接，客户端可不做处理。
     * 
     * @param reason
     *            错误原因 0x1001:网络读失败, 0x1002:网络写失败, 0x2001:接收心跳超时, 0x2002:发送心跳失败,
     *            0x2003:收到错误报文
     */
    public void onFrontDisconnected(int reason);

    /**
     * 心跳超时警告。当长时间未收到报文时，该方法被调用。
     * 
     * @param timeLapse
     *            距离上次接收报文的时间
     */
    public void onHeartBeatWarning(int timeLapse);

    /**
     * 登录请求响应
     * 
     * @param rspUserLogin
     *            用户登录应答
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspUserLogin(CTPRspUserLogin rspUserLogin,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 登出请求响应
     * 
     * @param userLogout
     *            用户登出请求
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 错误应答
     * 
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 订阅行情应答
     * 
     * @param specificInstrument
     *            指定的合约
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspSubMarketData(CTPSpecificInstrument specificInstrument,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 取消订阅行情应答
     * 
     * @param specificInstrument
     *            指定的合约
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspUnSubMarketData(CTPSpecificInstrument specificInstrument,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 订阅询价应答
     * 
     * @param specificInstrument
     *            指定的合约
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspSubForQuoteRsp(CTPSpecificInstrument specificInstrument,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 取消订阅询价应答
     * 
     * @param specificInstrument
     *            指定的合约
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspUnSubForQuoteRsp(CTPSpecificInstrument specificInstrument,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 深度行情通知
     * 
     * @param depthMarketData
     *            深度行情
     */
    public void onRtnDepthMarketData(CTPDepthMarketData depthMarketData);

    /**
     * 询价通知
     * 
     * @param forQuoteRsp
     *            发给做市商的询价请求
     */
    public void onRtnForQuoteRsp(CTPForQuoteRsp forQuoteRsp);


}

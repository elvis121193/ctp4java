package cn.yiwang.ctp;

import cn.yiwang.ctp.struct.CTPFensUserInfo;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPUserLogout;

/**
 * CTP行情接口
 * 
 * @author Wang
 * @version 1.0
 */
public class CThostFtdcMdApi {
    static {
       // System.loadLibrary("thostmduserapi");
        System.loadLibrary("ctpjni");
    }

    /**
     * 创建MdApi
     */
    public native void createFtdcMdApi();

    /**
     * 创建MdApi
     * 
     * @param flowPath
     *            存贮订阅信息文件的目录，默认为当前目录
     * @return
     */
    public native void createFtdcMdApi(String flowPath);

    /**
     * 获取API的版本信息
     * 
     * @return 获取到的版本号
     */
    public native String getApiVersion();

    /**
     * 删除接口对象本身<br>
     * 不再使用本接口对象时,调用该函数删除接口对象
     */
    public native void release();

    /**
     * 初始化<br>
     * 初始化运行环境,只有调用后,接口才开始工作
     */
    public native void init();

    /**
     * 等待接口线程结束运行
     * 
     * @return 线程退出代码
     */
    public native int join();

    /**
     * 获取当前交易日
     * 
     * @return 获取到的交易日 (只有登录成功后,才能得到正确的交易日)
     */
    public native String getTradingDay();

    /**
     * 注册前置机网络地址
     * 
     * @param frontAddress
     *            前置机网络地址
     *            网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:17001”
     *            “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”17001”代表服务器端口号
     */
    public native void registerFront(String frontAddress);

    /**
     * 注册名字服务器网络地址
     * 
     * @param nsAddress
     *            名字服务器网络地址
     *            网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:12001”
     *            “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”12001”代表服务器端口号
     *            RegisterNameServer优先于RegisterFront
     */
    public native void registerNameServer(String nsAddress);

    /**
     * 注册名字服务器用户信息
     * 
     * @param userInfo
     *            用户信息
     */
    public native void registerFensUserInfo(CTPFensUserInfo userInfo);

    /**
     * 注册回调接口
     * 
     * @param spi
     *            派生自回调接口类的实例
     */
    public native void registerSpi(CThostFtdcMdSpi spi);

    /**
     * 订阅行情
     * 
     * @param instrumentID
     *            合约ID
     * @param count
     *            要订阅/退订行情的合约个数
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int subscribeMarketData(String[] instrumentID, int count);

    /**
     * 退订行情
     * 
     * @param instrumentID
     *            合约ID
     * @param count
     *            要订阅/退订行情的合约个数
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int unSubscribeMarketData(String[] instrumentID, int count);

    /**
     * 订阅询价
     * 
     * @param instrumentID
     *            合约ID
     * @param count
     *            要订阅/退订行情的合约个数
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int subscribeForQuoteRsp(String[] instrumentID, int count);

    /**
     * 退订询价
     * 
     * @param instrumentID
     *            合约ID
     * @param count
     *            要订阅/退订行情的合约个数
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int unSubscribeForQuoteRsp(String[] instrumentID, int count);

    /**
     * 用户登录请求
     * 
     * @param reqUserLogin
     *            用户登录请求
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqUserLogin(CTPReqUserLogin reqUserLogin, int requestID);

    /**
     * 登出请求
     * 
     * @param userLogout
     *            用户登出请求
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqUserLogout(CTPUserLogout userLogout, int requestID);

}

package cn.yiwang.ctp;

import cn.yiwang.ctp.struct.CTPFensUserInfo;
import cn.yiwang.ctp.struct.CTPInputCombAction;
import cn.yiwang.ctp.struct.CTPInputExecOrder;
import cn.yiwang.ctp.struct.CTPInputExecOrderAction;
import cn.yiwang.ctp.struct.CTPInputForQuote;
import cn.yiwang.ctp.struct.CTPInputOrder;
import cn.yiwang.ctp.struct.CTPInputOrderAction;
import cn.yiwang.ctp.struct.CTPInputQuote;
import cn.yiwang.ctp.struct.CTPInputQuoteAction;
import cn.yiwang.ctp.struct.CTPParkedOrder;
import cn.yiwang.ctp.struct.CTPParkedOrderAction;
import cn.yiwang.ctp.struct.CTPQryAccountregister;
import cn.yiwang.ctp.struct.CTPQryBrokerTradingAlgos;
import cn.yiwang.ctp.struct.CTPQryBrokerTradingParams;
import cn.yiwang.ctp.struct.CTPQryCFMMCTradingAccountKey;
import cn.yiwang.ctp.struct.CTPQryCombAction;
import cn.yiwang.ctp.struct.CTPQryCombInstrumentGuard;
import cn.yiwang.ctp.struct.CTPQryContractBank;
import cn.yiwang.ctp.struct.CTPQryDepthMarketData;
import cn.yiwang.ctp.struct.CTPQryEWarrantOffset;
import cn.yiwang.ctp.struct.CTPQryExchange;
import cn.yiwang.ctp.struct.CTPQryExchangeMarginRate;
import cn.yiwang.ctp.struct.CTPQryExchangeMarginRateAdjust;
import cn.yiwang.ctp.struct.CTPQryExchangeRate;
import cn.yiwang.ctp.struct.CTPQryExecOrder;
import cn.yiwang.ctp.struct.CTPQryForQuote;
import cn.yiwang.ctp.struct.CTPQryInstrument;
import cn.yiwang.ctp.struct.CTPQryInstrumentCommissionRate;
import cn.yiwang.ctp.struct.CTPQryInstrumentMarginRate;
import cn.yiwang.ctp.struct.CTPQryInvestor;
import cn.yiwang.ctp.struct.CTPQryInvestorPosition;
import cn.yiwang.ctp.struct.CTPQryInvestorPositionCombineDetail;
import cn.yiwang.ctp.struct.CTPQryInvestorPositionDetail;
import cn.yiwang.ctp.struct.CTPQryInvestorProductGroupMargin;
import cn.yiwang.ctp.struct.CTPQryNotice;
import cn.yiwang.ctp.struct.CTPQryOptionInstrCommRate;
import cn.yiwang.ctp.struct.CTPQryOptionInstrTradeCost;
import cn.yiwang.ctp.struct.CTPQryOrder;
import cn.yiwang.ctp.struct.CTPQryParkedOrder;
import cn.yiwang.ctp.struct.CTPQryParkedOrderAction;
import cn.yiwang.ctp.struct.CTPQryProduct;
import cn.yiwang.ctp.struct.CTPQryProductExchRate;
import cn.yiwang.ctp.struct.CTPQryQuote;
import cn.yiwang.ctp.struct.CTPQrySecAgentACIDMap;
import cn.yiwang.ctp.struct.CTPQrySettlementInfo;
import cn.yiwang.ctp.struct.CTPQrySettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPQryTrade;
import cn.yiwang.ctp.struct.CTPQryTradingAccount;
import cn.yiwang.ctp.struct.CTPQryTradingCode;
import cn.yiwang.ctp.struct.CTPQryTradingNotice;
import cn.yiwang.ctp.struct.CTPQryTransferBank;
import cn.yiwang.ctp.struct.CTPQryTransferSerial;
import cn.yiwang.ctp.struct.CTPQueryCFMMCTradingAccountToken;
import cn.yiwang.ctp.struct.CTPQueryMaxOrderVolume;
import cn.yiwang.ctp.struct.CTPRemoveParkedOrder;
import cn.yiwang.ctp.struct.CTPRemoveParkedOrderAction;
import cn.yiwang.ctp.struct.CTPReqAuthenticate;
import cn.yiwang.ctp.struct.CTPReqQueryAccount;
import cn.yiwang.ctp.struct.CTPReqTransfer;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTradingAccountPasswordUpdate;
import cn.yiwang.ctp.struct.CTPUserLogout;
import cn.yiwang.ctp.struct.CTPUserPasswordUpdate;

/**
 * CTP交易接口
 * 
 * @author Wang
 * @version 1.0
 */
public class CThostFtdcTraderApi {
    static {
        //System.loadLibrary("thosttraderapi");
        System.loadLibrary("ctpjni");
    }

    // 查询流量限制
    // ReqQryXXX,每秒钟最多只能进行一次查询操作,在途的查询操作最多只能有一个
    // 报单流量限制
    // 在一个连接会话中,每个客户端每秒钟最多只能发送6笔交易相关的指令(报单，撤单等)
    // 同一个账户同时最多只能建立6个会话

    /**
     * 创建TraderApi
     */
    public native void createFtdcTraderApi();

    /**
     * 创建TraderApi
     * 
     * @param flowPath
     *            存贮订阅信息文件的目录，默认为当前目录
     * @return
     */
    public native void createFtdcTraderApi(String flowPath);

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
    public native void registerSpi(CThostFtdcTraderSpi spi);

    /**
     * 订阅私有流
     * 
     * @param resumeType
     *            私有流重传方式(该方法要在Init方法前调用。若不调用则不会收到私有流的数据)
     */
    public native void subscribePrivateTopic(int resumeType);

    /**
     * 订阅公共流
     * 
     * @param nResumeType
     *            公共流重传方式(该方法要在Init方法前调用。若不调用则不会收到公共流的数据)
     */
    public native void subscribePublicTopic(int nResumeType);

    // /客户端认证请求
    public native int reqAuthenticate(CTPReqAuthenticate reqAuthenticate,
            int requestID);

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

    // /用户口令更新请求
    public native int ReqUserPasswordUpdate(
            CTPUserPasswordUpdate uerPasswordUpdate, int requestID);

    // /资金账户口令更新请求
    public native int ReqTradingAccountPasswordUpdate(
            CTPTradingAccountPasswordUpdate tradingAccountPasswordUpdate,
            int requestID);

    /**
     * 报单录入请求
     * 
     * @param inputOrder
     *            输入报单
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqOrderInsert(CTPInputOrder inputOrder, int requestID);

    // /预埋单录入请求
    public native int ReqParkedOrderInsert(CTPParkedOrder parkedOrder,
            int requestID);

    // /预埋撤单录入请求
    public native int ReqParkedOrderAction(
            CTPParkedOrderAction parkedOrderAction, int requestID);

    /**
     * 报单操作请求
     * 
     * @param inputOrderAction
     *            输入报单操作
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqOrderAction(CTPInputOrderAction inputOrderAction,
            int requestID);

    // /查询最大报单数量请求
    public native int ReqQueryMaxOrderVolume(
            CTPQueryMaxOrderVolume queryMaxOrderVolume, int requestID);

    /**
     * 投资者结算结果确认
     * 
     * @param settlementInfoConfirm
     *            投资者结算结果确认信息
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqSettlementInfoConfirm(
            CTPSettlementInfoConfirm settlementInfoConfirm, int requestID);

    // /请求删除预埋单
    public native int ReqRemoveParkedOrder(
            CTPRemoveParkedOrder removeParkedOrder, int requestID);

    // /请求删除预埋撤单
    public native int ReqRemoveParkedOrderAction(
            CTPRemoveParkedOrderAction removeParkedOrderAction, int requestID);

    // /执行宣告录入请求
    public native int ReqExecOrderInsert(CTPInputExecOrder inputExecOrder,
            int requestID);

    // /执行宣告操作请求
    public native int ReqExecOrderAction(
            CTPInputExecOrderAction inputExecOrderAction, int requestID);

    // /询价录入请求
    public native int ReqForQuoteInsert(CTPInputForQuote inputForQuote,
            int requestID);

    // /报价录入请求
    public native int ReqQuoteInsert(CTPInputQuote inputQuote, int requestID);

    // /报价操作请求
    public native int ReqQuoteAction(CTPInputQuoteAction inputQuoteAction,
            int requestID);

    // /申请组合录入请求
    public native int ReqCombActionInsert(CTPInputCombAction inputCombAction,
            int requestID);

    // /请求查询报单
    public native int ReqQryOrder(CTPQryOrder qryOrder, int requestID);

    // /请求查询成交
    public native int ReqQryTrade(CTPQryTrade qryTrade, int requestID);

    /**
     * 请求查询投资者持仓
     * 
     * @param qryInvestorPosition
     *            查询投资者持仓
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryInvestorPosition(
            CTPQryInvestorPosition qryInvestorPosition, int requestID);

    /**
     * 请求查询资金账户
     * 
     * @param qryTradingAccount
     *            查询资金账户
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryTradingAccount(
            CTPQryTradingAccount qryTradingAccount, int requestID);

    // /请求查询投资者
    public native int ReqQryInvestor(CTPQryInvestor qryInvestor, int requestID);

    // /请求查询交易编码
    public native int ReqQryTradingCode(CTPQryTradingCode qryTradingCode,
            int requestID);

    /**
     * 请求查询合约保证金率
     * 
     * @param qryInstrumentMarginRate
     *            查询合约保证金率
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryInstrumentMarginRate(
            CTPQryInstrumentMarginRate qryInstrumentMarginRate, int requestID);

    /**
     * 请求查询合约手续费率
     * 
     * @param qryInstrumentCommissionRate
     *            查询手续费率
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryInstrumentCommissionRate(
            CTPQryInstrumentCommissionRate qryInstrumentCommissionRate,
            int requestID);

    /**
     * 请求查询交易所
     * 
     * @param qryExchange
     *            查询交易所
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryExchange(CTPQryExchange qryExchange, int requestID);

    // /请求查询产品
    public native int ReqQryProduct(CTPQryProduct qryProduct, int requestID);

    /**
     * 请求查询合约
     * 
     * @param qryInstrument
     *            查询合约
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryInstrument(CTPQryInstrument qryInstrument,
            int requestID);

    // /请求查询行情
    public native int ReqQryDepthMarketData(
            CTPQryDepthMarketData qryDepthMarketData, int requestID);

    /**
     * 请求查询投资者结算结果
     * 
     * @param qrySettlementInfo
     *            投资者结算结果
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQrySettlementInfo(
            CTPQrySettlementInfo qrySettlementInfo, int requestID);

    // /请求查询转帐银行
    public native int ReqQryTransferBank(CTPQryTransferBank qryTransferBank,
            int requestID);

    /**
     * 请求查询投资者持仓明细
     * 
     * @param qryInvestorPositionDetail
     *            查询投资者持仓明细
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQryInvestorPositionDetail(
            CTPQryInvestorPositionDetail qryInvestorPositionDetail,
            int requestID);

    // /请求查询客户通知
    public native int ReqQryNotice(CTPQryNotice qryNotice, int requestID);

    /**
     * 请求查询结算信息确认
     * 
     * @param qrySettlementInfoConfirm
     *            查询结算信息确认
     * @param requestID
     *            请求编号
     * @return 返回值 0:发送成功, -1:因网络原因发送失败, -2:未处理请求队列总数量超限, -3:每秒发送请求数量超限
     */
    public native int reqQrySettlementInfoConfirm(
            CTPQrySettlementInfoConfirm qrySettlementInfoConfirm, int requestID);

    // /请求查询投资者持仓明细
    public native int ReqQryInvestorPositionCombineDetail(
            CTPQryInvestorPositionCombineDetail qryInvestorPositionCombineDetail,
            int requestID);

    // /请求查询保证金监管系统经纪公司资金账户密钥
    public native int ReqQryCFMMCTradingAccountKey(
            CTPQryCFMMCTradingAccountKey qryCFMMCTradingAccountKey,
            int requestID);

    // /请求查询仓单折抵信息
    public native int ReqQryEWarrantOffset(
            CTPQryEWarrantOffset qryEWarrantOffset, int requestID);

    // /请求查询投资者品种/跨品种保证金
    public native int ReqQryInvestorProductGroupMargin(
            CTPQryInvestorProductGroupMargin qryInvestorProductGroupMargin,
            int requestID);

    // /请求查询交易所保证金率
    public native int ReqQryExchangeMarginRate(
            CTPQryExchangeMarginRate qryExchangeMarginRate, int requestID);

    // /请求查询交易所调整保证金率
    public native int ReqQryExchangeMarginRateAdjust(
            CTPQryExchangeMarginRateAdjust qryExchangeMarginRateAdjust,
            int requestID);

    // /请求查询汇率
    public native int ReqQryExchangeRate(CTPQryExchangeRate qryExchangeRate,
            int requestID);

    // /请求查询二级代理操作员银期权限
    public native int ReqQrySecAgentACIDMap(
            CTPQrySecAgentACIDMap qrySecAgentACIDMap, int requestID);

    // /请求查询产品报价汇率
    public native int ReqQryProductExchRate(
            CTPQryProductExchRate qryProductExchRate, int requestID);

    // /请求查询期权交易成本
    public native int ReqQryOptionInstrTradeCost(
            CTPQryOptionInstrTradeCost qryOptionInstrTradeCost, int requestID);

    // /请求查询期权合约手续费
    public native int ReqQryOptionInstrCommRate(
            CTPQryOptionInstrCommRate qryOptionInstrCommRate, int requestID);

    // /请求查询执行宣告
    public native int ReqQryExecOrder(CTPQryExecOrder qryExecOrder,
            int requestID);

    // /请求查询询价
    public native int ReqQryForQuote(CTPQryForQuote qryForQuote, int requestID);

    // /请求查询报价
    public native int ReqQryQuote(CTPQryQuote qryQuote, int requestID);

    // /请求查询组合合约安全系数
    public native int ReqQryCombInstrumentGuard(
            CTPQryCombInstrumentGuard qryCombInstrumentGuard, int requestID);

    // /请求查询申请组合
    public native int ReqQryCombAction(CTPQryCombAction qryCombAction,
            int requestID);

    // /请求查询转帐流水
    public native int ReqQryTransferSerial(
            CTPQryTransferSerial qryTransferSerial, int requestID);

    // /请求查询银期签约关系
    public native int ReqQryAccountregister(
            CTPQryAccountregister qryAccountregister, int requestID);

    // /请求查询签约银行
    public native int ReqQryContractBank(CTPQryContractBank qryContractBank,
            int requestID);

    // /请求查询预埋单
    public native int ReqQryParkedOrder(CTPQryParkedOrder qryParkedOrder,
            int requestID);

    // /请求查询预埋撤单
    public native int ReqQryParkedOrderAction(
            CTPQryParkedOrderAction qryParkedOrderAction, int requestID);

    // /请求查询交易通知
    public native int ReqQryTradingNotice(CTPQryTradingNotice qryTradingNotice,
            int requestID);

    // /请求查询经纪公司交易参数
    public native int ReqQryBrokerTradingParams(
            CTPQryBrokerTradingParams qryBrokerTradingParams, int requestID);

    // /请求查询经纪公司交易算法
    public native int ReqQryBrokerTradingAlgos(
            CTPQryBrokerTradingAlgos qryBrokerTradingAlgos, int requestID);

    // /请求查询监控中心用户令牌
    public native int ReqQueryCFMMCTradingAccountToken(
            CTPQueryCFMMCTradingAccountToken queryCFMMCTradingAccountToken,
            int requestID);

    // /期货发起银行资金转期货请求
    public native int ReqFromBankToFutureByFuture(CTPReqTransfer reqTransfer,
            int requestID);

    // /期货发起期货资金转银行请求
    public native int ReqFromFutureToBankByFuture(CTPReqTransfer reqTransfer,
            int requestID);

    // /期货发起查询银行余额请求
    public native int ReqQueryBankAccountMoneyByFuture(
            CTPReqQueryAccount reqQueryAccount, int requestID);

}

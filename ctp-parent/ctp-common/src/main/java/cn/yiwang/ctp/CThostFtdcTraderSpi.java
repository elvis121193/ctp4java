package cn.yiwang.ctp;

import cn.yiwang.ctp.struct.CTPExchange;
import cn.yiwang.ctp.struct.CTPInputOrder;
import cn.yiwang.ctp.struct.CTPInputOrderAction;
import cn.yiwang.ctp.struct.CTPInstrument;
import cn.yiwang.ctp.struct.CTPInstrumentCommissionRate;
import cn.yiwang.ctp.struct.CTPInstrumentMarginRate;
import cn.yiwang.ctp.struct.CTPInvestorPosition;
import cn.yiwang.ctp.struct.CTPInvestorPositionDetail;
import cn.yiwang.ctp.struct.CTPOrder;
import cn.yiwang.ctp.struct.CTPOrderAction;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSettlementInfo;
import cn.yiwang.ctp.struct.CTPSettlementInfoConfirm;
import cn.yiwang.ctp.struct.CTPTrade;
import cn.yiwang.ctp.struct.CTPTradingAccount;
import cn.yiwang.ctp.struct.CTPUserLogout;

/**
 * CTP交易回调接口
 * 
 * @author Wang
 * @version 1.0
 */
public interface CThostFtdcTraderSpi {

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
     * 请求查询交易所响应
     * 
     * @param exchange
     *            交易所
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryExchange(CTPExchange exchange, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 请求查询合约响应
     * 
     * @param instrument
     *            合约
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryInstrument(CTPInstrument instrument,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 请求查询投资者持仓响应
     * 
     * @param investorPosition
     *            投资者持仓
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryInvestorPosition(CTPInvestorPosition investorPosition,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 请求查询资金账户响应
     * 
     * @param tradingAccount
     *            资金账户
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryTradingAccount(CTPTradingAccount tradingAccount,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 报单录入请求响应
     * 
     * @param inputOrder
     *            输入报单
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 报单录入错误回报
     * 
     * @param inputOrder
     *            输入报单
     * @param rspInfo
     *            响应信息
     */
    public void onErrRtnOrderInsert(CTPInputOrder inputOrder, CTPRspInfo rspInfo);

    /**
     * 报单通知
     * 
     * @param order
     *            报单
     */
    public void onRtnOrder(CTPOrder order);

    /**
     * 成交通知
     * 
     * @param trade
     *            成交
     */
    public void onRtnTrade(CTPTrade trade);

    /**
     * 报单操作请求响应
     * 
     * @param inputOrderAction
     *            输入报单操作
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspOrderAction(CTPInputOrderAction inputOrderAction,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 报单操作错误回报
     * 
     * @param orderAction
     *            报单操作
     * @param rspInfo
     *            响应信息
     */
    public void onErrRtnOrderAction(CTPOrderAction orderAction,
            CTPRspInfo rspInfo);

    /**
     * 请求查询结算信息确认响应
     * 
     * @param settlementInfoConfirm
     *            投资者结算结果确认信息
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQrySettlementInfoConfirm(
            CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 投资者结算结果确认响应
     * 
     * @param settlementInfoConfirm
     *            投资者结算结果确认信息
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspSettlementInfoConfirm(
            CTPSettlementInfoConfirm settlementInfoConfirm, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 请求查询投资者结算结果响应
     * 
     * @param settlementInfo
     *            投资者结算结果
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQrySettlementInfo(CTPSettlementInfo settlementInfo,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 请求查询合约保证金率响应
     * 
     * @param instrumentMarginRate
     *            合约保证金率
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryInstrumentMarginRate(
            CTPInstrumentMarginRate instrumentMarginRate, CTPRspInfo rspInfo,
            int requestID, boolean isLast);

    /**
     * 请求查询合约手续费率响应
     * 
     * @param instrumentCommissionRate
     *            合约手续费率
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryInstrumentCommissionRate(
            CTPInstrumentCommissionRate instrumentCommissionRate,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /**
     * 请求查询投资者持仓明细响应
     * 
     * @param investorPositionDetail
     *            投资者持仓明细
     * @param rspInfo
     *            响应信息
     * @param requestID
     *            请求编号
     * @param isLast
     *            是否最后数据包
     */
    public void onRspQryInvestorPositionDetail(
            CTPInvestorPositionDetail investorPositionDetail,
            CTPRspInfo rspInfo, int requestID, boolean isLast);

    /*
     * // /客户端认证响应 public void onRspAuthenticate(CTPRspAuthenticate
     * RspAuthenticate, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /用户口令更新请求响应 public void onRspUserPasswordUpdate( CTPUserPasswordUpdate
     * UserPasswordUpdate, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /资金账户口令更新请求响应 public void onRspTradingAccountPasswordUpdate(
     * CTPTradingAccountPasswordUpdate TradingAccountPasswordUpdate, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * 
     * 
     * // /预埋单录入请求响应 public void onRspParkedOrderInsert(CTPParkedOrder
     * ParkedOrder, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /预埋撤单录入请求响应 public void onRspParkedOrderAction(CTPParkedOrderAction
     * ParkedOrderAction, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * 
     * 
     * // /查询最大报单数量响应 public void onRspQueryMaxOrderVolume(
     * CTPQueryMaxOrderVolume QueryMaxOrderVolume, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * 
     * 
     * // /删除预埋单响应 public void onRspRemoveParkedOrder(CTPRemoveParkedOrder
     * RemoveParkedOrder, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /删除预埋撤单响应 public void onRspRemoveParkedOrderAction(
     * CTPRemoveParkedOrderAction RemoveParkedOrderAction, CTPRspInfo rspInfo,
     * int requestID, boolean isLast);
     * 
     * // /执行宣告录入请求响应 public void onRspExecOrderInsert(CTPInputExecOrder
     * InputExecOrder, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /执行宣告操作请求响应 public void onRspExecOrderAction( CTPInputExecOrderAction
     * InputExecOrderAction, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /询价录入请求响应 public void onRspForQuoteInsert(CTPInputForQuote
     * InputForQuote, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /报价录入请求响应 public void onRspQuoteInsert(CTPInputQuote InputQuote,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /报价操作请求响应 public void onRspQuoteAction(CTPInputQuoteAction
     * InputQuoteAction, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /申请组合录入请求响应 public void onRspCombActionInsert(CTPInputCombAction
     * InputCombAction, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询报单响应 public void onRspQryOrder(CTPOrder Order, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询成交响应 public void onRspQryTrade(CTPTrade Trade, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * 
     * // /请求查询投资者响应 public void onRspQryInvestor(CTPInvestor Investor,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询交易编码响应 public void onRspQryTradingCode(CTPTradingCode
     * TradingCode, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * 
     * 
     * 
     * 
     * // /请求查询交易所响应 public void onRspQryExchange(CTPExchange Exchange,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询产品响应 public void onRspQryProduct(CTPProduct Product, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询行情响应 public void onRspQryDepthMarketData(CTPDepthMarketData
     * DepthMarketData, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * 
     * // /请求查询转帐银行响应 public void onRspQryTransferBank(CTPTransferBank
     * TransferBank, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * 
     * // /请求查询客户通知响应 public void onRspQryNotice(CTPNotice Notice, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * 
     * 
     * // /请求查询投资者持仓明细响应 public void onRspQryInvestorPositionCombineDetail(
     * CTPInvestorPositionCombineDetail InvestorPositionCombineDetail,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /查询保证金监管系统经纪公司资金账户密钥响应 public void onRspQryCFMMCTradingAccountKey(
     * CTPCFMMCTradingAccountKey CFMMCTradingAccountKey, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询仓单折抵信息响应 public void onRspQryEWarrantOffset(CTPEWarrantOffset
     * EWarrantOffset, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询投资者品种/跨品种保证金响应 public void onRspQryInvestorProductGroupMargin(
     * CTPInvestorProductGroupMargin InvestorProductGroupMargin, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询交易所保证金率响应 public void onRspQryExchangeMarginRate(
     * CTPExchangeMarginRate ExchangeMarginRate, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询交易所调整保证金率响应 public void onRspQryExchangeMarginRateAdjust(
     * CTPExchangeMarginRateAdjust ExchangeMarginRateAdjust, CTPRspInfo rspInfo,
     * int requestID, boolean isLast);
     * 
     * // /请求查询汇率响应 public void onRspQryExchangeRate(CTPExchangeRate
     * ExchangeRate, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询二级代理操作员银期权限响应 public void
     * onRspQrySecAgentACIDMap(CTPSecAgentACIDMap SecAgentACIDMap, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询产品报价汇率 public void onRspQryProductExchRate(CTPProductExchRate
     * ProductExchRate, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询期权交易成本响应 public void onRspQryOptionInstrTradeCost(
     * CTPOptionInstrTradeCost OptionInstrTradeCost, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询期权合约手续费响应 public void onRspQryOptionInstrCommRate(
     * CTPOptionInstrCommRate OptionInstrCommRate, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询执行宣告响应 public void onRspQryExecOrder(CTPExecOrder ExecOrder,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询询价响应 public void onRspQryForQuote(CTPForQuote ForQuote,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询报价响应 public void onRspQryQuote(CTPQuote Quote, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询组合合约安全系数响应 public void onRspQryCombInstrumentGuard(
     * CTPCombInstrumentGuard CombInstrumentGuard, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询申请组合响应 public void onRspQryCombAction(CTPCombAction CombAction,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询转帐流水响应 public void onRspQryTransferSerial(CTPTransferSerial
     * TransferSerial, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询银期签约关系响应 public void onRspQryAccountregister(CTPAccountregister
     * Accountregister, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * // /合约交易状态通知 public void onRtnInstrumentStatus(CTPInstrumentStatus
     * InstrumentStatus);
     * 
     * // /交易通知 public void onRtnTradingNotice(CTPTradingNoticeInfo
     * TradingNoticeInfo);
     * 
     * // /提示条件单校验错误 public void onRtnErrorConditionalOrder(
     * CTPErrorConditionalOrder ErrorConditionalOrder);
     * 
     * // /执行宣告通知 public void onRtnExecOrder(CTPExecOrder ExecOrder);
     * 
     * // /执行宣告录入错误回报 public void OnErrRtnExecOrderInsert(CTPInputExecOrder
     * InputExecOrder, CTPRspInfo rspInfo);
     * 
     * // /执行宣告操作错误回报 public void OnErrRtnExecOrderAction(CTPExecOrderAction
     * ExecOrderAction, CTPRspInfo rspInfo);
     * 
     * // /询价录入错误回报 public void OnErrRtnForQuoteInsert(CTPInputForQuote
     * InputForQuote, CTPRspInfo rspInfo);
     * 
     * // /报价通知 public void onRtnQuote(CTPQuote Quote);
     * 
     * // /报价录入错误回报 public void OnErrRtnQuoteInsert(CTPInputQuote InputQuote,
     * CTPRspInfo rspInfo);
     * 
     * // /报价操作错误回报 public void OnErrRtnQuoteAction(CTPQuoteAction QuoteAction,
     * CTPRspInfo rspInfo);
     * 
     * // /询价通知 public void onRtnForQuoteRsp(CTPForQuoteRsp ForQuoteRsp);
     * 
     * // /保证金监控中心用户令牌 public void onRtnCFMMCTradingAccountToken(
     * CTPCFMMCTradingAccountToken CFMMCTradingAccountToken);
     * 
     * // /申请组合通知 public void onRtnCombAction(CTPCombAction CombAction);
     * 
     * // /申请组合录入错误回报 public void OnErrRtnCombActionInsert(CTPInputCombAction
     * InputCombAction, CTPRspInfo rspInfo);
     * 
     * // /请求查询签约银行响应 public void onRspQryContractBank(CTPContractBank
     * ContractBank, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询预埋单响应 public void onRspQryParkedOrder(CTPParkedOrder ParkedOrder,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询预埋撤单响应 public void onRspQryParkedOrderAction(
     * CTPParkedOrderAction ParkedOrderAction, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询交易通知响应 public void onRspQryTradingNotice(CTPTradingNotice
     * TradingNotice, CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /请求查询经纪公司交易参数响应 public void onRspQryBrokerTradingParams(
     * CTPBrokerTradingParams BrokerTradingParams, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询经纪公司交易算法响应 public void onRspQryBrokerTradingAlgos(
     * CTPBrokerTradingAlgos BrokerTradingAlgos, CTPRspInfo rspInfo, int
     * requestID, boolean isLast);
     * 
     * // /请求查询监控中心用户令牌 public void onRspQueryCFMMCTradingAccountToken(
     * CTPQueryCFMMCTradingAccountToken QueryCFMMCTradingAccountToken,
     * CTPRspInfo rspInfo, int requestID, boolean isLast);
     * 
     * // /银行发起银行资金转期货通知 public void onRtnFromBankToFutureByBank(CTPRspTransfer
     * RspTransfer);
     * 
     * // /银行发起期货资金转银行通知 public void onRtnFromFutureToBankByBank(CTPRspTransfer
     * RspTransfer);
     * 
     * // /银行发起冲正银行转期货通知 public void
     * onRtnRepealFromBankToFutureByBank(CTPRspRepeal RspRepeal);
     * 
     * // /银行发起冲正期货转银行通知 public void
     * onRtnRepealFromFutureToBankByBank(CTPRspRepeal RspRepeal);
     * 
     * // /期货发起银行资金转期货通知 public void
     * onRtnFromBankToFutureByFuture(CTPRspTransfer RspTransfer);
     * 
     * // /期货发起期货资金转银行通知 public void
     * onRtnFromFutureToBankByFuture(CTPRspTransfer RspTransfer);
     * 
     * // /系统运行时期货端手工发起冲正银行转期货请求，银行处理完毕后报盘发回的通知 public void
     * onRtnRepealFromBankToFutureByFutureManual(CTPRspRepeal RspRepeal);
     * 
     * // /系统运行时期货端手工发起冲正期货转银行请求，银行处理完毕后报盘发回的通知 public void
     * onRtnRepealFromFutureToBankByFutureManual(CTPRspRepeal RspRepeal);
     * 
     * // /期货发起查询银行余额通知 public void onRtnQueryBankBalanceByFuture(
     * CTPNotifyQueryAccount NotifyQueryAccount);
     * 
     * // /期货发起银行资金转期货错误回报 public void
     * OnErrRtnBankToFutureByFuture(CTPReqTransfer ReqTransfer, CTPRspInfo
     * rspInfo);
     * 
     * // /期货发起期货资金转银行错误回报 public void
     * OnErrRtnFutureToBankByFuture(CTPReqTransfer ReqTransfer, CTPRspInfo
     * rspInfo);
     * 
     * // /系统运行时期货端手工发起冲正银行转期货错误回报 public void
     * OnErrRtnRepealBankToFutureByFutureManual( CTPReqRepeal ReqRepeal,
     * CTPRspInfo rspInfo);
     * 
     * // /系统运行时期货端手工发起冲正期货转银行错误回报 public void
     * OnErrRtnRepealFutureToBankByFutureManual( CTPReqRepeal ReqRepeal,
     * CTPRspInfo rspInfo);
     * 
     * // /期货发起查询银行余额错误回报 public void OnErrRtnQueryBankBalanceByFuture(
     * CTPReqQueryAccount ReqQueryAccount, CTPRspInfo rspInfo);
     * 
     * // /期货发起冲正银行转期货请求，银行处理完毕后报盘发回的通知 public void
     * onRtnRepealFromBankToFutureByFuture(CTPRspRepeal RspRepeal);
     * 
     * // /期货发起冲正期货转银行请求，银行处理完毕后报盘发回的通知 public void
     * onRtnRepealFromFutureToBankByFuture(CTPRspRepeal RspRepeal);
     * 
     * // /期货发起银行资金转期货应答 public void
     * onRspFromBankToFutureByFuture(CTPReqTransfer ReqTransfer, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /期货发起期货资金转银行应答 public void
     * onRspFromFutureToBankByFuture(CTPReqTransfer ReqTransfer, CTPRspInfo
     * rspInfo, int requestID, boolean isLast);
     * 
     * // /期货发起查询银行余额应答 public void onRspQueryBankAccountMoneyByFuture(
     * CTPReqQueryAccount ReqQueryAccount, CTPRspInfo rspInfo, int requestID,
     * boolean isLast);
     * 
     * // /银行发起银期开户通知 public void onRtnOpenAccountByBank(CTPOpenAccount
     * OpenAccount);
     * 
     * // /银行发起银期销户通知 public void onRtnCancelAccountByBank(CTPCancelAccount
     * CancelAccount);
     * 
     * // /银行发起变更银行账号通知 public void onRtnChangeAccountByBank(CTPChangeAccount
     * ChangeAccount);
     */

}

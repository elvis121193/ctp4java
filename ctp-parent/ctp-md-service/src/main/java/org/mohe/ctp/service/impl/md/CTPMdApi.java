package org.mohe.ctp.service.impl.md;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.mohe.ctp.entity.Tick;
import org.mohe.ctp.service.md.QuotaCallback;
import org.mohe.ctp.util.DateTimeUtil;

import cn.yiwang.ctp.CThostFtdcMdApi;
import cn.yiwang.ctp.CThostFtdcMdSpi;
import cn.yiwang.ctp.struct.CTPDepthMarketData;
import cn.yiwang.ctp.struct.CTPForQuoteRsp;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSpecificInstrument;
import cn.yiwang.ctp.struct.CTPUserLogout;

/**
 * CTP行情接口
 * 
 * @author Elvis
 * 
 */
public final class CTPMdApi implements CThostFtdcMdSpi {

	private final static Logger logger = Logger.getLogger(CTPMdApi.class);

	/**
	 * 行情前置连接地址
	 */
	private String frontAddress;

	/**
	 * 流文件
	 */
	private String flowPath;

	/**
	 * 登录状态
	 */
	private boolean isLogined;

	/**
	 * 连接状态
	 */
	private boolean isConntected;

	/**
	 * 订阅的合约列表
	 */
	private Set<String> subscribedSysmbols = new HashSet<String>();

	/**
	 * 请求ID
	 */
	private final static AtomicInteger reqId = new AtomicInteger();

	/**
	 * ctp接口
	 */
	private CThostFtdcMdApi mdApi;

	/**
	 * 行情推送接口
	 */
	private QuotaCallback callback;

	public String getFlowPath() {
		return flowPath;
	}

	public void setFlowPath(String flowPath) {
		this.flowPath = flowPath;
	}

	public String getFrontAddress() {
		return frontAddress;
	}

	public void setFrontAddress(String frontAddress) {
		this.frontAddress = frontAddress;
	}

	public CTPMdApi() {
		isConntected = false;
		isLogined = false;

	}

	public void onFrontConnected() {
		logger.info("行情服务器连接成功");
		isConntected = true;
		login();

	}

	public void onFrontDisconnected(int reason) {
		logger.info("行情服务器连接断开");
		isConntected = false;
		isLogined = false;
	}

	public void onHeartBeatWarning(int timeLapse) {

	}

	public void onRspUserLogin(CTPRspUserLogin rspUserLogin,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {
		if (rspInfo.ErrorID == 0) {
			isLogined = true;
			logger.info("行情服务器登录完成");
			// 重新订阅之前订阅的行情
			String[] instruments = (String[]) subscribedSysmbols
					.toArray(new String[subscribedSysmbols.size()]);
			subscribe(instruments);
		} else
			logger.error("登录错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
	}

	public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		if (rspInfo.ErrorID == 0) {
			isLogined = false;
			logger.info("行情服务器登出完成");
		} else
			logger.error("登出错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
	}

	public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast) {
		logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
	}

	public void onRspSubMarketData(CTPSpecificInstrument specificInstrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRspUnSubMarketData(CTPSpecificInstrument specificInstrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRspSubForQuoteRsp(CTPSpecificInstrument specificInstrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRspUnSubForQuoteRsp(CTPSpecificInstrument specificInstrument,
			CTPRspInfo rspInfo, int requestID, boolean isLast) {

	}

	public void onRtnDepthMarketData(CTPDepthMarketData depthMarketData) {
		if (callback != null) {
			Tick tick = new Tick();
			tick.setAskPrice(depthMarketData.AskPrice1);
			tick.setAskVolume(depthMarketData.AskVolume1);
			tick.setAvgragePrice(depthMarketData.AveragePrice);
			tick.setBidVolume(depthMarketData.BidVolume1);
			tick.setBikPrice(depthMarketData.BidPrice1);
			tick.setClosePrice(depthMarketData.ClosePrice);
			tick.setExchangeId(depthMarketData.ExchangeID);
			tick.setExchangeInstId(depthMarketData.ExchangeInstID);
			tick.setHighestPrice(depthMarketData.HighestPrice);
			tick.setInstrumentId(depthMarketData.InstrumentID);
			tick.setLastPrice(depthMarketData.LastPrice);
			tick.setLowerLimitPrice(depthMarketData.LowerLimitPrice);
			tick.setLowestPrice(depthMarketData.LowestPrice);
			tick.setOpenInterest(depthMarketData.OpenInterest);
			tick.setOpenPrice(depthMarketData.OpenPrice);
			tick.setPreClosePrice(depthMarketData.PreClosePrice);
			tick.setPreOpenInterest(depthMarketData.PreOpenInterest);
			tick.setPreSettlementPrice(depthMarketData.PreSettlementPrice);
			tick.setTurnover(depthMarketData.Turnover);
			tick.setUpperLimitPrice(depthMarketData.UpperLimitPrice);
			tick.setVolume(depthMarketData.Volume);
			tick.setTradingDay(depthMarketData.TradingDay);
			tick.setUpdateTime(depthMarketData.UpdateTime);
			tick.setUpdateMillsec(depthMarketData.UpdateMillisec);
			tick.setTimeTag(Long.valueOf(DateTimeUtil.getCurrTime()));
			callback.onTick(tick);
		}
	}

	public void onRtnForQuoteRsp(CTPForQuoteRsp forQuoteRsp) {

	}

	public void login() {
		CTPReqUserLogin reqUserLogin = new CTPReqUserLogin();
		mdApi.reqUserLogin(reqUserLogin, reqId.getAndIncrement());
	}

	public void subscribe(String[] instruments) {
		// 这里的设计是，如果尚未登录就调用了订阅方法
		// 则先保存订阅请求，登录完成后会自动订阅
		if (instruments == null || instruments.length == 0) {
			return;
		}
		if (isLogined) {
			mdApi.subscribeMarketData(instruments, instruments.length);
		}
		// 订阅的代码都放在本地列表中
		for (int i = 0; i < instruments.length; i++) {
			String inst = instruments[i];
			subscribedSysmbols.add(inst);
		}
	}

	/**
	 * 退订
	 * 
	 * @param instruments
	 */
	public void unSubscribe(String[] instruments) {
		if (instruments == null || instruments.length == 0) {
			return;
		}

		if (isLogined) {
			mdApi.unSubscribeMarketData(instruments, instruments.length);
		}
	}

	public void connect() {
		// 如果尚未建立服务器连接，则进行连接
		if (!isConntected) {
			File file = new File(flowPath);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			mdApi = new CThostFtdcMdApi();
			mdApi.createFtdcMdApi(flowPath);
			mdApi.registerFront(frontAddress);
			mdApi.registerSpi(this);
			mdApi.init();
		} else if (!isLogined) {
			this.login();
		}

	}

	/**
	 * 注册行情推送
	 * 
	 * @param callback
	 */
	public void registerQuotaCallback(QuotaCallback callback) {
		this.callback = callback;
	}
	
	public void destroy(){
		if (mdApi != null){
			mdApi.release();
		}
	}

}

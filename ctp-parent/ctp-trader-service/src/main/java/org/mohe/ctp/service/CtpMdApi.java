package org.mohe.ctp.service;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.mohe.ctp.dto.ErrorDTO;
import org.mohe.ctp.dto.TickDTO;
import org.mohe.ctp.service.td.GatewayService;

import cn.yiwang.ctp.CThostFtdcMdApi;
import cn.yiwang.ctp.CThostFtdcMdSpi;
import cn.yiwang.ctp.struct.CTPDepthMarketData;
import cn.yiwang.ctp.struct.CTPForQuoteRsp;
import cn.yiwang.ctp.struct.CTPReqUserLogin;
import cn.yiwang.ctp.struct.CTPRspInfo;
import cn.yiwang.ctp.struct.CTPRspUserLogin;
import cn.yiwang.ctp.struct.CTPSpecificInstrument;
import cn.yiwang.ctp.struct.CTPUserLogout;

public class CtpMdApi implements CThostFtdcMdSpi {

	private final static Logger logger = Logger.getLogger(CtpMdApi.class);

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
	 * 网关
	 */
	private GatewayService gateway;

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

	public CtpMdApi(GatewayService gateway) {
		isConntected = false;
		isLogined = false;
		this.gateway = gateway;
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
		} else {
			logger.error("登录错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
			if (gateway != null) {
				ErrorDTO error = new ErrorDTO();
				error.setErrorNo(rspInfo.ErrorID);
				error.setErrorMsg(rspInfo.ErrorMsg);
				gateway.onError(error);
			}
		}
	}

	public void onRspUserLogout(CTPUserLogout userLogout, CTPRspInfo rspInfo,
			int requestID, boolean isLast) {
		if (rspInfo.ErrorID == 0) {
			isLogined = false;
			logger.info("行情服务器登出完成");
		} else {
			logger.error("登出错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
			if (gateway != null) {
				ErrorDTO error = new ErrorDTO();
				error.setErrorNo(rspInfo.ErrorID);
				error.setErrorMsg(rspInfo.ErrorMsg);
				gateway.onError(error);
			}
		}
	}

	public void onRspError(CTPRspInfo rspInfo, int requestID, boolean isLast) {
		logger.error("发生错误:错误号" + rspInfo.ErrorID + ": " + rspInfo.ErrorMsg);
		if (gateway != null) {
			ErrorDTO error = new ErrorDTO();
			error.setErrorNo(rspInfo.ErrorID);
			error.setErrorMsg(rspInfo.ErrorMsg);
			gateway.onError(error);
		}
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
		if (gateway != null) {
			TickDTO tick = new TickDTO();
			tick.setGatewayName(gateway.getGatewayName());
			
			tick.setSymbol(depthMarketData.InstrumentID);
			tick.setExchange(depthMarketData.ExchangeID);
			tick.setLastPrice(depthMarketData.LastPrice);
			tick.setHighPrice(depthMarketData.HighestPrice);
			tick.setLowPrice(depthMarketData.LowestPrice);
			tick.setPreClosePrice(depthMarketData.PreClosePrice);
			tick.setUpperLimit(depthMarketData.UpperLimitPrice);
			tick.setLowerLimit(depthMarketData.LowerLimitPrice);
			
			tick.setBidPrice1(depthMarketData.BidPrice1);
			tick.setBidVolume1(depthMarketData.BidVolume1);
			tick.setAskPrice1(depthMarketData.AskPrice1);
			tick.setAskVolume1(depthMarketData.AskVolume1);
			
			gateway.onTick(tick);
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

	public void destroy() {
		if (mdApi != null) {
			mdApi.release();
		}
	}

}

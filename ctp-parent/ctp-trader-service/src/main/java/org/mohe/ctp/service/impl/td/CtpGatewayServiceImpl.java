package org.mohe.ctp.service.impl.td;

import org.apache.log4j.Logger;
import org.mohe.ctp.dto.AccountDTO;
import org.mohe.ctp.dto.CancelOrderReq;
import org.mohe.ctp.dto.ErrorDTO;
import org.mohe.ctp.dto.OrderDTO;
import org.mohe.ctp.dto.OrderReq;
import org.mohe.ctp.dto.PositionDTO;
import org.mohe.ctp.dto.TickDTO;
import org.mohe.ctp.dto.TradeDTO;
import org.mohe.ctp.entity.Contract;
import org.mohe.ctp.service.CtpMdApi;
import org.mohe.ctp.service.CtpTdApi;
import org.mohe.ctp.service.td.GatewayService;

/**
 * Ctp网关实现类
 * @author Elvis
 *
 */
public class CtpGatewayServiceImpl implements GatewayService {
	
	private final static Logger logger = Logger.getLogger(CtpGatewayServiceImpl.class);
	/**
	 * 行情接口
	 */
	private CtpMdApi mdApi;
	
	/**
	 * 交易接口
	 */
	private CtpTdApi tdApi;
	
	/**
	 * 行情是否连接
	 */
	private volatile boolean mdConnected;
	
	/**
	 * 交易是否连接
	 */
	private volatile  boolean tdConnected;
	
	private boolean qryEnabled;
	
	
	private String userId;
	
	private String tdFrontAddress;
	
	private String mdFrontAddress;
	
	private String brokerId;
	
	private String password;
	
	private String tdFlowPath;
	
	private String mdFlowPath;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTdFrontAddress() {
		return tdFrontAddress;
	}

	public void setTdFrontAddress(String tdFrontAddress) {
		this.tdFrontAddress = tdFrontAddress;
	}

	public String getMdFrontAddress() {
		return mdFrontAddress;
	}

	public void setMdFrontAddress(String mdFrontAddress) {
		this.mdFrontAddress = mdFrontAddress;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTdFlowPath() {
		return tdFlowPath;
	}

	public void setTdFlowPath(String tdFlowPath) {
		this.tdFlowPath = tdFlowPath;
	}

	public String getMdFlowPath() {
		return mdFlowPath;
	}

	public void setMdFlowPath(String mdFlowPath) {
		this.mdFlowPath = mdFlowPath;
	}

	public CtpGatewayServiceImpl(){
		mdApi = new CtpMdApi(this);
		tdApi = new CtpTdApi(this);
		mdConnected = false;
		tdConnected = false;
		
		qryEnabled = false;
	}
	
	public void connect(){
		mdApi.connect(mdFlowPath, mdFrontAddress);
		tdApi.connect(tdFlowPath, tdFrontAddress, userId, brokerId, password);
		
		logger.info("连接成功");
		//initQuery();
	}
	
	public void initQuery(){
		if(qryEnabled){
			logger.info("查询账户信息");
			qryAccount();
			logger.info("查询账户持仓");
			qryPosition();
		}
	}
	
	public void destroy(){
		if (mdConnected){
			mdApi.destroy();
		}
		if(tdConnected){
			tdApi.destroy();
		}
	}

	public void onTick(TickDTO tick) {
		logger.info("行情Tick");
	}

	public void onTrade(TradeDTO trade) {
		logger.info("成交");
	}

	public void onOrder(OrderDTO order) {
		logger.info("订单");
	}

	public void onPosition(PositionDTO position) {
		logger.info("持仓点位");
	}

	public void onAccount(AccountDTO account) {
		logger.info("账户信息");
	}

	public void onError(ErrorDTO error) {
		logger.info("错误");
	}

	public void sendOrder(OrderReq orderReq) {
		logger.info("下单");
		tdApi.sendOrder(orderReq);
	}

	public void cancelOrder(CancelOrderReq cancelOrderReq) {
		logger.info("撤单");
		tdApi.cancelOrder(cancelOrderReq);
	}

	public void qryAccount() {
		tdApi.qryAccount();
	}

	public void qryPosition() {
		tdApi.qryPosition();
	}

	public void subscribe(String[] instruments) {
		do{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!mdConnected);
		mdApi.subscribe(instruments);
	}

	public void setTdConnected(boolean isConnected) {
		this.tdConnected = isConnected;
	}

	public void setMdConnected(boolean isConnected) {
		this.mdConnected = isConnected;
	}

	public String getGatewayName() {
		return "CTP";
	}

	public void onContract(Contract contract) {
		
	}

}

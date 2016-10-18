package org.mohe.ctp.service;


import org.apache.log4j.Logger;
import org.mohe.ctp.dao.InstrumentDao;
import org.mohe.ctp.dao.InvestorPositionDao;
import org.mohe.ctp.dao.OrderDao;
import org.mohe.ctp.dao.TickDao;
import org.mohe.ctp.dao.TradeDao;
import org.mohe.ctp.dao.TradingAccountDao;
import org.mohe.ctp.entity.Account;
import org.mohe.ctp.entity.CancelOrderReq;
import org.mohe.ctp.entity.Contract;
import org.mohe.ctp.entity.ErrorDTO;
import org.mohe.ctp.entity.Order;
import org.mohe.ctp.entity.OrderReq;
import org.mohe.ctp.entity.Position;
import org.mohe.ctp.entity.Tick;
import org.mohe.ctp.entity.Trade;
import org.mohe.ctp.gateway.Gateway;
import org.springframework.beans.factory.annotation.Autowired;

public final class CtpGateway implements Gateway {
	
	private final static Logger logger = Logger.getLogger(CtpGateway.class);
	
	/**
	 * 行情接口
	 */
	private MyMdSpi mdApi;
	
	/**
	 * 交易接口
	 */
	private MyTdSpi tdApi;
	
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
	
	@Autowired
	private TradeDao tradeDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TradingAccountDao tradingAccountDao;
	
	@Autowired
	private InstrumentDao instrumentDao;
	
	@Autowired
	private InvestorPositionDao positionDao;
	
	@Autowired
	private TickDao tickDao;
	
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

	public CtpGateway(){
		mdApi = new MyMdSpi(this);
		tdApi = new MyTdSpi(this);
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

	public void onTick(Tick tick) {
		logger.info("行情Tick");
		tickDao.save(tick);
	}

	public void onTrade(Trade trade) {
		logger.info("成交");
		tradeDao.save(trade);
	}

	public void onOrder(Order order) {
		logger.info("订单");
		orderDao.save(order);
	}

	public void onPosition(Position position) {
		logger.info("持仓点位");
		positionDao.save(position);
	}

	public void onAccount(Account account) {
		logger.info("账户信息");
		tradingAccountDao.save(account);
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
		instrumentDao.save(contract);
	}

	
}

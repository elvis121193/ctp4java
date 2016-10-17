package org.mohe.ctp.service.impl.td;

import org.mohe.ctp.dto.AccountDTO;
import org.mohe.ctp.dto.CancelOrderReq;
import org.mohe.ctp.dto.ErrorDTO;
import org.mohe.ctp.dto.OrderDTO;
import org.mohe.ctp.dto.OrderReq;
import org.mohe.ctp.dto.PositionDTO;
import org.mohe.ctp.dto.TickDTO;
import org.mohe.ctp.dto.TradeDTO;
import org.mohe.ctp.service.CtpMdApi;
import org.mohe.ctp.service.CtpTdApi;
import org.mohe.ctp.service.td.GatewayService;

public class CtpGatewayServiceImpl implements GatewayService {
	
	private CtpMdApi mdApi;
	
	private CtpTdApi tdApi;
	
	private boolean mdConnected;
	
	private boolean tdConnected;
	
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
		tdApi.connect(tdFlowPath, tdFrontAddress, userId, brokerId, password);
		mdApi.connect(mdFlowPath, mdFrontAddress);
		
		initQuery();
	}
	
	public void initQuery(){
		if(qryEnabled){
			qryAccount();
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

	}

	public void onTrade(TradeDTO trade) {

	}

	public void onOrder(OrderDTO order) {

	}

	public void onPosition(PositionDTO position) {

	}

	public void onAccount(AccountDTO account) {

	}

	public void onError(ErrorDTO error) {

	}

	public void sendOrder(OrderReq orderReq) {
		tdApi.sendOrder(orderReq);
	}

	public void cancelOrder(CancelOrderReq cancelOrderReq) {
		tdApi.cancelOrder(cancelOrderReq);
	}

	public void qryAccount() {
		tdApi.qryAccount();
	}

	public void qryPosition() {
		tdApi.qryPosition();
	}

	public void subscribe(String[] instruments) {
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

}

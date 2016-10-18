package org.mohe.ctp.gateway;

import org.mohe.ctp.entity.Account;
import org.mohe.ctp.entity.CancelOrderReq;
import org.mohe.ctp.entity.Contract;
import org.mohe.ctp.entity.ErrorDTO;
import org.mohe.ctp.entity.Order;
import org.mohe.ctp.entity.OrderReq;
import org.mohe.ctp.entity.Position;
import org.mohe.ctp.entity.Tick;
import org.mohe.ctp.entity.Trade;

public interface Gateway {
	
	/**
	 * 行情回调
	 * @param tick
	 */
	public void onTick(Tick tick);
	
	/**
	 * 成交回调
	 * @param trade
	 */
	public void onTrade(Trade trade);
	
	/**
	 * 订单回调
	 * @param order
	 */
	public void onOrder(Order order);
	
	/**
	 * 持仓回调
	 * @param position
	 */
	public void onPosition(Position position);
	
	/**
	 * 账户信息
	 * @param account
	 */
	public void onAccount(Account account);
	
	/**
	 * 异常处理
	 * @param error
	 */
	public void onError(ErrorDTO error);
	
	
	/**
	 * 合约信息
	 * @param contract
	 */
	public void onContract(Contract contract);
	
	/**
	 * 发单
	 * @param orderReq
	 */
	public void sendOrder(OrderReq orderReq);
	
	/**
	 * 撤单
	 * @param cancelOrderReq
	 */
	public void cancelOrder(CancelOrderReq cancelOrderReq);
	
	/**
	 * 查询账户
	 */
	public void qryAccount();
	
	/**
	 * 查询持仓
	 */
	public void qryPosition();
	
	/**
	 * 订阅行情
	 * @param instruments
	 */
	public void subscribe(String[] instruments);
	
	/**
	 * @param isConnected
	 */
	public void setTdConnected(boolean isConnected);
	
	/**
	 * @param isConnected
	 */
	public void setMdConnected(boolean isConnected);
	
	/**
	 * @return
	 */
	public String getGatewayName();
	
	
}

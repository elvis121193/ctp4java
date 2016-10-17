package org.mohe.ctp.service.td;

import org.mohe.ctp.dto.AccountDTO;
import org.mohe.ctp.dto.CancelOrderReq;
import org.mohe.ctp.dto.ErrorDTO;
import org.mohe.ctp.dto.OrderDTO;
import org.mohe.ctp.dto.OrderReq;
import org.mohe.ctp.dto.PositionDTO;
import org.mohe.ctp.dto.TickDTO;
import org.mohe.ctp.dto.TradeDTO;

/**
 * CTP网关
 * @author Elvis
 *
 */
public interface GatewayService {
	
	
	/**
	 * 行情回调
	 * @param tick
	 */
	public void onTick(TickDTO tick);
	
	/**
	 * 成交回调
	 * @param trade
	 */
	public void onTrade(TradeDTO trade);
	
	/**
	 * 订单回调
	 * @param order
	 */
	public void onOrder(OrderDTO order);
	
	/**
	 * 持仓回调
	 * @param position
	 */
	public void onPosition(PositionDTO position);
	
	/**
	 * 账户信息
	 * @param account
	 */
	public void onAccount(AccountDTO account);
	
	/**
	 * 异常处理
	 * @param error
	 */
	public void onError(ErrorDTO error);
	
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

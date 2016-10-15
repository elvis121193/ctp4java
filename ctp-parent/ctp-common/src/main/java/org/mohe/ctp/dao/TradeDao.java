package org.mohe.ctp.dao;

import org.mohe.ctp.entity.Trade;

public interface TradeDao {
	
	public void save(Trade trade);
	
	public Trade getTradeByOrderRef(String orderRef);
	
	/**
	 * 根据条件获取最近一次交易
	 * @param brokerID
	 * @param investorID
	 * @param instrumentID
	 * @param offsetFlag
	 * @param direction
	 * @return
	 */
	public Trade getLatestTrade(String brokerID,String investorID,String instrumentID,String offsetFlag,String direction);
}

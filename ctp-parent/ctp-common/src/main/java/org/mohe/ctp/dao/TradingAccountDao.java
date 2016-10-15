package org.mohe.ctp.dao;

import org.mohe.ctp.entity.TradingAccount;

public interface TradingAccountDao {

	public void save(TradingAccount ta);

	public TradingAccount get(String brokerID, String accountID);
}

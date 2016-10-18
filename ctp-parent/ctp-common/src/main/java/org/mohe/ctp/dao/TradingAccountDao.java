package org.mohe.ctp.dao;

import org.mohe.ctp.entity.Account;

public interface TradingAccountDao {

	public void save(Account ta);

	public Account get(String brokerID, String accountID);
}

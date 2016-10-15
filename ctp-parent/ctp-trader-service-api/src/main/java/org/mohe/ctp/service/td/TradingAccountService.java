package org.mohe.ctp.service.td;

import org.mohe.ctp.entity.TradingAccount;

public interface TradingAccountService {
	
	public TradingAccount getTradingAccount(String brokerID,String investorID);
}

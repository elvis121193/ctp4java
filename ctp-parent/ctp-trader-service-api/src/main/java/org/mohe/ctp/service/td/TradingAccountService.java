package org.mohe.ctp.service.td;

import org.mohe.ctp.entity.TradingAccount;

/**
 * 资金
 * @author Elvis
 *
 */
public interface TradingAccountService {
	
	public TradingAccount getTradingAccount(String brokerID,String investorID);
}

package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.TradingAccountDao;
import org.mohe.ctp.entity.TradingAccount;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("tradingAccountDao")
public class TradingAccountDaoImpl extends BaseDao implements TradingAccountDao {

	public void save(TradingAccount ta) {
		mongoTemplate.save(ta);
	}

	public TradingAccount get(String brokerID, String accountID) {
		List<TradingAccount> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("accountID").is(accountID)), TradingAccount.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}

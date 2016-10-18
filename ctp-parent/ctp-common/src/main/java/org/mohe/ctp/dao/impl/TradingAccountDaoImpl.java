package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.TradingAccountDao;
import org.mohe.ctp.entity.Account;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("tradingAccountDao")
public class TradingAccountDaoImpl extends BaseDao implements TradingAccountDao {

	public void save(Account ta) {
		mongoTemplate.save(ta);
	}

	public Account get(String brokerID, String accountID) {
		List<Account> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("accountID").is(accountID)), Account.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}

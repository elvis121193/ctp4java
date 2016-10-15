package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.TradeDao;
import org.mohe.ctp.entity.Trade;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("tradeDao")
public class TradeDaoImpl extends BaseDao implements TradeDao {

	public void save(Trade trade) {
		mongoTemplate.save(trade);
	}

	public Trade getTradeByOrderRef(String orderRef) {
		List<Trade> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("orderRef").is(orderRef)), Trade.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

	public Trade getLatestTrade(String brokerID, String investorID,
			String instrumentID, String offsetFlag, String direction) {
		List<Trade> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("investorID").is(investorID).and("instrumentID").is(instrumentID).and("offsetFlag").is(offsetFlag).and("direction").is(direction)).with(new Sort(Direction.DESC, "tradeDateTime")), Trade.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}

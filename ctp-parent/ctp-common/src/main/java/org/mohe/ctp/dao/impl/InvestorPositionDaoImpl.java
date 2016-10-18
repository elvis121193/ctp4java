package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.InvestorPositionDao;
import org.mohe.ctp.entity.Position;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("investorPositionDao")
public class InvestorPositionDaoImpl extends BaseDao implements
		InvestorPositionDao {

	public void save(Position investorPosition) {
		mongoTemplate.save(investorPosition);
	}

	public List<Position> getInvestorPosition(String brokerID,
			String instrumentID, String investorID) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("positionDate").is("2")), Position.class);
	}

	public Position getInvestorPosition(String brokerID,
			String instrumentID, String investorID, String posiDirection,
			String positionDate) {
		List<Position> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("posiDirection").is(posiDirection).and("positionDate").is(positionDate)), Position.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}

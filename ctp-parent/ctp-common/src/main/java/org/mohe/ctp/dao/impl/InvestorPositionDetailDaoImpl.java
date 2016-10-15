package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.InvestorPositionDetailDao;
import org.mohe.ctp.entity.InvestorPositionDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("investorPositionDetailDao")
public class InvestorPositionDetailDaoImpl extends BaseDao implements
		InvestorPositionDetailDao {

	public void save(InvestorPositionDetail investorPositionDetail) {
		mongoTemplate.save(investorPositionDetail);
	}

	public List<InvestorPositionDetail> getInvestorPositionDetail(
			String brokerID, String instrumentID, String investorID) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID)), InvestorPositionDetail.class);
	}

	public InvestorPositionDetail getInvestorPositionDetail(String brokerID,
			String instrumentID, String investorID, String tradeID) {
		List<InvestorPositionDetail> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("tradeID").is(tradeID)), InvestorPositionDetail.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

	public InvestorPositionDetail getLatestPositionDetail(String brokerID,
			String instrumentID, String investorID, String direction) {
		List<InvestorPositionDetail> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("direction").is(direction)).with(new Sort(Direction.DESC,"openDate")), InvestorPositionDetail.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}

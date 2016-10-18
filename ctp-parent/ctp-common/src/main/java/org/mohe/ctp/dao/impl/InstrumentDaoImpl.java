package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.InstrumentDao;
import org.mohe.ctp.entity.Contract;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("instrumentDao")
public class InstrumentDaoImpl extends BaseDao implements InstrumentDao {

	
	public List<Contract> getInstrumentList(){
		return mongoTemplate.findAll(Contract.class);
	}

	public void save(Contract ins) {
		mongoTemplate.save(ins);
	}

	public Contract getInstrument(String instrumentId) {
		List<Contract> lst = mongoTemplate.find(new Query(Criteria.where("instrumnetID").is(instrumentId)), Contract.class);
		if(lst != null && lst.size() > 0){
			return lst.get(0);
		}
		return null;
	}
	
	
}

package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.InstrumentDao;
import org.mohe.ctp.entity.Instrument;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("instrumentDao")
public class InstrumentDaoImpl extends BaseDao implements InstrumentDao {

	
	public List<Instrument> getInstrumentList(){
		return mongoTemplate.findAll(Instrument.class);
	}

	public void save(Instrument ins) {
		mongoTemplate.save(ins);
	}

	public Instrument getInstrument(String instrumentId) {
		List<Instrument> lst = mongoTemplate.find(new Query(Criteria.where("instrumnetID").is(instrumentId)), Instrument.class);
		if(lst != null && lst.size() > 0){
			return lst.get(0);
		}
		return null;
	}
	
	
}

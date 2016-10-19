package org.mohe.ctp.dao.impl;

import org.mohe.ctp.dao.TickDao;
import org.mohe.ctp.entity.Tick;
import org.mohe.ctp.util.DateTimeUtil;
import org.springframework.stereotype.Repository;

@Repository("tickDao")
public class TickDaoImpl extends BaseDao implements TickDao {

	private final static String COLLECTION_NAME = "tick";
	public void save(Tick tick) {
		mongoTemplate.save(tick,COLLECTION_NAME+DateTimeUtil.getCurrDate());
	}

}

package org.mohe.ctp.dao.impl;

import org.mohe.ctp.dao.TickDao;
import org.mohe.ctp.entity.Tick;
import org.springframework.stereotype.Repository;

@Repository("tickDao")
public class TickDaoImpl extends BaseDao implements TickDao {

	public void save(Tick tick) {
		mongoTemplate.save(tick);
	}

}

package org.mohe.ctp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BaseDao {

	@Autowired
	protected MongoTemplate mongoTemplate;
}

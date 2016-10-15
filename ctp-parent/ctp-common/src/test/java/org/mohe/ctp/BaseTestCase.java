package org.mohe.ctp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:application_common.xml"})
public class BaseTestCase {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void test(){
		System.out.println("test");
		mongoTemplate.createCollection("ttt");
	}

}

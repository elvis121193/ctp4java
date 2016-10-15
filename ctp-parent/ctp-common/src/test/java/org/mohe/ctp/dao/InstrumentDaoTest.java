package org.mohe.ctp.dao;

import org.junit.Test;
import org.mohe.ctp.BaseTestCase;
import org.mohe.ctp.entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;

public class InstrumentDaoTest extends BaseTestCase{

	@Autowired
	InstrumentDao instrumentDao;
	
	@Test
	public void test() {
		Instrument inst = new Instrument();
		
		inst.setInstrumentID("IC1610");
		inst.setId("IC1610");
		instrumentDao.save(inst);
		
		System.out.println(instrumentDao.getInstrumentList());
	}

}

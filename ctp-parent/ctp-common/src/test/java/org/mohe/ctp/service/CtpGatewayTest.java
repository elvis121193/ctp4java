package org.mohe.ctp.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mohe.ctp.BaseTestCase;
import org.mohe.ctp.dao.InstrumentDao;
import org.mohe.ctp.entity.Contract;
import org.mohe.ctp.gateway.Gateway;
import org.springframework.beans.factory.annotation.Autowired;

public class CtpGatewayTest extends BaseTestCase{
	@Autowired
	private Gateway gateway;
	
	@Autowired
	private InstrumentDao instrumentDao;
	
	@Test
	public void test2() throws IOException {
		gateway.subscribe(new String[]{"IC1610"});
		
		System.in.read();
	}
	
	@Test
	public void dd() throws Exception{
		List<Contract> lst = instrumentDao.getInstrumentList();
		String[] instruments = new String[lst.size()];
		for( int i = 0; i< lst.size(); i++){
			instruments[i] = lst.get(i).getSymbol();
		}
		
		gateway.subscribe(instruments);
		System.in.read();
	}

}

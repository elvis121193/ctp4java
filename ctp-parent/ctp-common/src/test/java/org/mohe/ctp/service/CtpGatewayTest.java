package org.mohe.ctp.service;

import java.io.IOException;

import org.junit.Test;
import org.mohe.ctp.BaseTestCase;
import org.mohe.ctp.gateway.Gateway;
import org.springframework.beans.factory.annotation.Autowired;

public class CtpGatewayTest extends BaseTestCase{
	@Autowired
	private Gateway gateway;
	
	@Test
	public void test2() throws IOException {
		gateway.subscribe(new String[]{"IC1610"});
		
		System.in.read();
	}

}

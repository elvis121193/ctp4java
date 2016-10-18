package org.mohe.ctp.service.impl.td;

import java.io.IOException;

import org.junit.Test;
import org.mohe.ctp.BaseTestCase;
import org.mohe.ctp.service.td.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;

public class CtpGatewayServiceImplTest extends BaseTestCase{

	@Autowired
	private GatewayService ctpGatewayService;
	@Test
	public void test() throws IOException {
		ctpGatewayService.subscribe(new String[]{"IC1610"});
		
		System.in.read();
	}

}

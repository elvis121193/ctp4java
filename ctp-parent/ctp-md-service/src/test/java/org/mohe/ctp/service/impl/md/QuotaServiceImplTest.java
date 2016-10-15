package org.mohe.ctp.service.impl.md;

import java.io.IOException;

import org.junit.Test;
import org.mohe.ctp.service.md.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuotaServiceImplTest extends BaseTestCase{

	@Autowired
	private QuotaService quotaService;
	
	@Test
	public void test() throws IOException, InterruptedException {
		quotaService.registerCallback(new MyQuotaCallback());
		
		Thread.sleep(5000);
		quotaService.subscribe(new String[]{"IC1610","IH1610"});
		
		System.in.read();
	}

}

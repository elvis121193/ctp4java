package org.mohe.ctp.service.sequence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:application_sequence.xml"})
public class BaseTestCase {

	@Autowired
	private SequenceService sequenceService;
	
	@Test
	public void Test()	{
		
		System.out.println(sequenceService.getSequence());
		System.out.println(sequenceService.getSequence());
	}
	

}

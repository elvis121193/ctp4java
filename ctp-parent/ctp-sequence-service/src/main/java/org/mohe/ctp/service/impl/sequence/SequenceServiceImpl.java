package org.mohe.ctp.service.impl.sequence;

import java.util.concurrent.atomic.AtomicInteger;

import org.mohe.ctp.service.sequence.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService{
	
	private static AtomicInteger sequence = new AtomicInteger(0);

	public Integer getSequence() {
		return sequence.getAndIncrement();
	}

}

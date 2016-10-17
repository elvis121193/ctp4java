package org.mohe.ctp.service.impl.sequence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.mohe.ctp.service.sequence.EnumSeqType;
import org.mohe.ctp.service.sequence.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {

	private final static Map<EnumSeqType, AtomicInteger> seqPool = new HashMap<EnumSeqType, AtomicInteger>();

	public Integer getSequence(EnumSeqType seqType) {
		AtomicInteger sequence;
		if (seqPool.containsKey(seqType)) {
			sequence = seqPool.get(seqType);
		} else {
			sequence = new AtomicInteger(0);
			seqPool.put(seqType, sequence);
		}
		return sequence.getAndIncrement();
	}

}

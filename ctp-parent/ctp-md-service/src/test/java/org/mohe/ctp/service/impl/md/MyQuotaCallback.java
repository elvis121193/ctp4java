package org.mohe.ctp.service.impl.md;

import org.mohe.ctp.entity.Tick;
import org.mohe.ctp.service.md.QuotaCallback;

public class MyQuotaCallback implements QuotaCallback {

	public void onTick(Tick tick) {
		System.out.println(tick.getExchangeId() + " " + tick.getAskPrice());
	}

}

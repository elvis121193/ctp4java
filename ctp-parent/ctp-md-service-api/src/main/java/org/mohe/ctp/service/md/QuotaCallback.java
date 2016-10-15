package org.mohe.ctp.service.md;

import org.mohe.ctp.entity.Tick;

/**
 * 行情回调
 * @author Elvis
 *
 */
public interface QuotaCallback {

	
	/**
	 * Tick级别的行情回调
	 */
	public void onTick(Tick tick);
}

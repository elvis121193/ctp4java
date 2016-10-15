package org.mohe.ctp.service.md;

/**
 * 行情接口
 * @author Elvis
 *
 */
public interface QuotaService {
	
	/**
	 * 订阅行情
	 */
	public void subscribe(String[] instruments);

	
	/**
	 * 行情回调
	 * @param callback
	 */
	public void registerCallback(QuotaCallback callback);
}

package org.mohe.ctp.service.impl.md;

import org.apache.log4j.Logger;
import org.mohe.ctp.service.md.QuotaCallback;
import org.mohe.ctp.service.md.QuotaService;

/**
 * 行情对外接口实现
 * @author Elvis
 *
 */
public class QuotaServiceImpl implements QuotaService {

	private final static Logger logger = Logger
			.getLogger(QuotaServiceImpl.class);

	private CTPMdApi mdApi;

	public CTPMdApi getMdApi() {
		return mdApi;
	}

	public void setMdApi(CTPMdApi mdApi) {
		this.mdApi = mdApi;
	}

	public void init() {
		logger.info("-----------init begin-----------");
		mdApi.connect();
		logger.info("-----------init end-----------");
	}

	public void destroy() {
		mdApi.destroy();
		logger.info("-----------destroy-----------");
	}

	public void subscribe(String[] instruments) {
		mdApi.subscribe(instruments);
	}

	public void unSubscribe(String[] instruments) {
		mdApi.unSubscribe(instruments);
	}

	public void registerCallback(QuotaCallback callback) {
		logger.info("-----------registerCallback-----------");
		mdApi.registerQuotaCallback(callback);
	}

}

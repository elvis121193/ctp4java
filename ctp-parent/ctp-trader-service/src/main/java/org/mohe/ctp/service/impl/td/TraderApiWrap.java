package org.mohe.ctp.service.impl.td;

import cn.yiwang.ctp.CThostFtdcTraderApi;

public class TraderApiWrap {
	
	private static CThostFtdcTraderApi tdApi;
	
	private static int maxOrderRef = 0;
	
	public static CThostFtdcTraderApi getTraderApi(){
		return  tdApi;
	}

}

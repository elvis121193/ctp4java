package org.mohe.ctp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	
	
	public static String format(String rq, String hour, int millsec){
		return "";
	}
	
	public static String getCurrTime(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHMMSSsss");
		return df.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(Long.valueOf(DateTimeUtil.getCurrTime()));
	}

}

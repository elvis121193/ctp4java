package org.mohe.ctp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateTimeUtil {
	
	
	public static String format(String rq, String hour, int millsec){
		return "";
	}
	
	public static String getCurrTime(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHMMSSsss");
		return df.format(date);
	}
	
	public static String getCurrDate(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	
	
	public static void main(String[] args) throws ParseException {
		System.out.println(StringUtils.replace("10:45:00", ":", ""));
		
		
	}

}

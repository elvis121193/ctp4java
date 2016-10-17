package org.mohe.ctp.dto;

import java.io.Serializable;

/**
 * 行情tick数据结构
 * @author Elvis
 *
 */
public class TickDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 合约代码
	 */
	private String symbol;
	
	/**
	 *  交易所代码
	 */
	private String exchange;
	
	/**
	 * 合约在系统中的唯一代码，通常是 合约代码.交易所代码
	 */
	private String vtSysmbol;
	
	/**
	 * 最新成交价
	 */
	private double lastPrice;
	
	/**
	 * 最新成交量
	 */
	private int lastVolume;
	
	/**
	 * 今天总成交量
	 */
	private int volume;
	
	/**
	 *  持仓量
	 */
	private int openInterest;
	
	/**
	 * 时间 11:20:56.5
	 */
	private String time;
	
	/**
	 * 日期 20151009
	 */
	private String date;
	
	/**
	 * 今日开盘价
	 */
	private double openPrice;
	
	/**
	 *  今日最高价
	 */
	private double highPrice;
	
	/**
	 *今日最低价 
	 */
	private double lowPrice;
	
	/**
	 * 
	 */
	private double preClosePrice;
	
	/**
	 * 涨停价
	 */
	private double upperLimit;
	
	/**
	 * 跌停价
	 */
	private double lowerLimit;
	
	//五档行情
	private double bidPrice1;
	private double bidPrice2;
	private double bidPrice3;
	private double bidPrice4;
	private double bidPrice5;
	
	private double askPrice1;
	private double askPrice2;
	private double askPrice3;
	private double askPrice4;
	private double askPrice5;

	private int bidVolume1;
	private int bidVolume2;
	private int bidVolume3;
	private int bidVolume4;
	private int bidVolume5;
	
	private int askVolume1;
	private int askVolume2;
	private int askVolume3;
	private int askVolume4;
	private int askVolume5;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getVtSysmbol() {
		return vtSysmbol;
	}
	public void setVtSysmbol(String vtSysmbol) {
		this.vtSysmbol = vtSysmbol;
	}
	public double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public int getLastVolume() {
		return lastVolume;
	}
	public void setLastVolume(int lastVolume) {
		this.lastVolume = lastVolume;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(int openInterest) {
		this.openInterest = openInterest;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public double getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}
	public double getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public double getBidPrice1() {
		return bidPrice1;
	}
	public void setBidPrice1(double bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}
	public double getBidPrice2() {
		return bidPrice2;
	}
	public void setBidPrice2(double bidPrice2) {
		this.bidPrice2 = bidPrice2;
	}
	public double getBidPrice3() {
		return bidPrice3;
	}
	public void setBidPrice3(double bidPrice3) {
		this.bidPrice3 = bidPrice3;
	}
	public double getBidPrice4() {
		return bidPrice4;
	}
	public void setBidPrice4(double bidPrice4) {
		this.bidPrice4 = bidPrice4;
	}
	public double getBidPrice5() {
		return bidPrice5;
	}
	public void setBidPrice5(double bidPrice5) {
		this.bidPrice5 = bidPrice5;
	}
	public double getAskPrice1() {
		return askPrice1;
	}
	public void setAskPrice1(double askPrice1) {
		this.askPrice1 = askPrice1;
	}
	public double getAskPrice2() {
		return askPrice2;
	}
	public void setAskPrice2(double askPrice2) {
		this.askPrice2 = askPrice2;
	}
	public double getAskPrice3() {
		return askPrice3;
	}
	public void setAskPrice3(double askPrice3) {
		this.askPrice3 = askPrice3;
	}
	public double getAskPrice4() {
		return askPrice4;
	}
	public void setAskPrice4(double askPrice4) {
		this.askPrice4 = askPrice4;
	}
	public double getAskPrice5() {
		return askPrice5;
	}
	public void setAskPrice5(double askPrice5) {
		this.askPrice5 = askPrice5;
	}
	public int getBidVolume1() {
		return bidVolume1;
	}
	public void setBidVolume1(int bidVolume1) {
		this.bidVolume1 = bidVolume1;
	}
	public int getBidVolume2() {
		return bidVolume2;
	}
	public void setBidVolume2(int bidVolume2) {
		this.bidVolume2 = bidVolume2;
	}
	public int getBidVolume3() {
		return bidVolume3;
	}
	public void setBidVolume3(int bidVolume3) {
		this.bidVolume3 = bidVolume3;
	}
	public int getBidVolume4() {
		return bidVolume4;
	}
	public void setBidVolume4(int bidVolume4) {
		this.bidVolume4 = bidVolume4;
	}
	public int getBidVolume5() {
		return bidVolume5;
	}
	public void setBidVolume5(int bidVolume5) {
		this.bidVolume5 = bidVolume5;
	}
	public int getAskVolume1() {
		return askVolume1;
	}
	public void setAskVolume1(int askVolume1) {
		this.askVolume1 = askVolume1;
	}
	public int getAskVolume2() {
		return askVolume2;
	}
	public void setAskVolume2(int askVolume2) {
		this.askVolume2 = askVolume2;
	}
	public int getAskVolume3() {
		return askVolume3;
	}
	public void setAskVolume3(int askVolume3) {
		this.askVolume3 = askVolume3;
	}
	public int getAskVolume4() {
		return askVolume4;
	}
	public void setAskVolume4(int askVolume4) {
		this.askVolume4 = askVolume4;
	}
	public int getAskVolume5() {
		return askVolume5;
	}
	public void setAskVolume5(int askVolume5) {
		this.askVolume5 = askVolume5;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TickDTO [symbol=");
		builder.append(symbol);
		builder.append(", exchange=");
		builder.append(exchange);
		builder.append(", vtSysmbol=");
		builder.append(vtSysmbol);
		builder.append(", lastPrice=");
		builder.append(lastPrice);
		builder.append(", lastVolume=");
		builder.append(lastVolume);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", openInterest=");
		builder.append(openInterest);
		builder.append(", time=");
		builder.append(time);
		builder.append(", date=");
		builder.append(date);
		builder.append(", openPrice=");
		builder.append(openPrice);
		builder.append(", highPrice=");
		builder.append(highPrice);
		builder.append(", lowPrice=");
		builder.append(lowPrice);
		builder.append(", preClosePrice=");
		builder.append(preClosePrice);
		builder.append(", upperLimit=");
		builder.append(upperLimit);
		builder.append(", lowerLimit=");
		builder.append(lowerLimit);
		builder.append(", bidPrice1=");
		builder.append(bidPrice1);
		builder.append(", bidPrice2=");
		builder.append(bidPrice2);
		builder.append(", bidPrice3=");
		builder.append(bidPrice3);
		builder.append(", bidPrice4=");
		builder.append(bidPrice4);
		builder.append(", bidPrice5=");
		builder.append(bidPrice5);
		builder.append(", askPrice1=");
		builder.append(askPrice1);
		builder.append(", askPrice2=");
		builder.append(askPrice2);
		builder.append(", askPrice3=");
		builder.append(askPrice3);
		builder.append(", askPrice4=");
		builder.append(askPrice4);
		builder.append(", askPrice5=");
		builder.append(askPrice5);
		builder.append(", bidVolume1=");
		builder.append(bidVolume1);
		builder.append(", bidVolume2=");
		builder.append(bidVolume2);
		builder.append(", bidVolume3=");
		builder.append(bidVolume3);
		builder.append(", bidVolume4=");
		builder.append(bidVolume4);
		builder.append(", bidVolume5=");
		builder.append(bidVolume5);
		builder.append(", askVolume1=");
		builder.append(askVolume1);
		builder.append(", askVolume2=");
		builder.append(askVolume2);
		builder.append(", askVolume3=");
		builder.append(askVolume3);
		builder.append(", askVolume4=");
		builder.append(askVolume4);
		builder.append(", askVolume5=");
		builder.append(askVolume5);
		builder.append("]");
		return builder.toString();
	}
	
	
}

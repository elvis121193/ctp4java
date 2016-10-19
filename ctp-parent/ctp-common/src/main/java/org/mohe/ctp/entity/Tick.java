package org.mohe.ctp.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 行情tick数据结构
 * 
 * @author Elvis
 * 
 */
@Document
public class Tick extends BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 合约代码
	 */
	private String symbol;

	/**
	 * 最新成交价
	 */
	private int lastPrice;

	/**
	 * 今天总成交量
	 */
	private int volume;

	/**
	 * 时间 112056500 格式hhmmss+3位毫秒
	 */
	private int time;

	// 五档行情
	private int bidPrice;

	private int askPrice;

	private int bidVolume;

	private int askVolume;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(int askPrice) {
		this.askPrice = askPrice;
	}

	public int getBidVolume() {
		return bidVolume;
	}

	public void setBidVolume(int bidVolume) {
		this.bidVolume = bidVolume;
	}

	public int getAskVolume() {
		return askVolume;
	}

	public void setAskVolume(int askVolume) {
		this.askVolume = askVolume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + time;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tick other = (Tick) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TickDTO [symbol=");
		builder.append(symbol);
		builder.append(", lastPrice=");
		builder.append(lastPrice);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", time=");
		builder.append(time);
		builder.append(", bidPrice=");
		builder.append(bidPrice);
		builder.append(", askPrice=");
		builder.append(askPrice);
		builder.append(", bidVolume=");
		builder.append(bidVolume);
		builder.append(", askVolume=");
		builder.append(askVolume);
		builder.append("]");
		return builder.toString();
	}

}

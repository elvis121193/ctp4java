package org.mohe.ctp.dao;

import java.util.List;

import org.mohe.ctp.entity.Instrument;

public interface InstrumentDao {
	
	/**
	 * 获取所有的合约信息
	 * @return
	 */
	public List<Instrument> getInstrumentList();

	/**
	 * 保存合约
	 * @param ins
	 */
	public void save(Instrument ins);

	/**
	 * 根据合约号获取合约信息
	 * @param instrumentId
	 * @return
	 */
	public Instrument getInstrument(String instrumentId);

}

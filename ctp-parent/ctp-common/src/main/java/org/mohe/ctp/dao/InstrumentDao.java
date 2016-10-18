package org.mohe.ctp.dao;

import java.util.List;

import org.mohe.ctp.entity.Contract;

public interface InstrumentDao {
	
	/**
	 * 获取所有的合约信息
	 * @return
	 */
	public List<Contract> getInstrumentList();

	/**
	 * 保存合约
	 * @param ins
	 */
	public void save(Contract ins);

	/**
	 * 根据合约号获取合约信息
	 * @param instrumentId
	 * @return
	 */
	public Contract getInstrument(String instrumentId);

}

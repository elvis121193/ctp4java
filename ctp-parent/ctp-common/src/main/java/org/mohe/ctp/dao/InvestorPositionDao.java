package org.mohe.ctp.dao;

import java.util.List;

import org.mohe.ctp.entity.InvestorPosition;

public interface InvestorPositionDao {
	
	/**
	 * 保存持仓点位
	 * @param investorPosition
	 */
	public void save(InvestorPosition investorPosition);
	
	/**
	 * 根据交易所编号，合约代码，投资者账户获取持仓
	 * @param brokerID
	 * @param instrumentID
	 * @param investorID
	 * @return
	 */
	public List<InvestorPosition> getInvestorPosition(String brokerID,String instrumentID,String investorID);
	
	/**
	 * 根据交易所编号，合约代码，投资者账户，开平方向，开仓日期获取合约点位
	 * @param brokerID
	 * @param instrumentID
	 * @param investorID
	 * @param posiDirection
	 * @param positionDate
	 * @return
	 */
	public InvestorPosition getInvestorPosition(String brokerID,String instrumentID,String investorID,String posiDirection,String positionDate);
}

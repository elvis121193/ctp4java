package org.mohe.ctp.dao;

import java.util.List;

import org.mohe.ctp.entity.InvestorPositionDetail;

public interface InvestorPositionDetailDao {
	
	public void save(InvestorPositionDetail investorPositionDetail);
	
	public List<InvestorPositionDetail> getInvestorPositionDetail(String brokerID,String instrumentID,String investorID);
	
	public InvestorPositionDetail getInvestorPositionDetail(String brokerID,String instrumentID,String investorID,String tradeID);
	
	/**
	 * 获取最新一条持仓明细
	 * @param brokerID
	 * @param instrumentID
	 * @param investorID
	 * @return
	 */
	public InvestorPositionDetail getLatestPositionDetail(String brokerID,String instrumentID,String investorID,String direction);
}

package org.mohe.ctp.service.td;

import java.util.List;

import org.mohe.ctp.dto.ReqCancelOrder;
import org.mohe.ctp.entity.InvestorPosition;
import org.mohe.ctp.entity.Order;

public interface TraderService {

	public void orderInsert(Order order);
	
	public List<InvestorPosition> qryInvestorPosition(String brokerID,String instrumentID,String investorID);
	
	public InvestorPosition getInvestorPosition(String brokerID, String instrumentID, String investorID, String posiDirection, String positionDate);
	
	
	public void cancelOrder(ReqCancelOrder cancelOrder);
	
}

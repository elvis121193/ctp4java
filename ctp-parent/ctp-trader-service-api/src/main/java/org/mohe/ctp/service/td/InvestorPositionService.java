package org.mohe.ctp.service.td;

import java.util.List;

import org.mohe.ctp.entity.InvestorPosition;

public interface InvestorPositionService {

	public List<InvestorPosition> getList(String brokerID, String instrumentID,
			String investorID);
}

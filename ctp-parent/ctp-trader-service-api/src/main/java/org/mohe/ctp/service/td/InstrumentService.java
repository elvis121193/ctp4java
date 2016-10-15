package org.mohe.ctp.service.td;

import java.util.List;

import org.mohe.ctp.entity.Instrument;


public interface InstrumentService {

	
	public void addInstrument(Instrument instrument);
	
	public List<Instrument> getList();
	
	public List<String> getInstrumentIds();
	
	public boolean isExists(String instrumentId);
}

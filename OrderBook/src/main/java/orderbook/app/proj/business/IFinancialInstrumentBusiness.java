package orderbook.app.proj.business;

import java.util.List;

import orderbook.app.proj.entities.FinancialInstrument;

public interface IFinancialInstrumentBusiness {

	//Retrieve all FinancialInstrument from the database 
	public List<FinancialInstrument> findAllFinancInstr();
}

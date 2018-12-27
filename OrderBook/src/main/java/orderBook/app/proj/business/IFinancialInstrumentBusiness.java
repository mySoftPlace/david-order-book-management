package orderBook.app.proj.business;

import java.util.List;

import orderBook.app.proj.entities.FinancialInstrument;

public interface IFinancialInstrumentBusiness {

	//Retrieve all FinancialInstrument from the database 
	public List<FinancialInstrument> findAllFinancInstr();
}

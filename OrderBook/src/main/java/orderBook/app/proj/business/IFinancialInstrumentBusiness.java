package orderBook.app.proj.business;

import java.util.List;

import orderBook.app.proj.entities.FinancialInstrument;

public interface IFinancialInstrumentBusiness {

	public List<FinancialInstrument> findAllFinancInstr();
}

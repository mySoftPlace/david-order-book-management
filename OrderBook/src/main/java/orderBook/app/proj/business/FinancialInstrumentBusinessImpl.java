package orderBook.app.proj.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orderBook.app.proj.dao.FinancialInstrumentRepository;
import orderBook.app.proj.entities.FinancialInstrument;

@Service
public class FinancialInstrumentBusinessImpl implements IFinancialInstrumentBusiness {

	@Autowired
	FinancialInstrumentRepository finInstrRepository;

	@Override
	public List<FinancialInstrument> findAllFinancInstr() {
		return finInstrRepository.findAll();
	}
}

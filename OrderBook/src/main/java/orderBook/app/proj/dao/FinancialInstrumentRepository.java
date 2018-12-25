package orderBook.app.proj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orderBook.app.proj.entities.FinancialInstrument;

public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, Long> {

}

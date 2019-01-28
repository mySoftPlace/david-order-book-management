package orderbook.app.proj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orderbook.app.proj.entities.FinancialInstrument;

public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, Long> {

}

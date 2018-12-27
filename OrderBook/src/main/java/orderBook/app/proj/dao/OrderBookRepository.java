package orderBook.app.proj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import orderBook.app.proj.entities.OrderBook;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {

	// Execution price
	@Query("SELECT ordb.executionPrice FROM OrderBook ordb WHERE ordb.orderBookId = :ordBkId")
	public double execPricePerBook(@Param("ordBkId") Long orderBookId);

	//List of all opened order book
	@Query("FROM OrderBook ordb WHERE ordb.isOpen = 1")
	public List<OrderBook> orderBookOpen();

	//List of all closed order book
	@Query("FROM OrderBook ordb WHERE ordb.isOpen = 0 AND ordb.isExecute = 0")
	public List<OrderBook> orderBookClose();
}

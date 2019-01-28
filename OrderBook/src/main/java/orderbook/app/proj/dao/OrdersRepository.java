package orderbook.app.proj.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import orderbook.app.proj.entities.LimitBreakDown;
import orderbook.app.proj.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query("SELECT SUM(ord.quantity) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId")
	public Integer totalDemandPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT MAX(ord.quantity) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId")
	public Integer maxOrderPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT MIN(ord.quantity) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId")
	public Integer minOrderPerBook(@Param("ordBkId") Long orderBookId);

	@Query("FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId order by ord.entryDate ASC")
	public List<Orders> earliestOrderEntryPerBook(@Param("ordBkId") Long orderBookId, Pageable pageable);

	@Query("FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId order by ord.entryDate DESC")
	public List<Orders> lastOrderEntryPerBook(@Param("ordBkId") Long orderBookId, Pageable pageable);

	@Query("SELECT SUM(ord.limitPrice) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId")
	public Double totalOrderAmountPerBook(@Param("ordBkId") Long orderBookId);
	
	@Query("SELECT new orderbook.app.proj.entities.LimitBreakDown(ord.limitPrice, SUM(ord.quantity)) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId GROUP BY ord.limitPrice")
	public List<LimitBreakDown> limitBreakDownPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT SUM(ord.limitPrice) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId AND ord.isValid=1")
	public Double totalValidOrderAmountPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT SUM(ord.limitPrice) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId AND ord.isValid=0")
	public Double totalInvalidOrderAmountPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT SUM(ord.quantity) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId AND ord.isValid=1")
	public Integer totalValidDemandPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT SUM(ord.quantity) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId AND ord.isValid=0")
	public Integer totalInvalidDemandPerBook(@Param("ordBkId") Long orderBookId);

	@Query("SELECT SUM(ord.lastExecuteQty) FROM Orders ord WHERE ord.orderBook.orderBookId = :ordBkId")
	public Integer totalExecutionQtyPerBook(@Param("ordBkId") Long orderBookId);
}

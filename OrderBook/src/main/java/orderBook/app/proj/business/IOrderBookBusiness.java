package orderBook.app.proj.business;

import java.util.List;

import orderBook.app.proj.entities.OrderBook;

public interface IOrderBookBusiness {

	public OrderBook openOrderBook(OrderBook orderBook);

	public OrderBook updateOrderBook(OrderBook orderBook);

	public double findExecPricePerBook(Long orderBookId);

	public void validateOrderBook(Long orderBookId, double executionPrice);

	//Linear distribution among all valid orders
	public OrderBook executeOrderBook(Long orderBookId, int executionQty);

	public List<OrderBook> orderBookOpen();

	public List<OrderBook> orderBookClose();

	public List<OrderBook> findAllorderBook();
	
	public OrderBook findOrderBookById(Long ordBkId);
	
}

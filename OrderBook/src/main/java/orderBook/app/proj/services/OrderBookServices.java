package orderBook.app.proj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import orderBook.app.proj.business.IFinancialInstrumentBusiness;
import orderBook.app.proj.business.IOrderBookBusiness;
import orderBook.app.proj.business.IOrdersBusiness;
import orderBook.app.proj.entities.Orders;
import orderBook.app.proj.entities.FinancialInstrument;
import orderBook.app.proj.entities.OrderBook;
import orderBook.app.proj.entities.StatisticPerBook;

/**
 * 
 * @author David Sossavi
 * 
 *         All the services are implemented in this class
 *
 */
@RestController
public class OrderBookServices {

	@Autowired
	private IOrderBookBusiness iOrderBookBusiness;

	@Autowired
	private IOrdersBusiness iOrderBusiness;

	@Autowired
	private IFinancialInstrumentBusiness iFinancialInstrumentBusiness;

	// Open an Order Book
	@RequestMapping(value = "/user/book/open", method = RequestMethod.POST)
	public OrderBook saveOrderBook(@RequestBody OrderBook orderBook) {
		return iOrderBookBusiness.openOrderBook(orderBook);
	}

	// Update an Order book
	@RequestMapping(value = "/user/book/update", method = RequestMethod.PUT)
	public OrderBook updateOrderBook(@RequestBody OrderBook orderBook) {
		return iOrderBookBusiness.updateOrderBook(orderBook);
	}

	// Save an Order in an order book
	@RequestMapping(value = "/user/order/save", method = RequestMethod.POST)
	public Orders saveOrder(@RequestBody Orders order) {
		return iOrderBusiness.saveOrder(order);
	}

	// Statistics before the execution of the order book
	@RequestMapping(value = "/user/statistics/before/execution", method = RequestMethod.GET)
	public StatisticPerBook orderPerBookStatistics(@RequestParam("orderBookId") Long ordBkId) {
		return iOrderBusiness.statisticsOrderPerBookBeforeExecution(ordBkId);
	}

	// Statistics after the execution of the order book
	@RequestMapping(value = "/user/statistics/after/execution", method = RequestMethod.GET)
	public StatisticPerBook statForValidInvalidOrderPerBook(@RequestParam("orderBookId") Long ordBkId) {
		return iOrderBusiness.statisticsOrderPerBookAfterExecution(ordBkId);
	}

	// Find a specific Order
	@RequestMapping(value = "/user/order/{orderId}", method = RequestMethod.GET)
	public Orders findOrderById(@RequestParam("orderId") Long ordId) {
		return iOrderBusiness.findOrderById(ordId);
	}

	// Get the execution price (for statistic)
	@RequestMapping(value = "/user/book/exec/price/{orderBookId}", method = RequestMethod.GET)
	public double findExecPricePerBook(@RequestParam("orderBookId") Long ordBkId) {
		return iOrderBookBusiness.findExecPricePerBook(ordBkId);
	}

	// Execute an order book
	@RequestMapping(value = "/user/book/execution/{orderBookId}/{executionPrice}/{executionTotalQty}", method = RequestMethod.PUT)
	public OrderBook validateAndExecuteOrderdBook(@PathVariable("orderBookId") Long ordBkId,
			@PathVariable("executionPrice") double execPrice, @PathVariable("executionTotalQty") int execTotQty) {
		iOrderBookBusiness.validateOrderBook(ordBkId, execPrice);
		return iOrderBookBusiness.executeOrderBook(ordBkId, execTotQty);
	}

	// Find and Display (in a drop down list) all financial instrument
	@RequestMapping(value = "/user/instrument/all", method = RequestMethod.GET)
	public List<FinancialInstrument> findAllFinancInstr() {
		return iFinancialInstrumentBusiness.findAllFinancInstr();
	}

	// Find and Display (in a drop down list) all opened order book
	@RequestMapping(value = "/user/orderBookOpen/all", method = RequestMethod.GET)
	public List<OrderBook> orderBookOpen() {
		return iOrderBookBusiness.orderBookOpen();
	}

	// Find and Display (in a drop down list) all closed order book
	@RequestMapping(value = "/user/book/close/all", method = RequestMethod.GET)
	public List<OrderBook> orderBookClose() {
		return iOrderBookBusiness.orderBookClose();
	}

	// Find a specific order book
	@RequestMapping(value = "/user/book", method = RequestMethod.GET)
	public OrderBook findOrderBookById(@RequestParam("orderBookId") Long ordBkId) {
		return iOrderBookBusiness.findOrderBookById(ordBkId);
	}

	// Find and Display (in a drop down list) all order book
	@RequestMapping(value = "/user/book/all", method = RequestMethod.GET)
	public List<OrderBook> findAllorderBook() {
		return iOrderBookBusiness.findAllorderBook();
	}
}

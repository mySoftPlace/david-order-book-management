package orderBook.app.proj;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import orderbook.app.proj.business.IOrderBookBusiness;
import orderbook.app.proj.business.IOrdersBusiness;
import orderbook.app.proj.entities.FinancialInstrument;
import orderbook.app.proj.entities.OrderBook;
import orderbook.app.proj.entities.Orders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderBookAppApplicationTest {

	@MockBean
	private IOrderBookBusiness iOrderBookBusiness;
	@MockBean
	private IOrdersBusiness iOrdersBusiness;

	private OrderBook orderBook;
	private OrderBook orderBookOutput;
	private Orders orderOutput;

	@Before
	public void setUp() {
		orderBook = new OrderBook("Order book 1", 6.17, 9, null, new FinancialInstrument());
		orderBookOutput = new OrderBook("Order book 1", 6.17, 9, null, new FinancialInstrument());
		orderBookOutput.setOpen(true);
		orderBookOutput.setOrderBookId(1L);

		orderOutput = new Orders(10, 3.24, 4, new Date(), new FinancialInstrument(), new OrderBook());
		orderOutput.setOrderId(6L);

		Mockito.when(iOrderBookBusiness.openOrderBook(orderBook)).thenReturn(orderBookOutput);
		Mockito.when(iOrdersBusiness.findOrderById(4L)).thenReturn(orderOutput);
	}

	@Test
	public void testOpenOrderBook() {
		// Before calling the method
		assertEquals(false, orderBook.isOpen());
		assertEquals(null, orderBook.getOrderBookId());

		orderBook = iOrderBookBusiness.openOrderBook(orderBook);

		// After calling the method
		assertEquals(true, orderBook.isOpen());
		assertEquals(orderBookOutput.getOrderBookId(), orderBook.getOrderBookId());
	}

	@Test
	public void testFindOrderById() {
		Orders orderResult = iOrdersBusiness.findOrderById(4L);

		assertEquals(orderOutput.getOrderId(), orderResult.getOrderId());
		assertEquals(orderOutput.getLastExecuteQty(), orderResult.getLastExecuteQty());
		assertEquals(orderOutput.getQuantity(), orderResult.getQuantity());
	}
}

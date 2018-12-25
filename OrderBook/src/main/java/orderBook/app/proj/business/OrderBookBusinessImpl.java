package orderBook.app.proj.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orderBook.app.proj.dao.OrderBookRepository;
import orderBook.app.proj.entities.OrderBook;
import orderBook.app.proj.entities.Orders;

@Service
public class OrderBookBusinessImpl implements IOrderBookBusiness {

	@Autowired
	private OrderBookRepository orderBookRepository;

	@Override
	public OrderBook openOrderBook(OrderBook orderBook) {
		orderBook.setOpen(true);
		return orderBookRepository.save(orderBook);
	}

	@Override
	public OrderBook updateOrderBook(OrderBook orderBook) {
		return orderBookRepository.save(orderBook);
	}

	@Override
	public double findExecPricePerBook(Long orderBookId) {
		return orderBookRepository.execPricePerBook(orderBookId);
	}

	@Override
	public void validateOrderBook(Long orderBookId, double executionPrice) {
		int validDemand = 0;
		List<Orders> ordersAfterValidation = new ArrayList<Orders>();
		OrderBook orderBook = orderBookRepository.findById(orderBookId).get();

		if (!orderBook.isOpen() && !orderBook.isExecute() && orderBook.getValidDemand() == 0) {
			List<Orders> ordersBeforeValidation = orderBook.getOrders();

			if (ordersBeforeValidation != null) {
				for (Orders order : ordersBeforeValidation) {
					if (order.getLimitPrice() > 0 && order.getLimitPrice() < executionPrice) {
						order.setIsValid(false);
					} else if (order.getLimitPrice() == 0 || order.getLimitPrice() >= executionPrice) {
						order.setIsValid(true);
						validDemand = validDemand + order.getQuantity();
					}
					ordersAfterValidation.add(order);
				}
				orderBook.getOrders().clear();
				orderBook.setOrders(ordersAfterValidation);
				orderBook.setValidDemand(validDemand);
				orderBook.setExecutionPrice(executionPrice);
				updateOrderBook(orderBook);
			}
		}
	}

	@Override
	public OrderBook executeOrderBook(Long orderBookId, int executionTotalQty) {
		OrderBook orderBook = orderBookRepository.findById(orderBookId).get();
		int validDemand = orderBook.getValidDemand();
		if (!orderBook.isOpen() && !orderBook.isExecute() && validDemand > 0) {
			int orderQtyExecute = 0;
			int newValidDemand = 0;
			int actualOrderQty = 0;
			List<Orders> updateOrders = new ArrayList<Orders>();
			List<Orders> orders = orderBook.getOrders();
			for (Orders order : orders) {
				actualOrderQty = order.getQuantity() - order.getLastExecuteQty();
				if (order.getIsValid() == true && actualOrderQty > 0) {
					orderQtyExecute = (executionTotalQty * actualOrderQty) / validDemand;
					order.setLastExecuteQty(order.getLastExecuteQty() + orderQtyExecute);
					newValidDemand = newValidDemand + orderQtyExecute;
				}
				updateOrders.add(order);
			}
			orderBook.getOrders().clear();
			orderBook.setOrders(updateOrders);

			orderBook.setValidDemand(orderBook.getValidDemand() - newValidDemand);
			if (orderBook.getValidDemand() == 0) {
				orderBook.setExecute(true);
			}
			updateOrderBook(orderBook);
		}
		return orderBook;
	}

	@Override
	public List<OrderBook> orderBookOpen() {
		return orderBookRepository.orderBookOpen();
	}

	@Override
	public List<OrderBook> orderBookClose() {
		return orderBookRepository.orderBookClose();
	}

	@Override
	public List<OrderBook> findAllorderBook() {
		return orderBookRepository.findAll();
	}
}

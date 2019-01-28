package orderbook.app.proj.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import orderbook.app.proj.dao.OrderBookRepository;
import orderbook.app.proj.dao.OrdersRepository;
import orderbook.app.proj.entities.Orders;
import orderbook.app.proj.entities.StatisticPerBook;

@Service
public class OrdersBusinessImpl implements IOrdersBusiness {

	@Autowired
	private OrdersRepository orderRepository;

	@Autowired
	private OrderBookRepository orderBookRepository;

	@Override
	public Orders saveOrder(Orders order) {
		order.setEntryDate(new Date());
		return orderRepository.save(order);
	}

	@Override
	public StatisticPerBook statisticsOrderPerBookBeforeExecution(Long orderBookId) {
		StatisticPerBook statisticPerBook = new StatisticPerBook();
		statisticPerBook.setTotOrdAmtPerBook(orderRepository.totalOrderAmountPerBook(orderBookId));
		statisticPerBook.setTotDemandPerBook(orderRepository.totalDemandPerBook(orderBookId));
		statisticPerBook.setMaxOrdPerBook(orderRepository.maxOrderPerBook(orderBookId));
		statisticPerBook.setMinOrdPerBook(orderRepository.minOrderPerBook(orderBookId));
		statisticPerBook.setEarliestOrdEntryPerBook(
				orderRepository.earliestOrderEntryPerBook(orderBookId, PageRequest.of(0, 1)).get(0));
		statisticPerBook.setLastOrderEntryPerBook(
				orderRepository.lastOrderEntryPerBook(orderBookId, PageRequest.of(0, 1)).get(0));
		statisticPerBook.setLimitBreakDowns(orderRepository.limitBreakDownPerBook(orderBookId));

		return statisticPerBook;
	}

	@Override
	public StatisticPerBook statisticsOrderPerBookAfterExecution(Long orderBookId) {
		StatisticPerBook statisticPerBook = new StatisticPerBook();
		statisticPerBook.setTotOrdAmtPerBook(orderRepository.totalOrderAmountPerBook(orderBookId));
		statisticPerBook.setTotDemandPerBook(orderRepository.totalDemandPerBook(orderBookId));
		statisticPerBook.setTotValidOrdAmtPerBook(orderRepository.totalValidOrderAmountPerBook(orderBookId));
		statisticPerBook.setTotInvalidOrdAmtPerBook(orderRepository.totalInvalidOrderAmountPerBook(orderBookId));
		statisticPerBook.setTotValidDemandPerBook(orderRepository.totalValidDemandPerBook(orderBookId));
		statisticPerBook.setTotInvalidDemandPerBook(orderRepository.totalInvalidDemandPerBook(orderBookId));
		statisticPerBook.setMaxOrdPerBook(orderRepository.maxOrderPerBook(orderBookId));
		statisticPerBook.setMinOrdPerBook(orderRepository.minOrderPerBook(orderBookId));
		statisticPerBook.setEarliestOrdEntryPerBook(
				orderRepository.earliestOrderEntryPerBook(orderBookId, PageRequest.of(0, 1)).get(0));
		statisticPerBook.setLastOrderEntryPerBook(
				orderRepository.lastOrderEntryPerBook(orderBookId, PageRequest.of(0, 1)).get(0));
		statisticPerBook.setExecPricePerBook(orderBookRepository.execPricePerBook(orderBookId));
		statisticPerBook.setTotExecQtyPerBook(orderRepository.totalExecutionQtyPerBook(orderBookId));
		statisticPerBook.setLimitBreakDowns(orderRepository.limitBreakDownPerBook(orderBookId));

		return statisticPerBook;
	}

	@Override
	public Orders findOrderById(Long orderId) {
		return orderRepository.findById(orderId).get();
	}
}

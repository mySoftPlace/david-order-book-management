package orderbook.app.proj.business;

import orderbook.app.proj.entities.Orders;
import orderbook.app.proj.entities.StatisticPerBook;

public interface IOrdersBusiness {

	// Statistics per order before execution
	public StatisticPerBook statisticsOrderPerBookBeforeExecution(Long orderBookId);

	// Statistics per order after execution
	public StatisticPerBook statisticsOrderPerBookAfterExecution(Long orderBookId);

	public Orders findOrderById(Long orderId);

	public Orders saveOrder(Orders order);
}

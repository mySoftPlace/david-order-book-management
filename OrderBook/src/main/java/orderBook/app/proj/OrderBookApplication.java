package orderBook.app.proj;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import orderBook.app.proj.dao.FinancialInstrumentRepository;
import orderBook.app.proj.dao.OrderBookRepository;
import orderBook.app.proj.dao.OrdersRepository;
import orderBook.app.proj.entities.FinancialInstrument;
import orderBook.app.proj.entities.OrderBook;
import orderBook.app.proj.entities.Orders;

@SpringBootApplication
public class OrderBookApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrderBookApplication.class, args);
		orderBook.app.proj.dao.FinancialInstrumentRepository financialInstrumentRepository = ctx
				.getBean(FinancialInstrumentRepository.class);
		orderBook.app.proj.dao.OrdersRepository orderRepository = ctx.getBean(OrdersRepository.class);
		orderBook.app.proj.dao.OrderBookRepository orderBookRepository = ctx.getBean(OrderBookRepository.class);

		FinancialInstrument financialInstrument1 = financialInstrumentRepository
				.save(new FinancialInstrument("FinancialInstrument1"));
		financialInstrumentRepository.save(new FinancialInstrument("FinancialInstrument2"));

		OrderBook orderBook = orderBookRepository
				.save(new OrderBook("BookForInstrument1", 0, 0, null, financialInstrument1));

		orderRepository.save(new Orders(158, 2.95, 0, new Date(), financialInstrument1, orderBook));
		orderRepository.save(new Orders(210, 1.79, 0, new Date(), financialInstrument1, orderBook));
		orderRepository.save(new Orders(91, 3.89, 0, new Date(), financialInstrument1, orderBook));

		financialInstrumentRepository.findAll()
				.forEach(finIns -> System.out.println("OrderBookName: " + finIns.getFinInstrName()));

		orderBookRepository.findAll().forEach(ordb -> System.out.println("OrderBookName: " + ordb.getOrderBookName()));

		orderRepository.findAll().forEach(ord -> System.out.println("Limit Price: " + ord.getLimitPrice()));
	}

}


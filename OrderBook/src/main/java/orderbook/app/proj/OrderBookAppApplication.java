package orderbook.app.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import orderbook.app.proj.dao.FinancialInstrumentRepository;
import orderbook.app.proj.entities.FinancialInstrument;

/**
 * 
 * @author David Sossavi
 * 
 *         Start the spring boot application and save some data to the database
 *
 */
@SpringBootApplication
public class OrderBookAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrderBookAppApplication.class, args);
		orderbook.app.proj.dao.FinancialInstrumentRepository financialInstrumentRepository = ctx
				.getBean(FinancialInstrumentRepository.class);

		financialInstrumentRepository.save(new FinancialInstrument("FinancialInstrument1"));
		financialInstrumentRepository.save(new FinancialInstrument("FinancialInstrument2"));

		financialInstrumentRepository.findAll()
				.forEach(finIns -> System.out.println("Financial instrument: " + finIns.getFinInstrName()));
	}
}

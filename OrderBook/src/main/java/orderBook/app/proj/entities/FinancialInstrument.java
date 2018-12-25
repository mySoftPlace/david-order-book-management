package orderBook.app.proj.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FinancialInstrument")
public class FinancialInstrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long finInstrId;
	private String finInstrName;

	public FinancialInstrument() {

	}

	public FinancialInstrument(String finInstrName) {
		super();
		this.finInstrName = finInstrName;
	}

	public Long getFinInstrId() {
		return finInstrId;
	}

	public void setFinInstrId(Long finInstrId) {
		this.finInstrId = finInstrId;
	}

	public String getFinInstrName() {
		return finInstrName;
	}

	public void setFinInstrName(String finInstrName) {
		this.finInstrName = finInstrName;
	}

	/*
	 * public List<OrderBook> getOrderBooks() { return orderBooks; }
	 * 
	 * public void setOrderBooks(List<OrderBook> orderBooks) { this.orderBooks =
	 * orderBooks; }
	 */

}

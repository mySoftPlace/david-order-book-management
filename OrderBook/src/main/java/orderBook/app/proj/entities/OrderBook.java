package orderBook.app.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author David Sossavi
 * 
 *         The entity to persist Order book in the database
 *
 */
@Entity
@Table(name = "OrderBook")
public class OrderBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long orderBookId;
	private String orderBookName;
	private double executionPrice;
	private int validDemand;
	private boolean isOpen;
	private boolean isExecute;

	@JsonIgnore
	@OneToMany(mappedBy = "orderBook", fetch = FetchType.LAZY)
	private List<Orders> orders;

	@ManyToOne
	@JoinColumn(name = "finInstrId")
	private FinancialInstrument financialInstrument;

	public OrderBook() {

	}

	public Long getOrderBookId() {
		return orderBookId;
	}

	public OrderBook(String orderBookName, double executionPrice, int validDemand, List<Orders> orders,
			FinancialInstrument financialInstrument) {
		super();
		this.orderBookName = orderBookName;
		this.executionPrice = executionPrice;
		this.validDemand = validDemand;
		this.orders = orders;
		this.financialInstrument = financialInstrument;
	}

	public void setOrderBookId(Long orderBookId) {
		this.orderBookId = orderBookId;
	}

	public String getOrderBookName() {
		return orderBookName;
	}

	public void setOrderBookName(String orderBookName) {
		this.orderBookName = orderBookName;
	}

	public double getExecutionPrice() {
		return executionPrice;
	}

	public void setExecutionPrice(double executionPrice) {
		this.executionPrice = executionPrice;
	}

	public int getValidDemand() {
		return validDemand;
	}

	public void setValidDemand(int validDemand) {
		this.validDemand = validDemand;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public FinancialInstrument getFinancialInstrument() {
		return financialInstrument;
	}

	public void setFinancialInstrument(FinancialInstrument financialInstrument) {
		this.financialInstrument = financialInstrument;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isExecute() {
		return isExecute;
	}

	public void setExecute(boolean isExecute) {
		this.isExecute = isExecute;
	}
}

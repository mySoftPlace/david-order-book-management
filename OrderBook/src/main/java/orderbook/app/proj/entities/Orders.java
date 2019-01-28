package orderbook.app.proj.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author David Sossavi
 * 
 *         The entity to persist Order in the database
 *
 */
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long orderId;
	private int quantity;
	private double limitPrice;
	private int lastExecuteQty;
	private Date entryDate;
	private Boolean isValid;
	private FinancialInstrument financialInstrument;

	@ManyToOne
	@JoinColumn(name = "orderBookId")
	private OrderBook orderBook;

	public Orders() {

	}

	public Orders(int quantity, double limitPrice, int lastExecuteQty, Date entryDate,
			FinancialInstrument financialInstrument, OrderBook orderBook) {
		super();
		this.quantity = quantity;
		this.limitPrice = limitPrice;
		this.lastExecuteQty = lastExecuteQty;
		this.entryDate = entryDate;
		this.financialInstrument = financialInstrument;
		this.orderBook = orderBook;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public FinancialInstrument getFinancialInstrument() {
		return financialInstrument;
	}

	public void setFinancialInstrument(FinancialInstrument financialInstrument) {
		this.financialInstrument = financialInstrument;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public OrderBook getOrderBook() {
		return orderBook;
	}

	public void setOrderBook(OrderBook orderBook) {
		this.orderBook = orderBook;
	}

	public int getLastExecuteQty() {
		return lastExecuteQty;
	}

	public void setLastExecuteQty(int lastExecuteQty) {
		this.lastExecuteQty = lastExecuteQty;
	}

}

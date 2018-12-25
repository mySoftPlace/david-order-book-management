package orderBook.app.proj.entities;

import java.io.Serializable;

/**
 * 
 * @author David Sossavi
 * 
 *         This class is used to display statistic data
 *
 */
public class StatisticPerBook implements Serializable {

	private static final long serialVersionUID = 1L;

	private double totOrdAmtPerBook;

	private Integer totDemandPerBook;

	private Integer maxOrdPerBook;

	private Integer minOrdPerBook;

	private Orders earliestOrdEntryPerBook;

	private Orders lastOrderEntryPerBook;

	private double limitBrkDownPerBook;

	private double execPricePerBook;

	private double totValidOrdAmtPerBook;

	private Double totInvalidOrdAmtPerBook;

	private Integer totInvalidDemandPerBook;

	private Integer totValidDemandPerBook;

	public Integer totExecQtyPerBook;

	public StatisticPerBook() {

	}

	public double getTotOrdAmtPerBook() {
		return totOrdAmtPerBook;
	}

	public void setTotOrdAmtPerBook(double totOrdAmtPerBook) {
		this.totOrdAmtPerBook = totOrdAmtPerBook;
	}

	public Integer getTotDemandPerBook() {
		return totDemandPerBook;
	}

	public void setTotDemandPerBook(Integer totDemandPerBook) {
		this.totDemandPerBook = totDemandPerBook;
	}

	public Integer getMaxOrdPerBook() {
		return maxOrdPerBook;
	}

	public void setMaxOrdPerBook(Integer maxOrdPerBook) {
		this.maxOrdPerBook = maxOrdPerBook;
	}

	public Integer getMinOrdPerBook() {
		return minOrdPerBook;
	}

	public void setMinOrdPerBook(Integer minOrdPerBook) {
		this.minOrdPerBook = minOrdPerBook;
	}

	public Orders getEarliestOrdEntryPerBook() {
		return earliestOrdEntryPerBook;
	}

	public void setEarliestOrdEntryPerBook(Orders earliestOrdEntryPerBook) {
		this.earliestOrdEntryPerBook = earliestOrdEntryPerBook;
	}

	public Orders getLastOrderEntryPerBook() {
		return lastOrderEntryPerBook;
	}

	public void setLastOrderEntryPerBook(Orders lastOrderEntryPerBook) {
		this.lastOrderEntryPerBook = lastOrderEntryPerBook;
	}

	public double getLimitBrkDownPerBook() {
		return limitBrkDownPerBook;
	}

	public void setLimitBrkDownPerBook(double limitBrkDownPerBook) {
		this.limitBrkDownPerBook = limitBrkDownPerBook;
	}

	public double getExecPricePerBook() {
		return execPricePerBook;
	}

	public void setExecPricePerBook(double execPricePerBook) {
		this.execPricePerBook = execPricePerBook;
	}

	public double getTotValidOrdAmtPerBook() {
		return totValidOrdAmtPerBook;
	}

	public void setTotValidOrdAmtPerBook(double totValidOrdAmtPerBook) {
		this.totValidOrdAmtPerBook = totValidOrdAmtPerBook;
	}

	public Double getTotInvalidOrdAmtPerBook() {
		return totInvalidOrdAmtPerBook;
	}

	public void setTotInvalidOrdAmtPerBook(Double totInvalidOrdAmtPerBook) {
		this.totInvalidOrdAmtPerBook = totInvalidOrdAmtPerBook;
	}

	public Integer getTotInvalidDemandPerBook() {
		return totInvalidDemandPerBook;
	}

	public void setTotInvalidDemandPerBook(Integer totInvalidDemandPerBook) {
		this.totInvalidDemandPerBook = totInvalidDemandPerBook;
	}

	public Integer getTotValidDemandPerBook() {
		return totValidDemandPerBook;
	}

	public void setTotValidDemandPerBook(Integer totValidDemandPerBook) {
		this.totValidDemandPerBook = totValidDemandPerBook;
	}

	public Integer getTotExecQtyPerBook() {
		return totExecQtyPerBook;
	}

	public void setTotExecQtyPerBook(Integer totExecQtyPerBook) {
		this.totExecQtyPerBook = totExecQtyPerBook;
	}

}

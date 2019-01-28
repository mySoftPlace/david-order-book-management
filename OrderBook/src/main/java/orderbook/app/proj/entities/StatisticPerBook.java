package orderbook.app.proj.entities;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author David Sossavi
 * 
 *         This class is used to display statistic data
 *
 */
public class StatisticPerBook implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double totOrdAmtPerBook;

	private Integer totDemandPerBook;

	private Integer maxOrdPerBook;

	private Integer minOrdPerBook;

	private Orders earliestOrdEntryPerBook;

	private Orders lastOrderEntryPerBook;

	private Double execPricePerBook;

	private Double totValidOrdAmtPerBook;

	private Double totInvalidOrdAmtPerBook;

	private Integer totInvalidDemandPerBook;

	private Integer totValidDemandPerBook;

	public Integer totExecQtyPerBook;
	
	public List<LimitBreakDown> limitBreakDowns;

	public StatisticPerBook() {

	}

	public Double getTotOrdAmtPerBook() {
		return totOrdAmtPerBook;
	}

	public void setTotOrdAmtPerBook(Double totOrdAmtPerBook) {
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

	public Double getExecPricePerBook() {
		return execPricePerBook;
	}

	public void setExecPricePerBook(Double execPricePerBook) {
		this.execPricePerBook = execPricePerBook;
	}

	public Double getTotValidOrdAmtPerBook() {
		return totValidOrdAmtPerBook;
	}

	public void setTotValidOrdAmtPerBook(Double totValidOrdAmtPerBook) {
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

	public List<LimitBreakDown> getLimitBreakDowns() {
		return limitBreakDowns;
	}

	public void setLimitBreakDowns(List<LimitBreakDown> limitBreakDowns) {
		this.limitBreakDowns = limitBreakDowns;
	}
}

package orderbook.app.proj.entities;

/**
 * 
 * @author David Sossavi
 * 
 *         This class is used to display limit break down statistic data
 *
 */
public class LimitBreakDown {
	
	private Double limitBreakDownPrice;

	private Long limitBreakDownDemand;

	public LimitBreakDown() {

	}

	public LimitBreakDown(Double limitBreakDownPrice, Long limitBreakDownDemand) {
		super();
		this.limitBreakDownPrice = limitBreakDownPrice;
		this.limitBreakDownDemand = limitBreakDownDemand;
	}



	public Double getLimitBreakDownPrice() {
		return limitBreakDownPrice;
	}

	public void setLimitBreakDownPrice(Double limitBreakDownPrice) {
		this.limitBreakDownPrice = limitBreakDownPrice;
	}

	public Long getLimitBreakDownDemand() {
		return limitBreakDownDemand;
	}

	public void setLimitBreakDownDemand(Long limitBreakDownDemand) {
		this.limitBreakDownDemand = limitBreakDownDemand;
	}
}

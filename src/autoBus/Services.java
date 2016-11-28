package autoBus;

import java.io.Serializable;

public class Services implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean breakfastIncluded;
	private boolean lunchIncluded;
	private boolean allInclusive;
	private boolean entranceTickets;
	private PriceList priceList;
	
	public Services() throws Exception {
		this.breakfastIncluded=false;
		this.lunchIncluded=false;
		this.allInclusive=false;
		this.entranceTickets=false;
		this.priceList = new PriceList();
	}

	public boolean isBreakfastIncluded() {
		return breakfastIncluded;
	}

	public void setBreakfastIncluded(boolean breakfastIncluded) {
		this.breakfastIncluded = breakfastIncluded;
	}

	public boolean isLunchIncluded() {
		return lunchIncluded;
	}

	public void setLunchIncluded(boolean lunchIncluded) {
		this.lunchIncluded = lunchIncluded;
	}

	public boolean isAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}

	public boolean isEntranceTickets() {
		return entranceTickets;
	}

	public void setEntranceTickets(boolean entranceTickets) {
		this.entranceTickets = entranceTickets;
	}
	
	public double getPriceBreakfast() {
		return priceList.getPriceBreakfast();
	}
	
	public double getPriceLunch() {
		return priceList.getPriceLunch();
	}
	
	public double getPriceAllInclusive() {
		return priceList.getPriceAllInclusive();
	}
	
	public double getPriceEntranceTickets() {
		return priceList.getPriceEntranceTickets();
	}
	
	public double getTotalPrice(){
		double total = 0;
		if (breakfastIncluded){
			total += getPriceBreakfast();
		}
		if (lunchIncluded){
			total += getPriceLunch();
		}
		if (allInclusive) {
			total += getPriceAllInclusive();
		}
		if (entranceTickets) {
			total += getPriceEntranceTickets();
		}
		return total;
	}
	

}

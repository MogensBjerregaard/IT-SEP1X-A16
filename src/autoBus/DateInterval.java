package autoBus;

public class DateInterval {
	private Date startDate;
	private Date endDate;
	
	public DateInterval(Date startDate, Date endDate){
		this.startDate=startDate;
		this.endDate=endDate;
	}
	
	public DateInterval(){
		this.startDate = new Date(0, 0, 0);
		this.endDate = new Date(0, 0, 0);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}

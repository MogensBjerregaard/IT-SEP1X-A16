package autoBus;

import java.util.Date;

public class DateInterval {
	private Date startDate;
	private Date endDate;
	
	public DateInterval(Date startDate, Date endDate){
		this.startDate=startDate;
		this.endDate=endDate;
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

package autoBus;

import java.io.Serializable;

public class Date implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int month, day, year;
	
	public Date(int month, int day, int year){
		this.month=month;
		if (day<1){
			this.day=1;
		} else if(day>getLengthOfMonth()){
			this.day=getLengthOfMonth();
		} else {
			this.day=day;
		}	
		this.year=year;
	}
	public boolean isLeapYear(){
		if (this.year%4==0&&this.year%100!=0||this.year%400==0){
			return true;
		}else {
			return false;
		}
	}
	public int getLengthOfMonth(){
		if (this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12){
			return 31;
		} else if (this.month==4||this.month==6||this.month==9||this.month==11) {
			return 30;
		} else if(this.month==2&&isLeapYear()==true){
			return 29;
		} else {
			return 28;
		}
	}
	public void goToNextDay(){
		if (this.day++<getLengthOfMonth()){
			this.day++;
		} else if(this.month!=12){
			this.day=1;
			this.month++;
		} else {
			this.day=1;
			this.month=1;
			this.year++;
		}
	}
	public void advanceDays(int days){
		for (int i=0;i<days;i++){
			goToNextDay();
		}
	}
	public void setMonth(int month){
		this.month=month;
	}
	public void setDay(int day){
		if (day<1){
			this.day=1;
		} else if(day>getLengthOfMonth()){
			this.day=getLengthOfMonth();
		} else {
			this.day=day;
		}	
	}
	public void setYear(int year){
		this.year=year;
	}
	public int getMonth(){
		return this.month;
	}
	public int getDay(){
		return this.day;
	}
	public int getYear(){
		return this.year;
	}
	
	public String displayDate(){
		String date=day+"/"+month+"/"+year;
		return date;
	}
	public boolean equals(Date otherDate){
		return this.day==otherDate.day
				&& this.month==otherDate.month
				&& this.year==otherDate.year;
	}
	public Date copy(){
		return new Date(this.month, this.day, this.year);
	}
}

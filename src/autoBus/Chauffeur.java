package autoBus;

import java.io.Serializable;


public class Chauffeur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String address;
	private Date birthday;
	private String phonenumber;
	private String employeeNumber;
	private boolean externalEmployee;
	private boolean available;
	private boolean onlyOneDayTrips;
	
	public Chauffeur(String name, String email, String address, int month, int day, int year, String phonenumber, String employeeNumber,
			boolean externalEmployee, boolean onlyOneDayTrips) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = new Date(month, day, year);
		this.phonenumber = phonenumber;
		this.employeeNumber = employeeNumber;
		this.externalEmployee = externalEmployee;
		this.available = true;
		this.onlyOneDayTrips = onlyOneDayTrips;
	}
	
	public String getPhonenumber(){
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber){
		this.phonenumber=phonenumber;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public boolean isExternalEmployee() {
		return externalEmployee;
	}

	public void setExternalEmployee(boolean externalEmployee) {
		this.externalEmployee = externalEmployee;
	}


	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


	public boolean isOnlyOneDayTrips() {
		return onlyOneDayTrips;
	}

	public void setOnlyOneDayTrips(boolean onlyOneDayTrips) {
		this.onlyOneDayTrips = onlyOneDayTrips;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public String getBirthDay(){
		return birthday.displayDate();
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}

package autoBus;

import java.io.Serializable;

public abstract class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	String email;
	String address;
	Date birthday;
	
	
	//TESTING CONSTRUCTORS
	public Person(){}
	public Person(String name){
	   this.name = name;
	}
	
	//
	public Person(String name,String email, String address, Date birthday) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
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

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}

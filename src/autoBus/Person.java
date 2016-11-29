package autoBus;

public abstract class Person{
	String name;
	String email;
	String address;
	String phoneNumber;
	Date birthday;
	
	public Person(String name, String phoneNumber, String email, String address, Date birthday) {
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

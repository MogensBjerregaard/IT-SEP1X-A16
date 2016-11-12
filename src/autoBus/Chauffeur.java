package autoBus;

import java.io.Serializable;

public class Chauffeur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	
	public Chauffeur(String firstName, String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
}

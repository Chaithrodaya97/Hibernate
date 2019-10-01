package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Chaithrodaya BS
 * Creation Date and Time - 26-09-19 2.45 PM
 * Modification Date and Time - 26-09-19 2.45 PM
 * 
 */

@Embeddable
public class Name 
{
	@Column(name ="first",length = 30)
	private String firstName;
	@Column(name ="middle",length = 30)
	private String middleName;
	@Column(name ="last",length = 30)
	private String lastName;
	
	public Name() {
		// TODO Auto-generated constructor stub
	}

	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
	
	
}

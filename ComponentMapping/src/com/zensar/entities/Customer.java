package com.zensar.entities;

import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
* @author Chaithrodaya BS
* Creation Date and Time - 26-09-19 2.55 PM
* Modification Date and Time - 26-09-19 2.55 PM
* 
*/
@Entity
@Table(name = "customer")

public class Customer 
{
	@Id
	@Column(name = "cid")
	
	private int customerId;
	private Name customerName;
	private String gender;
	private int age;
	private Blob profilePhoto;
	private Clob description;
	
	@Column(nullable = false)
	private String address;
	private LocalDate dob;
	


	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	
	public Customer(int customerId, Name customerName, String gender, int age, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Name getCustomerName() {
		return customerName;
	}
	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Blob getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	

	public Clob getDescription() {
		return description;
	}

	public void setDescription(Clob description) {
		this.description = description;
	}

	@Override
	public String toString() 
	{
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender + ", age="
				+ age + ", profilePhoto=" + profilePhoto + ", description=" + description + ", address=" + address
				+ ", dob=" + dob + "]";
	}

	}
	
	



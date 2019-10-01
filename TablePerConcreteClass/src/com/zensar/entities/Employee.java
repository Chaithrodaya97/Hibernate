package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author Chaithrodaya B S
 * Creation Date: 27-09-19 11.20 AM
 * Modification Date: 27-09-19 11.20 AM
 * version 2.0
 */

@Entity
@Table(name="emp_master_1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //Automatic empId generation
	private int empId;
	private String Name;
	private LocalDate joinDate;
	private double salary;
	
public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(int empId, String name, LocalDate joinDate, double salary) {
	super();
	this.empId = empId;
	Name = name;
	this.joinDate = joinDate;
	this.salary = salary;
}

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public LocalDate getJoinDate() {
	return joinDate;
}

public void setJoinDate(LocalDate joinDate) {
	this.joinDate = joinDate;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [empId=" + empId + ", Name=" + Name + ", joinDate=" + joinDate + ", salary=" + salary + "]";
}
	
	
	
}

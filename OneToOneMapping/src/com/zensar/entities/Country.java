package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Chaithrodaya B S
 * @Creation date 27-09-19 2.50 PM
 * @Modification date 27-09-19 2.50 PM
 * @Description: Primary Key Constraint
 */

@Entity
public class Country
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int countryId;
	private String name;
	private String language;
	private long population;
	@OneToOne
	@JoinColumn(name = "flagId")
	private Flag flag;
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Flag getFlag() {
		return flag;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
	
}

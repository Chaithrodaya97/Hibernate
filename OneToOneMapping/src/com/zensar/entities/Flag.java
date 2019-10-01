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
public class Flag 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flagId;
	private String flagName;
	private String description;
	@OneToOne(mappedBy ="flag" )
	//@JoinColumn(name = "country_id")
	private Country country;
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}

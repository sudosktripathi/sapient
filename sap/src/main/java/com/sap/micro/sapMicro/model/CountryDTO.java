package com.sap.micro.sapMicro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939894020085843262L;

	@JsonProperty(value = "country_name")
	String countryName;
	
	@JsonProperty(value = "country_id")
	String countryId;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}

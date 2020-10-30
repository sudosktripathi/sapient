package com.sap.micro.sapMicro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5276233829916550655L;

	@JsonProperty(value = "country_id")
	private String countryId;
	
	@JsonProperty(value = "country_name")
	private String countryName;
	
	@JsonProperty(value = "league_id")
	private String leagueId;
	
	@JsonProperty(value = "league_name")
	private String leagueName;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
}

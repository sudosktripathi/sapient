package com.sap.micro.sapMicro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class RankingDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -874344945563589284L;

	@JsonProperty(value = "country_id")
	private String countryId;

	@JsonProperty(value = "country_name")
	private String countryName;
	
	@JsonProperty(value = "league_id")
	private String leagueId;
	
	@JsonProperty(value = "league_name")
	private String LeagueName;
	
	@JsonProperty(value = "team_id")
	private String teamId;
	
	@JsonProperty(value = "team_name")
	private String teamName;
	
	@JsonProperty(value = "overall_league_position")
	private String overallRanking;
	
	public RankingDTO() {
		super();
	}
	
	public RankingDTO(String countryName, String leagueId, String leagueName, String teamId, String teamName,
			String overallRanking) {
		super();
		this.countryName = countryName;
		this.leagueId = leagueId;
		LeagueName = leagueName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.overallRanking = overallRanking;
	}



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
		return LeagueName;
	}

	public void setLeagueName(String leagueName) {
		LeagueName = leagueName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOverallRanking() {
		return overallRanking;
	}

	public void setOverallRanking(String overallRanking) {
		this.overallRanking = overallRanking;
	}
}

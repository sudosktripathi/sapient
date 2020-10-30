package com.sap.micro.sapMicro.service;

public interface FootBallService {
	
	String getCountries(String countryName) ;

	String getRankings(String leagueId);

	String getLeagues(String countryId, String leagueName);

}

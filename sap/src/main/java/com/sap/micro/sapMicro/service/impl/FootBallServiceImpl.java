package com.sap.micro.sapMicro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sap.micro.sapMicro.service.FootBallService;

@Service
public class FootBallServiceImpl implements FootBallService {

	@Value("${apiFootball.url}")
	String getFootballApi;

	@Value("${apiFootball.getApiKey}")
	String apiKey;

	@Autowired
	RestTemplate getRestClient;

	@Override
	public String getRankings(String leagueId) {

		String url = getFootballApi.concat("?action=get_standings&league_id=").concat(leagueId).concat("&APIkey=")
				.concat(apiKey);

		ResponseEntity<String> response = getRestClient.getForEntity(url, String.class);

		if (response != null) {
			return response.getBody();
		}

		return null;
	}

	@Override
	public String getCountries(String countryName) {

		String url = getFootballApi.concat("?action=get_countries&APIkey=").concat(apiKey);

		ResponseEntity<String> response = getRestClient.getForEntity(url, String.class);

		if (response != null) {
			return response.getBody();
		}

		return null;
	}

	@Override
	public String getLeagues(String countryId, String leagueName) {
		String url = getFootballApi.concat("?action=get_leagues&country_id=").concat(countryId).concat("&APIkey=")
				.concat(apiKey);

		ResponseEntity<String> response = getRestClient.getForEntity(url, String.class);

		if (response != null) {
			return response.getBody();
		}
		return null;
	}

}

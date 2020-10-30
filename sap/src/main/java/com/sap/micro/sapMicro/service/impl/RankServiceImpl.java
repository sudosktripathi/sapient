package com.sap.micro.sapMicro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.micro.sapMicro.exception.ValidationException;
import com.sap.micro.sapMicro.model.CountryDTO;
import com.sap.micro.sapMicro.model.LeagueDTO;
import com.sap.micro.sapMicro.model.RankingDTO;
import com.sap.micro.sapMicro.model.ResultDTO;
import com.sap.micro.sapMicro.service.FootBallService;
import com.sap.micro.sapMicro.service.RankService;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	FootBallService footballService;

	@Override
	public ResultDTO getRank(String countryName, String leagueName, String teamName) {

		ResultDTO result = new ResultDTO();
		try {
			
			if(countryName == null || countryName.isEmpty() ||
					leagueName == null || leagueName.isEmpty() ||
					teamName == null || teamName.isEmpty()) {
				
				throw new ValidationException("Missing input", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()); 
			}
			
			// validate country name and get country ID
			String countryId = validateAndGetCountry(countryName);

			// getLeagueID
			String leagueId = validateAndGetLeague(countryId, leagueName);

			String response = footballService.getRankings(leagueId);

			if (response != null) {
				List<RankingDTO> rankings = new ObjectMapper().readValue(response,
						new TypeReference<List<RankingDTO>>() {
						});

				if (rankings != null && !rankings.isEmpty()) {

					Optional<RankingDTO> check = rankings.stream()
							.filter(ranks -> ranks.getCountryName().equalsIgnoreCase(countryName)
									&& ranks.getLeagueId().equalsIgnoreCase(leagueId) && ranks.getTeamName().equalsIgnoreCase(teamName))
							.findFirst();

					RankingDTO rank = check.orElseThrow(() -> new ValidationException("Rank not found",
							HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));

					result.setResult(rank);

				}
			} else {
				throw new ValidationException("Rank not found", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}

		} catch (ValidationException ex) {
			result.setErrorMessage(ex.getErrorMessage());
			result.setCode(ex.getCode());
			result.setStatusCode(ex.getStatusCode());
		} catch (Exception e) {
			result.setErrorMessage("Internal error !!");
			result.setCode(HttpStatus.EXPECTATION_FAILED);
			result.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		}
		return result;
	}

	public String validateAndGetCountry(String countryName) throws ValidationException {
		try {
			String response = footballService.getCountries(countryName);

			if (response != null) {
				List<CountryDTO> countries = new ObjectMapper().readValue(response,
						new TypeReference<List<CountryDTO>>() {
						});

				if (countries != null && !countries.isEmpty()) {

					Optional<CountryDTO> check = countries.stream()
							.filter(country -> country.getCountryName().equalsIgnoreCase(countryName)).findFirst();

					CountryDTO country = check.orElseThrow(() -> new ValidationException("Country not found",
							HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));

					return country.getCountryId();
				}
			} else {
				throw new ValidationException("Country not found", HttpStatus.BAD_REQUEST,
						HttpStatus.BAD_REQUEST.value());
			}
		} catch (Exception e) {
			throw new ValidationException("Country not found", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}

		return null;
	}

	public String validateAndGetLeague(String countryId, String leagueName) throws ValidationException {
		try {

			String response = footballService.getLeagues(countryId, leagueName);

			if (response != null) {
				List<LeagueDTO> leagues = new ObjectMapper().readValue(response, new TypeReference<List<LeagueDTO>>() {
				});

				if (leagues != null && !leagues.isEmpty()) {

					Optional<LeagueDTO> check = leagues.stream()
							.filter(league -> league.getCountryId().equalsIgnoreCase(countryId)
									&& league.getLeagueName().equalsIgnoreCase(leagueName))
							.findFirst();

					LeagueDTO league = check.orElseThrow(() -> new ValidationException("League not found",
							HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));

					return league.getLeagueId();
				}
			} else {
				throw new ValidationException("League not found", HttpStatus.BAD_REQUEST,
						HttpStatus.BAD_REQUEST.value());
			}
		} catch (Exception e) {
			throw new ValidationException("League not found", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return null;
	}
}

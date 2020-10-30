package com.sap.micro.sapMicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sap.micro.sapMicro.model.ResultDTO;
import com.sap.micro.sapMicro.service.RankService;

@Controller
@RequestMapping("/football")
public class RankingController {

	@Autowired
	private RankService rankService;
	
	/*
	 * Develop, Test and Deploy a microservice to find standings of a team playing
	 * league football match using country name, league name and team name. The
	 * service should be accessible via web browser on internet and end user should
	 * be able to view results by changing previously listed parameters. Output
	 */
	@GetMapping("/rank")
	public ResponseEntity<ResultDTO> getRank(@RequestParam(name = "country") String countryName,
			@RequestParam(name = "league") String leagueName, @RequestParam(name = "team") String teamName) {

		ResultDTO result = rankService.getRank(countryName, leagueName, teamName);
		
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);

	}

}

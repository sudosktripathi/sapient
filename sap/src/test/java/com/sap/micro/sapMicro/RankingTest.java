package com.sap.micro.sapMicro;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.sap.micro.sapMicro.model.ResultDTO;
import com.sap.micro.sapMicro.service.FootBallService;
import com.sap.micro.sapMicro.service.RankService;
import com.sap.micro.sapMicro.service.impl.RankServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RankingTest {

	@Mock
	private RestTemplate getRestClient;

	@InjectMocks
	private static RankService rankingService = new RankServiceImpl();

	@Mock
	private static FootBallService footballService;

	String getFootballApi = "https://apiv2.apifootball.com/";

	String apiKey = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";

	@Test
	public void TestRankingMethod_Success() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";

		String leagueResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"league_id\": \"149\",\r\n" + "	\"league_name\": \"Championship\",\r\n"
				+ "	\"league_season\": \"2020\\/2021\",\r\n"
				+ "	\"league_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_leagues\\/149_championship.png\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}]";

		String rankingResponse = "[{\r\n" + "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2647\",\r\n"
				+ "	\"team_name\": \"Reading\",\r\n" + "	\"overall_promotion\": \"Promotion - Premier League\",\r\n"
				+ "	\"overall_league_position\": \"1\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"7\",\r\n" + "	\"overall_league_D\": \"1\",\r\n"
				+ "	\"overall_league_L\": \"0\",\r\n" + "	\"overall_league_GF\": \"15\",\r\n"
				+ "	\"overall_league_GA\": \"3\",\r\n" + "	\"overall_league_PTS\": \"22\",\r\n"
				+ "	\"home_league_position\": \"1\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"4\",\r\n"
				+ "	\"home_league_D\": \"0\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"7\",\r\n" + "	\"home_league_GA\": \"0\",\r\n"
				+ "	\"home_league_PTS\": \"12\",\r\n" + "	\"away_league_position\": \"2\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"3\",\r\n" + "	\"away_league_D\": \"1\",\r\n"
				+ "	\"away_league_L\": \"0\",\r\n" + "	\"away_league_GF\": \"8\",\r\n"
				+ "	\"away_league_GA\": \"3\",\r\n" + "	\"away_league_PTS\": \"10\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2647_reading.png\"\r\n" + "}, {\r\n"
				+ "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2615\",\r\n"
				+ "	\"team_name\": \"Bournemouth\",\r\n"
				+ "	\"overall_promotion\": \"Promotion - Premier League\",\r\n"
				+ "	\"overall_league_position\": \"2\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"4\",\r\n" + "	\"overall_league_D\": \"4\",\r\n"
				+ "	\"overall_league_L\": \"0\",\r\n" + "	\"overall_league_GF\": \"11\",\r\n"
				+ "	\"overall_league_GA\": \"6\",\r\n" + "	\"overall_league_PTS\": \"16\",\r\n"
				+ "	\"home_league_position\": \"3\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"3\",\r\n"
				+ "	\"home_league_D\": \"1\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"5\",\r\n" + "	\"home_league_GA\": \"2\",\r\n"
				+ "	\"home_league_PTS\": \"10\",\r\n" + "	\"away_league_position\": \"10\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"1\",\r\n" + "	\"away_league_D\": \"3\",\r\n"
				+ "	\"away_league_L\": \"0\",\r\n" + "	\"away_league_GF\": \"6\",\r\n"
				+ "	\"away_league_GA\": \"4\",\r\n" + "	\"away_league_PTS\": \"6\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2615_bournemouth.png\"\r\n"
				+ "}, {\r\n" + "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2638\",\r\n"
				+ "	\"team_name\": \"Millwall\",\r\n"
				+ "	\"overall_promotion\": \"Promotion - Championship (Play Offs)\",\r\n"
				+ "	\"overall_league_position\": \"3\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"4\",\r\n" + "	\"overall_league_D\": \"3\",\r\n"
				+ "	\"overall_league_L\": \"1\",\r\n" + "	\"overall_league_GF\": \"10\",\r\n"
				+ "	\"overall_league_GA\": \"5\",\r\n" + "	\"overall_league_PTS\": \"15\",\r\n"
				+ "	\"home_league_position\": \"11\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"1\",\r\n"
				+ "	\"home_league_D\": \"3\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"4\",\r\n" + "	\"home_league_GA\": \"2\",\r\n"
				+ "	\"home_league_PTS\": \"6\",\r\n" + "	\"away_league_position\": \"3\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"3\",\r\n" + "	\"away_league_D\": \"0\",\r\n"
				+ "	\"away_league_L\": \"1\",\r\n" + "	\"away_league_GF\": \"6\",\r\n"
				+ "	\"away_league_GA\": \"3\",\r\n" + "	\"away_league_PTS\": \"9\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2638_millwall.png\"\r\n" + "}]";

		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);

		Mockito.when(footballService.getLeagues(Mockito.anyString(), Mockito.anyString())).thenReturn(leagueResponse);

		Mockito.when(footballService.getRankings(Mockito.anyString())).thenReturn(rankingResponse);

		ResultDTO result = rankingService.getRank("England", "Championship", "Reading");

		assertNotNull(result.getResult());
	}
	
	@Test
	public void TestRankingMethod_CountryNotProvided() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"Italy\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_Italy.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";


		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);

		ResultDTO result = rankingService.getRank("", "Championship", "Liverpool");

		assertEquals(result.getErrorMessage(), "Missing input");
	}
	
	
	@Test
	public void TestRankingMethod_LeagueNotProvided() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"Italy\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_Italy.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";


		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);

		ResultDTO result = rankingService.getRank("England", null , "Liverpool");

		assertEquals(result.getErrorMessage(), "Missing input");
	}
	
	@Test
	public void TestRankingMethod_TeamNotProvided() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"Italy\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_Italy.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";


		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);

		ResultDTO result = rankingService.getRank("England", "Championship", null);

		assertEquals(result.getErrorMessage(), "Missing input");
	}
	
	@Test
	public void TestRankingMethod_CountryNotFound() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"Italy\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_Italy.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";


		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);

		ResultDTO result = rankingService.getRank("England", "Championship", "Liverpool");

		assertEquals(result.getErrorMessage(), "Country not found");
	}
	
	@Test
	public void TestRankingMethod_LeagueNotFound() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";

		String leagueResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"league_id\": \"149\",\r\n" + "	\"league_name\": \"Champs\",\r\n"
				+ "	\"league_season\": \"2020\\/2021\",\r\n"
				+ "	\"league_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_leagues\\/149_championship.png\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}]";


		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);
		
		Mockito.when(footballService.getLeagues(Mockito.anyString(), Mockito.anyString())).thenReturn(leagueResponse);

		ResultDTO result = rankingService.getRank("England", "Championship", "Liverpool");

		assertEquals(result.getErrorMessage(), "League not found");
	}
	
	@Test
	public void TestRankingMethod_RankingsNotFound() {

		String countryResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}, {\r\n" + "	\"country_id\": \"46\",\r\n" + "	\"country_name\": \"France\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/46_france.png\"\r\n"
				+ "}]";

		String leagueResponse = "[{\r\n" + "	\"country_id\": \"41\",\r\n" + "	\"country_name\": \"England\",\r\n"
				+ "	\"league_id\": \"149\",\r\n" + "	\"league_name\": \"Championship\",\r\n"
				+ "	\"league_season\": \"2020\\/2021\",\r\n"
				+ "	\"league_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_leagues\\/149_championship.png\",\r\n"
				+ "	\"country_logo\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/logo_country\\/41_england.png\"\r\n"
				+ "}]";
		
		String rankingResponse = "[{\r\n" + "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2647\",\r\n"
				+ "	\"team_name\": \"Reading\",\r\n" + "	\"overall_promotion\": \"Promotion - Premier League\",\r\n"
				+ "	\"overall_league_position\": \"1\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"7\",\r\n" + "	\"overall_league_D\": \"1\",\r\n"
				+ "	\"overall_league_L\": \"0\",\r\n" + "	\"overall_league_GF\": \"15\",\r\n"
				+ "	\"overall_league_GA\": \"3\",\r\n" + "	\"overall_league_PTS\": \"22\",\r\n"
				+ "	\"home_league_position\": \"1\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"4\",\r\n"
				+ "	\"home_league_D\": \"0\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"7\",\r\n" + "	\"home_league_GA\": \"0\",\r\n"
				+ "	\"home_league_PTS\": \"12\",\r\n" + "	\"away_league_position\": \"2\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"3\",\r\n" + "	\"away_league_D\": \"1\",\r\n"
				+ "	\"away_league_L\": \"0\",\r\n" + "	\"away_league_GF\": \"8\",\r\n"
				+ "	\"away_league_GA\": \"3\",\r\n" + "	\"away_league_PTS\": \"10\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2647_reading.png\"\r\n" + "}, {\r\n"
				+ "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2615\",\r\n"
				+ "	\"team_name\": \"Bournemouth\",\r\n"
				+ "	\"overall_promotion\": \"Promotion - Premier League\",\r\n"
				+ "	\"overall_league_position\": \"2\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"4\",\r\n" + "	\"overall_league_D\": \"4\",\r\n"
				+ "	\"overall_league_L\": \"0\",\r\n" + "	\"overall_league_GF\": \"11\",\r\n"
				+ "	\"overall_league_GA\": \"6\",\r\n" + "	\"overall_league_PTS\": \"16\",\r\n"
				+ "	\"home_league_position\": \"3\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"3\",\r\n"
				+ "	\"home_league_D\": \"1\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"5\",\r\n" + "	\"home_league_GA\": \"2\",\r\n"
				+ "	\"home_league_PTS\": \"10\",\r\n" + "	\"away_league_position\": \"10\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"1\",\r\n" + "	\"away_league_D\": \"3\",\r\n"
				+ "	\"away_league_L\": \"0\",\r\n" + "	\"away_league_GF\": \"6\",\r\n"
				+ "	\"away_league_GA\": \"4\",\r\n" + "	\"away_league_PTS\": \"6\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2615_bournemouth.png\"\r\n"
				+ "}, {\r\n" + "	\"country_name\": \"England\",\r\n" + "	\"league_id\": \"149\",\r\n"
				+ "	\"league_name\": \"Championship\",\r\n" + "	\"team_id\": \"2638\",\r\n"
				+ "	\"team_name\": \"Millwall\",\r\n"
				+ "	\"overall_promotion\": \"Promotion - Championship (Play Offs)\",\r\n"
				+ "	\"overall_league_position\": \"3\",\r\n" + "	\"overall_league_payed\": \"8\",\r\n"
				+ "	\"overall_league_W\": \"4\",\r\n" + "	\"overall_league_D\": \"3\",\r\n"
				+ "	\"overall_league_L\": \"1\",\r\n" + "	\"overall_league_GF\": \"10\",\r\n"
				+ "	\"overall_league_GA\": \"5\",\r\n" + "	\"overall_league_PTS\": \"15\",\r\n"
				+ "	\"home_league_position\": \"11\",\r\n" + "	\"home_promotion\": \"\",\r\n"
				+ "	\"home_league_payed\": \"4\",\r\n" + "	\"home_league_W\": \"1\",\r\n"
				+ "	\"home_league_D\": \"3\",\r\n" + "	\"home_league_L\": \"0\",\r\n"
				+ "	\"home_league_GF\": \"4\",\r\n" + "	\"home_league_GA\": \"2\",\r\n"
				+ "	\"home_league_PTS\": \"6\",\r\n" + "	\"away_league_position\": \"3\",\r\n"
				+ "	\"away_promotion\": \"\",\r\n" + "	\"away_league_payed\": \"4\",\r\n"
				+ "	\"away_league_W\": \"3\",\r\n" + "	\"away_league_D\": \"0\",\r\n"
				+ "	\"away_league_L\": \"1\",\r\n" + "	\"away_league_GF\": \"6\",\r\n"
				+ "	\"away_league_GA\": \"3\",\r\n" + "	\"away_league_PTS\": \"9\",\r\n"
				+ "	\"league_round\": \"\",\r\n"
				+ "	\"team_badge\": \"https:\\/\\/apiv2.apifootball.com\\/badges\\/2638_millwall.png\"\r\n" + "}]";

		Mockito.when(footballService.getCountries(Mockito.anyString())).thenReturn(countryResponse);
		
		Mockito.when(footballService.getLeagues(Mockito.anyString(), Mockito.anyString())).thenReturn(leagueResponse);
		
		Mockito.when(footballService.getRankings(Mockito.anyString())).thenReturn(rankingResponse);

		ResultDTO result = rankingService.getRank("England", "Championship", "Liverpool");

		assertEquals(result.getErrorMessage(), "Rank not found");
	}
	
	
}

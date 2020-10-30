package com.sap.micro.sapMicro.service;

import com.sap.micro.sapMicro.model.ResultDTO;

public interface RankService {
	
	ResultDTO getRank(String countryName, String leagueName, String teamName);
}

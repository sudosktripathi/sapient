package com.sap.micro.sapMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com")
@EnableAutoConfiguration
public class SapMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapMicroApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestClient() {
		return new RestTemplate();
	}
}

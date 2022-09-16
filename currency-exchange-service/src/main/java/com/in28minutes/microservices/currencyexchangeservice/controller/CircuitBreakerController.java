package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")  // con el retry entra trato de entrar 3 veces
	//@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse")
	public String sampleApi() {
		 logger.info("entro a sampleApi");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
		
		return response.getBody();
	}
	
	public String hardCodedResponse(Exception ex) {
		return "fallback-response";
	}


}

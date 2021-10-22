package com.microservices.currencyexchangeservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
	//@CircuitBreaker(name="default", fallbackMethod = "hardCodedResponse")
	@RateLimiter(name="default")
	public String sampleApi() {
		log.info("@@@@JK");
		//ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return "sampleAPI";
	}
	
	public String hardCodedResponse(Exception e)
	{
		return "fallback method called";
	}

}

package com.circuitbreaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@org.springframework.stereotype.Service
public class Service {

	
		
		@Autowired
		private RestTemplate restTemplate;
		
		@Autowired
		private CircuitBreakerFactory circuitBreakerFactory;
		
		
		@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name= "Employees", fallbackMethod = "fallbackNameService")
		public String callNameService() {
			
			CircuitBreaker cb = circuitBreakerFactory.create("nameservicebreaker");
			
			
			return cb.run(() -> restTemplate.getForObject("http://localhost:8081/api/name", String.class), throwable -> fallbackNameService());

		}
		
		public String fallbackNameService() {
			return "NA";
		}
	
	
}

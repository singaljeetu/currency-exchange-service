package com.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment; 
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange CurrencyValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}

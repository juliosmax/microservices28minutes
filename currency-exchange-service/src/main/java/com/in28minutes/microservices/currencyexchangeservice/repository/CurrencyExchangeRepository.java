package com.in28minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	CurrencyExchange findByFromAndTo(String from, String to);// cuando esta de esta forma , springboot provee el cuerpo de la implementacion, es decir
	//que springboot ya sabe los parametros y nombres de las columnas por los nombres que le has dado a la firma del metodo
}

package com.in28minutes.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange") // with commenting the previous line and not having the specific url, we are saying to eureka
// that he has to do load balancing between all the instances with the specified name , in this case 'currency-exchange'
public interface CurrencyExchangeProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	

}

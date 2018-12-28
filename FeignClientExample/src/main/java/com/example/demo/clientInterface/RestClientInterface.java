package com.example.demo.clientInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("CRYPTO")
public interface RestClientInterface {
	
	@RequestMapping("/target")
	String callrest();

}

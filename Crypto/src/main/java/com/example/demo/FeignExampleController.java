package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignExampleController {
	
	@RequestMapping(value="/target")
	public String callRest(){
		return "Feign CLient response";
	}

}

package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clientInterface.RestClientInterface;

@RestController
public class FeignController {
	
	@Autowired
	RestClientInterface clientInterface;
	
	@RequestMapping(value="/v1/feign/checkrest", method= RequestMethod.GET)
	public String getResult(){
		return clientInterface.callrest();
	}

}

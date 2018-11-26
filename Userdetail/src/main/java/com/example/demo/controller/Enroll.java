package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Enroll {
	
	@RequestMapping(value="/v1/enroll", method=RequestMethod.POST)
	public String enrollUser(){
		return "success";
		
	}

}

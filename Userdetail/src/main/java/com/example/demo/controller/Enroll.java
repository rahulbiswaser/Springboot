package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request.EnrollParam;
import com.example.demo.model.Response.EnrollResponse;

@RestController
public class Enroll {
	
	@RequestMapping(value="/v1/enroll", method=RequestMethod.POST)
	public EnrollResponse enrollUser(@Valid @RequestBody EnrollParam enrollparam){
		EnrollResponse enrollresp=new EnrollResponse();
		enrollresp.setResult("Success");
		return enrollresp;
		
	}

}

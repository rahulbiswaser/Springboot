package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request.EnrollParam;
import com.example.demo.model.Request.LoginParam;
import com.example.demo.model.Response.EnrollResponse;
import com.example.demo.model.Response.LoginResponse;
import com.example.demo.model.Response.UserRecord;
import com.example.demo.service.UserdetailService;

@RestController
public class Enroll {
	
	@Autowired
	private UserdetailService userservice;
	
	@RequestMapping(value="/v1/enroll", method=RequestMethod.POST)
	public EnrollResponse enrollUser(@Valid @RequestBody EnrollParam enrollparam) throws Exception{
		EnrollResponse enrollresp=userservice.enroll(enrollparam);		
		return enrollresp;		
	}
	
	@RequestMapping(value="/v1/enroll", method=RequestMethod.GET)
	public UserRecord enrolledUser() throws Exception{				
		return userservice.enrolledUser();	
	}
	
	@RequestMapping(value="/v1/login", method=RequestMethod.POST)
	public LoginResponse login(@Valid @RequestBody LoginParam loginparam) throws Exception{		
		return userservice.login(loginparam);	
	}

}

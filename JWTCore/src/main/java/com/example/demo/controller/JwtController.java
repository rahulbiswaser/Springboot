package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JWTRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class JwtController {
	
	@Autowired
	JwtUtil jwtutil;
	
	@RequestMapping(value="/v1/rest/getJwtToken", method=RequestMethod.POST)
	public String generateToken(@RequestBody JWTRequest request){		
		return jwtutil.getJwtToken(request);
	}

}

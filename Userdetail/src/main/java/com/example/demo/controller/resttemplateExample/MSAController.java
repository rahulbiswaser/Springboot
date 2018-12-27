package com.example.demo.controller.resttemplateExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Request.Request;
import com.example.demo.model.Response.Response;

@RestController
public class MSAController {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/v1/rest/template",method=RequestMethod.GET)
	public String checkrest(){
		HttpHeaders headers= new HttpHeaders();
		headers.add("csi", "170784");
		String uri="http://CRYPTO/v1/rest/template/dest";
		Request request=new Request();
		request.setStatus("Incoming");
		
		HttpEntity<Request> entity = new HttpEntity<Request>(request,headers);
		ResponseEntity<Response> response= null;
		response= restTemplate.exchange(uri, HttpMethod.POST, entity, Response.class);
		
		return response.toString();
	}

}

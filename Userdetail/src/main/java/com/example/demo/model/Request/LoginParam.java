package com.example.demo.model.Request;


import javax.validation.constraints.NotBlank;


public class LoginParam {
	
	@NotBlank( message = "{invalid.request}")
	private String customerId;
	@NotBlank( message = "{invalid.request}")
	private String password;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

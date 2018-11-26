package com.example.demo.model.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class EnrollParam {
	
	@NotBlank( message = "{invalid.request}")
	private String customerId;
	@NotBlank( message = "{invalid.request}")
	private String password;
	@NotBlank( message = "{invalid.request}")
	@Email (message = "{inavlid.email}")
	private String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

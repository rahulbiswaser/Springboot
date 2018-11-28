package com.example.demo.model.Response;

import java.util.ArrayList;

public class UserRecord {
	
	private ArrayList userrecorddetails;
	
	



public ArrayList getUserrecorddetails() {
		return userrecorddetails;
	}





	public void setUserrecorddetails(ArrayList userrecorddetails) {
		this.userrecorddetails = userrecorddetails;
	}





public static class record{
	private String customerId;
	private String email;
	private String password;
	private String enrolldate;
	private String uniqueId;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(String enrolldate) {
		this.enrolldate = enrolldate;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	}

}

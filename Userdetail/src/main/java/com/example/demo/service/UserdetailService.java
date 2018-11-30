package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Request.EnrollParam;
import com.example.demo.model.Request.LoginParam;
import com.example.demo.model.Response.EnrollResponse;
import com.example.demo.model.Response.LoginResponse;
import com.example.demo.model.Response.UserRecord;
import com.example.demo.util.CryptoUtil;
import com.example.demo.util.DButil;

@Component
public class UserdetailService {
	@Autowired
	private CryptoUtil cryptoutil;
	@Autowired
	private DButil dbutil;
	
	public EnrollResponse enroll(EnrollParam enrollparam) throws Exception{
		EnrollResponse resp= new EnrollResponse();
		String encryptedpassword= cryptoutil.encrypt(enrollparam.getPassword());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("customerId", enrollparam.getCustomerId());
		map.put("password", encryptedpassword);
		map.put("email", enrollparam.getEmail());
		map.put("ID", enrollparam.getCustomerId()+Math.random());
		map.put("Enrolled DateTime", dateFormat.format(date));
		resp.setResult(dbutil.insertUser("usercred", map));		
		return resp;		
	}
	
	public UserRecord enrolledUser() throws Exception{			
		return dbutil.fetchRecord("usercred");			
	}
	
	public LoginResponse login(LoginParam loginparam) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		LoginResponse resp = new LoginResponse();
		String decryptedpassword =cryptoutil.decrypt((String)dbutil.fetchbyQuery("usercred", loginparam).get("password"));
		if(loginparam.getCustomerId().equalsIgnoreCase((String)dbutil.fetchbyQuery("usercred", loginparam).get("customerId"))
				&& loginparam.getPassword().equalsIgnoreCase(decryptedpassword)){
			
			resp.setResult("Login succss at" + dateFormat.format(date));
			resp.setSessionId(Math.random());// will implement jhcache or Gemfire
		}
		return resp;
	}

}

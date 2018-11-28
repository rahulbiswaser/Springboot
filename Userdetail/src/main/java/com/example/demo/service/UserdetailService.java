package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Request.EnrollParam;
import com.example.demo.model.Response.EnrollResponse;
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
		HashMap map= new HashMap();
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

}

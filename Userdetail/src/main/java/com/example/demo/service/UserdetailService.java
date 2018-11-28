package com.example.demo.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Request.EnrollParam;
import com.example.demo.model.Response.EnrollResponse;
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
		HashMap map= new HashMap();
		map.put("customerId", enrollparam.getCustomerId());
		map.put("password", encryptedpassword);
		map.put("email", enrollparam.getEmail());			
		resp.setResult(dbutil.insertUser("usercred", map));		
		return resp;	
		
	}

}

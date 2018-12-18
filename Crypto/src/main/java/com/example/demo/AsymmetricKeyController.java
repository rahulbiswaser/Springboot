package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EncryptParam;
import com.example.demo.model.EncryptResponse;
import com.example.demo.utility.RSAExample;


@RestController
public class AsymmetricKeyController {
	
	@Autowired
	RSAExample rsaexample;
	
	@RequestMapping(value="/v1/asym/encrypt", method=RequestMethod.POST)
	public EncryptResponse encryptparam(@RequestBody EncryptParam param) throws Exception{
		EncryptResponse encrypt= new EncryptResponse();
		encrypt.setResult((rsaexample.encryptPlainwithAESandEncryptSecretKey(param.getParam())).get("encryptedText").toString());		
		return encrypt;		
	}
	
	@RequestMapping(value= "/v1/asym/decrypt", method= RequestMethod.POST)
	public EncryptResponse decryptparam(@RequestBody EncryptParam param) throws Exception{
		EncryptResponse encrypt= new EncryptResponse();
		encrypt.setResult(rsaexample.decrypt(param.getParam()));		
		return encrypt;		
	}

}

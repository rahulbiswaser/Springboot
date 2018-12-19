package com.example.demo.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.DecryptRSARequest;

/*
 * Asymmetric Key Operation Example 
 * Public and Private key example
 */
@Component
public class RSAExample {
	
	@Autowired
	AESExample aesexample;
	
	private static final String algo="RSA";
	private Key key;
	private PrivateKey privatekey;
	private PublicKey publickey;
	
	public HashMap<String, Object> getkeypair(){
		HashMap<String, Object> keypair= new HashMap<String,Object>();
		try{
		InputStream is= new FileInputStream("C:/Users/Friends/keys/apprsakey");
		KeyStore keystore= KeyStore.getInstance(KeyStore.getDefaultType());
		System.out.println(keystore.getProvider());
		keystore.load(is,"test123".toCharArray()); 
		String alias ="apprsakey";
		key= keystore.getKey(alias,"test123".toCharArray());
		 if (key instanceof PrivateKey) {
	          // Get certificate of public key
	          Certificate cert = keystore.getCertificate(alias);
	          // Get public key
	          publickey = cert.getPublicKey();
	          keypair.put("publickey", publickey);
	          System.out.println(publickey);

	        }
		 privatekey= (PrivateKey)key;
		 System.out.println(privatekey);
		 keypair.put("privatekey", privatekey);
		}catch(Exception e){
			System.out.println(e);
		}
		return keypair;
	}
	
	public HashMap<String, Object> encryptPlainwithAESandEncryptSecretKey(String data) throws Exception{
		HashMap<String, Object> output= new HashMap<String,Object>();
		HashMap<String, Object> keypair= new HashMap<String,Object>();
		output.put("encryptedText", aesexample.encrypt(data));
		keypair=getkeypair();		
		String encrptedsecretkey= (String)aesexample.encryptSecretKey(keypair.get("privatekey"));
		System.out.println("encrptedsecretkey::::" + encrptedsecretkey);		
		output.put("encryptedSecret", encrptedsecretkey);
		output.put("publickey", keypair.get("publickey"));
		return output;
	}
	
	public String decryptWithPublic(DecryptRSARequest data) throws Exception{
		String output= "";		
		HashMap<String, Object> keypair= new HashMap<String,Object>();
		keypair=getkeypair();		
		output= (String)aesexample.decryptSecretKey(keypair.get("publickey"),data.getEncryptedSecret());
		String result= aesexample.decrypt(data.getEncryptedString(),output);
		System.out.println("output::::" + output);
		return result;
	}

}

package com.example.demo.utility;



import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.stereotype.Component;

/*
 * Symmetric Key Operation Example 
 */
@Component
public class AESExample {
	private static final String algo="AES";
	private Key key;
	
	public Key getkey(){
		try{
		InputStream is= new FileInputStream("C:/Users/Friends/keys/appkey");
		KeyStore keystore= KeyStore.getInstance("jceks");
		System.out.println(keystore.getProvider());
		keystore.load(is,"test123".toCharArray()); 
		String alias ="appkey";
		key= keystore.getKey(alias,"test123".toCharArray());
		System.out.println(key);
		}catch(Exception e){
			System.out.println(e);
		}
		return key;
	}
   
	public String encrypt(String data) throws Exception{		
		Cipher c=Cipher.getInstance(algo);
		c.init(Cipher.ENCRYPT_MODE, getkey());
		byte[] encryptedbyte= c.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedbyte);		
		
	}
	
	public String decrypt(String encryptedString)throws Exception{
		Cipher c= Cipher.getInstance(algo);
		c.init(Cipher.DECRYPT_MODE, getkey());
		byte[] withouttbase64= Base64.getDecoder().decode(encryptedString);
		byte[] decryptedString= c.doFinal(withouttbase64);
		return new String (decryptedString);
	}
}

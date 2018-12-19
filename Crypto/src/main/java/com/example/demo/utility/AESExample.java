package com.example.demo.utility;



import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.CryptoConfig;

/*
 * Symmetric Key Operation Example 
 */
@Component
public class AESExample {
	private static final String algo="AES";
	private static final String algoAsym="RSA";
	private Key key;
	private byte[] encryptedbyte;
	
	@Autowired
	CryptoConfig crypconfig;
	
	public Key getkey(){
		try{
		InputStream is= new FileInputStream(this.crypconfig.getSecretstorePath());
		KeyStore keystore= KeyStore.getInstance("jceks");
		System.out.println(keystore.getProvider());
		keystore.load(is,this.crypconfig.getSecretstorePass().toCharArray()); 
		String alias =this.crypconfig.getAlias();
		key= keystore.getKey(alias,this.crypconfig.getSecretstorePass().toCharArray());
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
	
	public String decrypt(String encryptedString, String secretkey)throws Exception{
		byte[] decodekey = Base64.getDecoder().decode(secretkey);
		SecretKey originalKey= new SecretKeySpec(decodekey,0,decodekey.length,algo);
		Cipher c= Cipher.getInstance(algo);
		c.init(Cipher.DECRYPT_MODE, originalKey);
		byte[] withouttbase64= Base64.getDecoder().decode(encryptedString);
		byte[] decryptedString= c.doFinal(withouttbase64);
		return new String (decryptedString);
	}
	
	public Object encryptSecretKey(Object data) throws Exception{		
		Cipher c=Cipher.getInstance(algoAsym);
		c.init(Cipher.ENCRYPT_MODE, (PrivateKey)data);
		encryptedbyte= c.doFinal(getkey().getEncoded());
		return Base64.getEncoder().encodeToString(encryptedbyte);		
		
	}
	
	public Object decryptSecretKey(Object publickey,String encryptedSecret) throws Exception{		
		Cipher c=Cipher.getInstance(algoAsym);
		c.init(Cipher.DECRYPT_MODE, (PublicKey)publickey);
		byte[] withouttbase64= Base64.getDecoder().decode(encryptedSecret);
		byte[] decryptedbyte= c.doFinal(withouttbase64);
		return Base64.getEncoder().encodeToString(decryptedbyte);	
		
	}
}

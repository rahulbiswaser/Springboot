package com.example.demo.util;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class CryptoUtil {
	private static final String algo= "AES";
	private String keyValue= "I88**%^$I88**%^$";
	
	public String encrypt(String Data) throws Exception{
		Key key= generateKey();
		Cipher c= Cipher.getInstance(algo);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedbyte= c.doFinal(Data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedbyte);		
	}
	
	public String decrypt(String Data) throws Exception{
		Key key=generateKey();
		Cipher c= Cipher.getInstance(algo);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] withoutBase64= Base64.getDecoder().decode(Data);
		byte[] decryptedbyte= c.doFinal(withoutBase64);
		return new String(decryptedbyte);
	}
	
	private Key generateKey() throws Exception{
		Key key= new SecretKeySpec(keyValue.getBytes(), algo);
		return key;
	}

}

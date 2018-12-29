package com.example.demo.util;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;
import com.example.demo.model.JWTRequest;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;


@Component
public class JwtUtil {
	
	public String getJwtToken(JWTRequest request){
		
		// Creating the Header part
		JWSHeader header =new JWSHeader.Builder(JWSAlgorithm.HS256).build();
		
		// Creating the payload
		String issuer= "Rahul";
		String subject= "first token";
		String jwtid= java.util.UUID.randomUUID().toString();
		//Date issuetime= new Date(new Date().getTime()/1000*1000);
		//long tokenexpiration= 600;
		
		JWTClaimsSet claimset = new JWTClaimsSet.Builder().subject(subject).issuer(issuer).jwtID(jwtid).
				claim("name", request.getName()).claim("id", request.getId()).build();
		
		SignedJWT signedjwt= new SignedJWT(header,claimset);
		String serializedJwt="";
		
		//Get AESKey
		
		byte[] sharedKey = new byte[32];
		new SecureRandom().nextBytes(sharedKey);
		try{
		JWSSigner signer= new MACSigner(sharedKey);
		signedjwt.sign(signer);
		serializedJwt=signedjwt.serialize();
		}catch(Exception e){
			
		}
		
				
		
		return serializedJwt;
	}
	
	
}

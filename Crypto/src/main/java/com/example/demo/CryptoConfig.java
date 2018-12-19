package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="crypto.config")
public class CryptoConfig {
	
	private String secretstorePath;
	private String secretstorePass;
	private String alias;
	private String rsastorePath;
	private String rsastorePass;
	private String rsaalias;
	public String getSecretstorePath() {
		return secretstorePath;
	}
	public void setSecretstorePath(String secretstorePath) {
		this.secretstorePath = secretstorePath;
	}
	public String getSecretstorePass() {
		return secretstorePass;
	}
	public void setSecretstorePass(String secretstorePass) {
		this.secretstorePass = secretstorePass;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getRsastorePath() {
		return rsastorePath;
	}
	public void setRsastorePath(String rsastorePath) {
		this.rsastorePath = rsastorePath;
	}
	public String getRsastorePass() {
		return rsastorePass;
	}
	public void setRsastorePass(String rsastorePass) {
		this.rsastorePass = rsastorePass;
	}
	public String getRsaalias() {
		return rsaalias;
	}
	public void setRsaalias(String rsaalias) {
		this.rsaalias = rsaalias;
	}
	
	
	

}

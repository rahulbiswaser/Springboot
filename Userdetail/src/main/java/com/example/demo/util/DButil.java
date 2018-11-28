package com.example.demo.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Response.UserRecord;
import com.example.demo.model.Response.UserRecord.record;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;



@Component
public class DButil {	
	
	@SuppressWarnings("deprecation")
	private DB mongodbconnection(){
		MongoClient client= new MongoClient("localhost", 27017);
		DB db=client.getDB("myUser");
		System.out.println("Successfully Connected");
		return db;		
	}
	
	public String insertUser(String tablename,HashMap user){
		String flag="false";
		DB db1 = mongodbconnection();		
		DBCollection dbc= db1.getCollection(tablename);		
		WriteResult wr=dbc.insert(new BasicDBObject(user));
		if(wr.wasAcknowledged()){			
			flag = "true";						
		}
		return flag;		
	}
	
	public UserRecord fetchRecord(String tablename){	
		UserRecord resp= new UserRecord();
		DB db1 = mongodbconnection();		
		DBCollection dbc= db1.getCollection(tablename);
		DBCursor dbo= dbc.find();
		ArrayList newList= new ArrayList();
		while(dbo.hasNext()){
			record rc= new record();
			DBObject obj=dbo.next();
			rc.setCustomerId((String)obj.get("customerId"));
			rc.setPassword((String)obj.get("customerId"));
			rc.setEmail((String)obj.get("email"));
			rc.setUniqueId((String)obj.get("ID"));
			rc.setEnrolldate((String)obj.get("Enrolled DateTime"));			
			newList.add(rc);			
		}	
		 resp.setUserrecorddetails(newList);
		 return resp;
	}
	
	public void updateRecord(String tablename){
		
	}
	
    public void deleteRecord(String tablename){
		
	}

}

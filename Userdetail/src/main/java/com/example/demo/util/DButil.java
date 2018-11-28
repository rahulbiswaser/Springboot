package com.example.demo.util;

import java.util.HashMap;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


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
		DBCursor result;
		if(null != dbc.insert(new BasicDBObject(user))){
			result=dbc.find();
			flag = "Data Inserted Successfully";
			System.out.println("result:" + result);				
		}
		return flag;
		
	}
	
	/*public String fetchRecord(String tablename,HashMap user){
		String flag="false";
		DB db1 = mongodbconnection();		
		DBCollection dbc= db1.getCollection(tablename);
		DBCursor result;
		if(null != dbc.insert(new BasicDBObject(user))){
			result=dbc.find();
			flag = "Data Inserted Successfully";
			System.out.println("result:" + result);				
		}
		return flag;
		
	}*/

}

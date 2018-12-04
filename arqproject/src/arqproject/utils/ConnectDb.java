package arqproject.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class ConnectDb {
	


	@SuppressWarnings({ "resource", "unused" })
	public MongoDatabase getCon() {
		// Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	     
	      // Creating Credentials 
	      MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDb",  "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDb"); 
	      
		return database;
	}

}


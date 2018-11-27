package arqproject.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class ConnectDb {
	
//	public String conect(Integer op, String list, String tabela){
//		  
//		
//		MongoDatabase database = getCon();
//	      
//	      for (String name : database.listCollectionNames()) { 
//	          System.out.println("tableName: " + name); 
//	       } 
//	      
//	      // Creating a collection 
//	      System.out.println("Collection created successfully"); 
//
//	      // Retieving a collection
//	      MongoCollection<Document> collection = database.getCollection(tabela); 
//	      System.out.println("Collection myCollection selected successfully"); 
//	      String result = null;
//	      
//	      switch (op) {
//			case 1:
//				result = doInsert(list, collection);
//				break;
//			case 2:
//				result = doSelect(list, collection);
//				break;
//				
//			case 10:
//				result = deleteTable(collection);
//				break;
//			default:
//				break;
//		  }
//
//
//	    return result;      
//	    	
//	}

	@SuppressWarnings({ "resource", "unused" })
	public MongoDatabase getCon() {
		// Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	     
	      // Creating Credentials 
	      MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDb", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDb"); 
	      
		return database;
	}

//	private String doSelect(String list, MongoCollection<Document> collection) {
//		 String result = null;
//		 FindIterable<Document> iterDoc = collection.find();
//		    String [] d = list.split(";");
//		    for (Document iterable_element : iterDoc) {
//		    	if(iterable_element.containsValue(d[0]) && iterable_element.containsValue(d[1])){
//		    		   result = iterable_element.toJson(); 
//		    	}
//		    }
//		
//		    System.out.println(result);
//		return result;
//
//	}
//
//	private String doInsert(String list, MongoCollection<Document> collection) {
//		String msg = null;
//	      @SuppressWarnings("static-access")
//		Document document = new Document("title", "MongoDB") 
//	    .parse(list);
//	    collection.insertOne(document); 
//	    
//	    FindIterable<Document> iterDoc = collection.find();
//	    
//	    for (Document iterable_element : iterDoc) {
//	    	 if(iterable_element.toJson().equals(document.toJson())){
//	    		 // Creating a collection 
//	   	      	System.out.println("Collection created successfully");
//	   	      	msg = "Collection created successfully"; 
//	    	 }
//	    }
//	          
//		
//		return msg;
//		// TODO Auto-generated method stub
//		
//	}
	
//	private String deleteTable(MongoCollection<Document> collection){
//		String msg = null;
//		
//		System.out.println("ola");
//		
//		System.out.println(collection.getNamespace().getCollectionName());
//	     
//	     collection.drop();
//	     
//	     Boolean drop = (getCon().listCollectionNames().equals(collection.getNamespace().getCollectionName()));
//	     
//	     if(!drop){
//	    	 msg = "sucesso";
//	     }else{
//	    	 msg = "erro";
//	     }
//	     
//		return msg;
//	}
}


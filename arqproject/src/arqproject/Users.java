package arqproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.bson.Document;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import arqproject.obj.UsersObj;
import arqproject.utils.ConnectDb;

public class Users {


	public String doRegisto(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner (System.in);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Nome:");
		String nome = keyboard.nextLine();
		System.out.println("Email:");
		String email = keyboard.nextLine(); 
		
		String finalResult = null;
		
		if(email.contains("@")){
			System.out.println("Password:");
			String pass = keyboard.nextLine(); 
			
			String dados =  "{'nome':'"+nome+"', 'email':'"+email+"', 'pass':'"+pass+"'}";
			
			ConnectDb con = new ConnectDb();
			MongoCollection<Document> table = con.getCon().getCollection("users");
			FindIterable<Document> iterDoc = table.find();
			
			@SuppressWarnings("static-access")
			Document document = new Document() 
				    .parse(dados);
				    table.insertOne(document); 
			
		    for (Document iterable_element : iterDoc) {
		    	 if(iterable_element.toJson().equals(document.toJson())){
		   	      	finalResult = "Collection created successfully"; 
		    	 }
		    }
			
		}else{
			finalResult = ("Erro : O email está incorreto....");
		}
		
		return finalResult;
	}

	@SuppressWarnings({ "resource", "static-access" })
	public void profile(UsersObj user) {
	
		ConnectDb con = new ConnectDb();
		MongoCollection<Document> table = con.getCon().getCollection("users"); 
		FindIterable<Document> iterDoc = table.find();

		 
		System.out.println("-------------------------------------");
		System.out.println("------------ User -------------");
		System.out.println("-------------------------------------");
	
		for (Document iterable_element : iterDoc) {
			 if(iterable_element.get("_id").toString().equals(user.getId())){
				
			    System.out.println("Nome: " + iterable_element.get("nome"));
				System.out.println("Email: " + iterable_element.get("email"));
				System.out.println("-------------------------------------"); 
				new Menus().menuProfile();
				
				Scanner scanner = new Scanner(System.in);
			    int choice = scanner.nextInt();
			    
				switch (choice) {
				case 1:
					Scanner keyboard = new Scanner (System.in);
					System.out.println();
					System.out.println("---------------------------------------");
					System.out.println("Nome:");
					String nome = keyboard.nextLine();
					System.out.println("Email:");
					String email = keyboard.nextLine(); 
					
								
					Document document = new Document();
					
					if(!nome.equals("")){
						document.append("nome", nome);
					}
					
					if(!email.equals("")){
						document.append("email", email);
					}
					
					table.updateOne(iterable_element, new Document("$set", document));
					
					
					System.out.println("Update sucesso");
					
					new Home().entradaHome(user);
					
					break;
				case 2:
					
					table.deleteOne(iterable_element);
					System.out.println(table.find().iterator().equals(iterable_element));
					if(!table.find().iterator().equals(iterable_element)){
						System.out.println("Delete sucesso");
						
						new StartMenu().run();
					}
					
					
					
					break;
				case 3:
					System.out.flush();
		    		new Home().entradaHome(user);
					break;

				default:
					break;
				}
			 }
		}


		
		
		
	}


}

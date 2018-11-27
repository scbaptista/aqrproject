package arqproject;

import java.util.Scanner;
import org.bson.Document;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import arqproject.obj.UsersObj;
import arqproject.utils.ConnectDb;

public class Login {

	@SuppressWarnings("resource")
	public UsersObj doLogin() throws Exception{
	
		Scanner keyboard = new Scanner (System.in);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("email:");
		String email = keyboard.nextLine();
		System.out.println("Pass:");
		String pass = keyboard.nextLine(); 

		 ConnectDb con = new ConnectDb();
		 MongoCollection<Document> table = con.getCon().getCollection("users"); 
		 FindIterable<Document> iterDoc = table.find();
		 
		 UsersObj user = new UsersObj();
		 
		 for (Document iterable_element : iterDoc) {
			 if(iterable_element.containsValue(email) && iterable_element.containsValue(pass)){
				 user.setId(iterable_element.get("_id").toString());
				 user.setNome(iterable_element.get("nome").toString());
					
			 }
		 }
		
		
		return user;
		
	}


}

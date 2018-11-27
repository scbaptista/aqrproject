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

public class Games {

	@SuppressWarnings("resource")
	public void getListGames(UsersObj user) { 
		try {
			
			ConnectDb con = new ConnectDb();
			MongoCollection<Document> table = con.getCon().getCollection("games"); 
			FindIterable<Document> iterDoc = table.find();
			
			System.out.println("-------------------------------------");
			System.out.println("------------ List Games -------------");
			System.out.println("-------------------------------------");
			for (Document iterable_element : iterDoc) {
				JsonElement jelement = new JsonParser().parse(iterable_element.toJson());
			    JsonObject jobject = jelement.getAsJsonObject();
			    System.out.println("Game Code: " + jobject.get("codeaposta").getAsString());
				System.out.println("Game: " + jobject.get("descricao").getAsString());
				String [] apostas = jobject.get("apostas").getAsString().replace("[", "").replace("]", "").split(",");
				System.out.println("Apostas:");
				int cont = 1;
				for (String d : apostas) {
					System.out.println(cont + " - " + d);
					cont++;
				}
				System.out.println("-------------------------------------");

			 }
			
			new Menus().menuApostar(user.getNome());
			
			Scanner scanner = new Scanner(System.in);
		    int choice = scanner.nextInt();

		    switch (choice) {
		    	case 1:
		    		break;
		    	case 2:
		    		System.out.flush();
		    		new Home().entradaHome(user);
		    		break;
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//	public void newGames() {
//		String s =  "{'descricao':'Benfica-Gil Vivente', 'apostas':'[1.38,4.40,8.00]', 'codeaposta':'ap2'}";
//		
//		ConnectDb con = new ConnectDb();
//		con.conect(1, s, "games");
//	}

}

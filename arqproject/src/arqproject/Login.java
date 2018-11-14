package arqproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Login {

	@SuppressWarnings("resource")
	public String doLogin() throws Exception{
		
		String f = "files/users.txt";
		
		Scanner keyboard = new Scanner (System.in);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("email:");
		String user = keyboard.nextLine();
		System.out.println("Pass:");
		String pass = keyboard.nextLine(); 

		 Scanner sc = new Scanner(new File(f)); 
		 
		 String finalResult = null;
		 while (sc.hasNextLine()){ 
			 String line = sc.nextLine();
			JsonElement jelement = new JsonParser().parse(line);
		    JsonObject jobject = jelement.getAsJsonObject();

		    if(user.equals(jobject.get("nome").getAsString()) && pass.equals(jobject.get("pass").getAsString())){
		    	finalResult = line;
		    }
		  
		 } 

		return finalResult;
		
	}


}

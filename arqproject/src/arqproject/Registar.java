package arqproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Registar {


	public String doRegisto(){
		Path p = Paths.get("users.txt");
		return run(p);
	}

	@SuppressWarnings("resource")
	private String run(Path p) {
		
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
			
			String s = System.lineSeparator() + "{'nome':'"+nome+"', 'email':'"+email+"', 'pass':'"+pass+"'}";
			
			try {
			    if(Files.write(p, s.getBytes(), StandardOpenOption.APPEND) != null){
			    	finalResult = s;
			    	System.out.println("finalResult: "+finalResult);
			    }
			    
			} catch (IOException e) {
			    System.err.println("erro: "+e);
			}
		}else{
			System.out.println("o email está incorreto....");
			new Registar().run(p);
		}
		
		return finalResult;
	}
}

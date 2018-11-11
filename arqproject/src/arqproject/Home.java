package arqproject;

import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Home {
	@SuppressWarnings("resource")
	public void entradaHome(String user){
		JsonElement jelement = new JsonParser().parse(user);
	    JsonObject jobject = jelement.getAsJsonObject();
	    
		new Menus().menuPrincipal(jobject.get("nome").getAsString());
		
		Scanner scanner = new Scanner(System.in);
	    int choice = scanner.nextInt();

	    switch (choice) {
	        case 1:
	        	
				try {
					listApostas(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	            break;
	        case 2:
	        	try {
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
	        case 3:
	        	System.out.print("Saiu do programa...");
	            System.exit(0);
	            
	            break;
	        default:
	            // The user input an unexpected choice.
	    }
	}

	@SuppressWarnings("resource")
	private void listApostas(String user) {
		
		new ListaApostas().getListApostas();
	}
}

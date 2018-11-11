package arqproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		run(); 
		
	}

	@SuppressWarnings({ "resource", "static-access" })
	private static void run() {
		Menus menu = new Menus();
	    menu.menuEntrada();

	    Scanner scanner = new Scanner(System.in);
	    int choice = scanner.nextInt();

	    switch (choice) {
	        case 1:
	        	
				try {
					String result = new Login().doLogin();
					if(result != null){
						new Home().entradaHome(result);
					}else{
						System.out.println("Não foi possivel realizar o login!!!");
					
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	            break;
	        case 2:
	        	try {
					String result = new Registar().doRegisto();
					if(result != null){
						System.out.println("O seu registo foi feito com sucesso");
						new Main().run();
					}else{
						System.out.println("Não foi possivel realizar o registo!!!");
					
					}
					
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


}

package arqproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import arqproject.obj.UsersObj;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		new ConnectDb().conect(1,"equipa","equipa");
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
					UsersObj result = new Login().doLogin();
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
					String result = new Users().doRegisto();
					if(result != null && result.contains("Erro")){
						result = new Users().doRegisto();
					}if(result != null){
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
	            
	        case 4:
//	        	String result = new ConnectDb().conect(10, "", "equipa");
//	            System.out.println(result);
	            break;
	        default:
	            // The user input an unexpected choice.
	    }
		
	}


}

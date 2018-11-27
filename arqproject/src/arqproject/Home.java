package arqproject;

import java.util.Scanner;

import arqproject.obj.UsersObj;

public class Home {
	@SuppressWarnings("resource")
	public void entradaHome(UsersObj user){
	    
		new Menus().menuPrincipal(user.getNome());
//		System.out.println("id user: "+ jobject.get("_id"));
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
					new Users().profile(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
	        case 3:
	        	try {
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
	        case 4:
	        	new StartMenu().run();	            
	            break;
	        case 5:
	        	System.out.print("Saiu do programa...");
	            System.exit(0);
	            
	            break;
	        default:
	            // The user input an unexpected choice.
	    }
	}

	private void listApostas(UsersObj user) {
		
		new Games().getListGames(user);
		
//		new Games().newGames();
	}
}

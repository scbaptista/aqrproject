package arqproject;

public class Menus {
	
	public void menuEntrada(){
		  System.out.println("Escolha uma opção");
		  System.out.println("-------------------------\n");
	      System.out.println("1 - Login");
	      System.out.println("2 - Registar");
	      System.out.println("3 - Sair");
	      System.out.println("-------------------------\n");
	}
	
	public void menuPrincipal(String user){
		  System.out.println("Bem vindo, "+user);
	      System.out.println("-------------------------\n");
	      System.out.println("1 - Ver lista de apostas");
	      System.out.println("2 - Historico");
	      System.out.println("3 - Sair");
	      System.out.println("-------------------------\n");
	}

	public void menuApostar(String user){
		  System.out.println("");
	      System.out.println("-------------------------\n");
	      System.out.println("1 - Efectuar aposta");
	      System.out.println("2 - Voltar");
	      System.out.println("-------------------------\n");
	}
	
	public void menuHistorico(String user){
		  System.out.println("");
	      System.out.println("-------------------------\n");
	      System.out.println("1 - Voltar");
	      System.out.println("-------------------------\n");
	}
}

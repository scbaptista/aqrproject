package arqproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaApostas {

	@SuppressWarnings("resource")
	public void getListApostas() {
		
		System.out.println("ola");
		try {
			String f = "apostas.txt";
			Scanner sc = new Scanner(new File(f));
			while (sc.hasNextLine()){ 
				 String line = sc.nextLine();
				 System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

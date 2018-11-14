package arqproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ListaApostas {

	public void getListApostas() {

		try {
			String f = "files/apostas.txt";

			FileReader fr = new FileReader(f);
			
			 int i; 
			    try {
					while ((i=fr.read()) != -1) 
					  System.out.print((char) i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

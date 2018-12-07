/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.AegisBet;
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class MainUI {
    public static void main(String[] args) {
        System.out.println("<=======================================>");
        System.out.println("<===============AegisBET================>");
        boolean stop = false;
        while(!stop) {
            Scanner s = new Scanner(System.in);
            System.out.println("<=======================================>");
            System.out.println("1 - Login  |  2 - Register  |  3 - Leave ");
            System.out.print("Option: ");
            String i = s.next();
            AegisBet aBet = new AegisBet();
            String email;
            String password;
            String name;
            switch (i) {
                case "1":
                    System.out.println("<=======================================>");
                    System.out.println("Email: ");
                    email = s.next();
                    System.out.println("Password: ");
                    password = s.next();
                    if(aBet.login(email, password) == 1) {
                        HomeUI l = new HomeUI(aBet);
                        l.run();
                        stop = true;
                    } else
                        System.out.println("Email or Password Incorrect");
                    break;
                case "2":
                    System.out.println("<=======================================>");
                    System.out.print("Email: ");
                    email = s.next();
                    System.out.print("Password: ");
                    password = s.next();
                    System.out.print("Name: ");
                    name = s.next();
                    if(aBet.register(email, password, name) == 1)
                        System.out.println("Success Register");
                    else
                        System.out.println("Email already in use");
                    break;
                case "3":
                    System.out.println("<=============SEE YOU NEXT TIME===============>");
                    stop = true;
                    break;
                default:
                    System.out.println("Input Error - Try Again");
                    break;
            }
        }
    }
}

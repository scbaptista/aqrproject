/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.AegisBet;
import business.Game;
import business.User;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author alexandre
 */
public class HomeUI {
    private AegisBet aBet;
    
    public HomeUI(AegisBet a) {
        this.aBet = a;
    }
    
    public void run () {
        Scanner s = new Scanner(System.in);
        boolean stop=false;
        while(!stop) {
            System.out.println("<==============Home================>");
            System.out.println("1 - Get Available Games  \n2 - Make a Bet   \n3 - Profile \n4 - Leave");
            System.out.print("Option: ");
            String i = s.next();
            switch(i) {
                case "1":
                    Set<Game> games = this.aBet.getAvailableGames();
                    for(Game g : games) {
                        int id = g.getId();
                        String house = g.getHouseTeam();
                        String guest = g.getGuestTeam();
                        float oddH = g.getOddVictory();
                        float oddDw = g.getOddDraw();
                        float oddDf = g.getOddDefeat();
                        String date = g.getDate();
                        String time = g.getTimeBegin();
                        System.out.println("ID: "+id + " <==> " + house + " - "+ guest + " {"+oddH+","+oddDw+","+oddDf+"} " + date + " " + time);
                    }
                    break;
                case "2":
                    System.out.println("<===============Bet================>");
                    System.out.print("Bet ID: ");
                    int idB = Integer.parseInt(s.next());
                    System.out.print("Amount: ");
                    float ammount = Float.parseFloat(s.next());
                    System.out.print("ODDS (House Team => 1, Draw => 2, Guest Team => 3): ");
                    int odd = Integer.parseInt(s.next());
                    if(this.aBet.makeBet(idB, ammount, odd) == 1) 
                        System.out.println("Sucess");
                    else System.out.println("Already Clossed");
                    break;
                case "3":
                    System.out.println("<===============Profile================>");
                    User u = this.aBet.getUser();
                    System.out.println("Email: "+ u.getEmail());
                    System.out.println("Name: "+ u.getName());
                    System.out.println("Password: "+ u.getPassword());
                    System.out.println("EssCoins: "+ u.getEssCoins());
                    System.out.println("1 - Buy Coins  \n2 - Edit Profile\n3 - Back");
                    String j = s.next();
                    boolean stop2 = false;
                        switch(j) {
                            case "1":
                                System.out.println("<===============Buy Coins================>");
                                System.out.print("Amount: ");
                                if(this.aBet.updateCoins(s.nextFloat())==1)
                                    System.out.println("Success");
                                else System.out.println("Erro");
                                break;
                            case "2":
                                System.out.println("<===============Edit================>");
                                System.out.print("Name: ");
                                String name = s.next();
                                System.out.print("Password: ");
                                String pass = s.next();
                                if(this.aBet.updateUser(u.getEmail(), pass, name)==1)
                                    System.out.println("Success");
                                else System.out.println("Erro");
                                break;
                            case "3":
                                stop2 = true;
                                break;
                            default:
                                System.out.println("Error on Input");
                                break;
                        }
                    
                    break;
                case "4":
                    stop = true;
                    break;
                default:
                    System.out.println("Error on Input");
                    break;
            }
        }

    }
    
}

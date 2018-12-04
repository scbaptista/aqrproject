/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Bet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alexandre
 */
public class BetDAO {
    private Connection con;
    
    public int addBet(int idUser, int idGame, float amount, int type) {
        int bet = 0;
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM Bet WHERE idUser = "+idUser+" AND idGame = "+idGame+";");
            if(!result.next()) {
                ResultSet res = stm.executeQuery("SELECT * FROM Game WHERE id = "+idGame+";");
                boolean status = res.getBoolean("status");
                if(status) {
                    stm.executeUpdate("INSERT INTO Bet (idUser,idGame,amount,type,notified) VALUES ("+idUser+","+idGame+","+amount+","+type+",0);");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        return bet;
    }

    public Set<Bet> getToNotify(int id) {
        Set<Bet> bets = new HashSet<>();
        
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT Bet.* FROM Bet INNER JOIN Game AS Game.id = Bet.idGame WHERE Bet.notified = 0 AND Bet.idUser = "+id+" AND Game.ended = 1;");
            while(!result.next()) {
                int idUser = result.getInt("idUser");
                int idGame = result.getInt("idGame");
                float amount = result.getFloat("amount");
                int type = result.getInt("type");
                boolean notified = result.getBoolean("notified");
                
                Bet b = new Bet(idUser,idGame,amount,type);
                b.setNotified(notified);
                
                bets.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        return bets;
    }
    
    public void notify(int idUser, int idGame) {
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("UPDATE Bet SET notified = 1 WHERE idUser = "+idUser+" AND idGame = "+idGame+";");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
    }
    
}

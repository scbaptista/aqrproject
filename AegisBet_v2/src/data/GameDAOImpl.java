/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Game;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public class GameDAOImpl implements GameDAO {
    private Connection con;
    
    public Set<Game> getAvailableGames() {
        Set<Game> games = new HashSet<>();
        
        try{
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet results = stm.executeQuery("SELECT * FROM Game WHERE status = 1;");
            while(results.next()) {
                int id = results.getInt("id");
                String hTeam = results.getString("houseTeam");
                String gTeam = results.getString("guestTeam");
                float oddV = results.getInt("oddVictory");
                float oddDr = results.getInt("oddDraw");
                float oddDf = results.getInt("oddDefeat");
                String date = results.getString("date");
                String tBegin = results.getString("status");
                int goalsHT = results.getInt("goalsHT");
                int goalsGT = results.getInt("goalsGT");
                boolean ended = results.getBoolean("ended");
                
                Game g = new Game(id,hTeam,gTeam,oddV,oddDr,oddDf,date,tBegin,true,goalsHT,goalsGT,ended);
                games.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            ConnectDB.close(con);
        }
        
        return games;
    }
    
    public Vector<Vector> history(int idUser) {
        Vector<Vector> hist = new Vector<>();
        
        try{
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet results = stm.executeQuery("SELECT Game.*,Bet.amount,Bet.type FROM Game INNER JOIN Bet ON Bet.idGame=Game.id WHERE Bet.idUser = "+idUser+" AND Bet.notified = 1;");
            while(results.next()) {
                Vector<String> line = new Vector<>();
                line.addElement("" + results.getInt("id"));
                line.addElement(results.getString("houseTeam"));
                line.addElement(results.getString("guestTeam"));
                line.addElement("" + results.getFloat("oddVictory"));
                line.addElement("" + results.getFloat("oddDraw"));
                line.addElement("" + results.getFloat("oddDefeat"));
                line.addElement(results.getString("date"));
                line.addElement(results.getString("timeBegin"));
                line.addElement("" + results.getInt("goalsHT"));
                line.addElement("" + results.getInt("goalsGT"));
                line.addElement("" + results.getFloat("amount"));
                line.addElement("" + results.getInt("type"));
                
                
                hist.addElement(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            ConnectDB.close(con);
        }
        
        return hist;
    }

    public Game getGame(int idGame) {
        Game g = null;
        
        try{
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM Game WHERE id = "+idGame+";");
            if(result.next()) {
                int id = result.getInt("id");
                String hTeam = result.getString("houseTeam");
                String gTeam = result.getString("guestTeam");
                float oddV = result.getInt("oddVictory");
                float oddDr = result.getInt("oddDraw");
                float oddDf = result.getInt("oddDefeat");
                String date = result.getString("date");
                String tBegin = result.getString("timeBegin");
                boolean status = result.getBoolean("status");
                int goalsHT = result.getInt("goalsHT");
                int goalsGT = result.getInt("goalsGT");
                boolean ended = result.getBoolean("ended");
                
                g = new Game(id,hTeam,gTeam,oddV,oddDr,oddDf,date,tBegin,status,goalsHT,goalsGT,ended);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            ConnectDB.close(con);
        }
        
        return g;
    }

    public Vector<Vector> openBets(int id) {
        Vector<Vector> bets = new Vector<>();
        
        try{
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet results = stm.executeQuery("SELECT Game.*,Bet.amount,Bet.type FROM Game INNER JOIN Bet ON Bet.idGame=Game.id WHERE Bet.idUser = "+id+" AND Game.status = 1;");
            while(results.next()) {
                Vector<String> line = new Vector<>();
                line.addElement("" + results.getInt("id"));
                line.addElement(results.getString("houseTeam"));
                line.addElement(results.getString("guestTeam"));
                line.addElement("" + results.getFloat("oddVictory"));
                line.addElement("" + results.getFloat("oddDraw"));
                line.addElement("" + results.getFloat("oddDefeat"));
                line.addElement(results.getString("date"));
                line.addElement(results.getString("timeBegin"));
                line.addElement("" + results.getInt("goalsHT"));
                line.addElement("" + results.getInt("goalsGT"));
                line.addElement("" + results.getFloat("amount"));
                line.addElement("" + results.getInt("type"));
                
                
                bets.addElement(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            ConnectDB.close(con);
        }
        
        return bets;
    }
}

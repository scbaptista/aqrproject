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

/**
 *
 * @author alexandre
 */
public class GameDAO {
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
    
    public Set<Game> history(int idUser) {
        Set<Game> games = new HashSet<>();
        
        try{
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet results = stm.executeQuery("SELECT Game.* FROM Game INNER JOIN Bet AS Bet.idGame=Game.id WHERE Bet.idUser = "+idUser+";");
            while(results.next()) {
                int id = results.getInt("id");
                String hTeam = results.getString("houseTeam");
                String gTeam = results.getString("guestTeam");
                float oddV = results.getInt("oddVictory");
                float oddDr = results.getInt("oddDraw");
                float oddDf = results.getInt("oddDefeat");
                String date = results.getString("date");
                String tBegin = results.getString("timeBegin");
                boolean status = results.getBoolean("status");
                int goalsHT = results.getInt("goalsHT");
                int goalsGT = results.getInt("goalsGT");
                boolean ended = results.getBoolean("ended");
                
                Game g = new Game(id,hTeam,gTeam,oddV,oddDr,oddDf,date,tBegin,status,goalsHT,goalsGT,ended);
                games.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            ConnectDB.close(con);
        }
        
        return games;
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
}

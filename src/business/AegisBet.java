/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.BetDAO;
import data.GameDAO;
import data.UserDAO;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author alexandre
 */
public class AegisBet {
    private User user;
    private UserDAO uDAO;
    private GameDAO gDAO;
    private BetDAO bDAO;
    private Thread t;
    
    public AegisBet() {
        this.user = null;
        this.uDAO = new UserDAO();
        this.gDAO = new GameDAO();
        this.bDAO = new BetDAO();
        
        this.t = new Thread("updateThread") {
            public void run() {
                while(true) {
                    Set<Bet> bets = bDAO.getToNotify(user.getId());
                    
                    for(Bet b: bets) {
                        float value = 0;
                        
                        Game g = gDAO.getGame(b.getIdGame());
                        
                        if(b.getType() == 0 && g.getGoalsHT()>g.getGoalsGT())
                            value = b.getAmount() * g.getOddVictory();
                        else if(b.getType() == 1 && g.getGoalsHT()==g.getGoalsGT())
                            value = b.getAmount() * g.getOddDraw();
                        else value = b.getAmount() * g.getOddDefeat();
                        
                        uDAO.updateCoins(value, user.getId());
                        user.updateCoins(value);
                        bDAO.notify(b.getIdUser(),b.getIdGame());
                        
                        try{
                            Thread.sleep(10000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }
    
    public User getUser() {
        return this.user;
    }
    
    public int login(String email, String password) {
        this.user = this.uDAO.login(email, password);
        if(this.user == null) return 0;
        this.t.start();
        return 1;
    }
    
    public int register(String email, String password, String name) {
        User aux = this.uDAO.register(email, password, name);
        if(aux == null) return 0;
        return 1;
    }
    
    public int updateUser(String email, String password, String name) {
        if(this.user != null) {
            User aux = this.uDAO.update(this.user.getId(), email, password, name);
            if(aux != null) {
                this.user = aux;
                return 1;
            }
        }
        return 0;
    }
    
    public int updateCoins (float value) {
        if(this.uDAO.updateCoins(value, this.user.getId()) == 1){
            this.user.setEssCoins(this.user.getEssCoins()+value);
            return 1;
        }
        return 0;
    }
    
    public Set<Game> getAvailableGames() {
        return this.gDAO.getAvailableGames();
    }
    
    public Set<Game> history() {
        return this.gDAO.history(this.user.getId());
    }
    
    public int makeBet(int idGame, float amount, int type) {
        if(this.user.getEssCoins()-amount>=0) {
            if(this.bDAO.makeBet(this.user.getId(), idGame, amount, type)==1) {
                return updateCoins(-amount);
            }
        }
        return 0;
    }
    
}

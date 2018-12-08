/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.*;
import java.util.Set;
import java.util.Vector;
import presentation.Home;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public class AegisBet {
    private User user;
    private UserDAO uDAO;
    private GameDAO gDAO;
    private BetDAO bDAO;
    
    public AegisBet() {
        this.user = null;
        this.uDAO = new UserDAOImpl();
        this.gDAO = new GameDAOImpl();
        this.bDAO = new BetDAOImpl();
    }
    
    public User getUser() {
        return this.user;
    }
    
    public int login(String email, String password, Home u) {
        this.user = this.uDAO.login(email, password);
        if(this.user == null) return 0;
        UpdateThread t = new UpdateThread(this,u);
        t.start();
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
    
    public Vector<Vector> history() {
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
    

    public Set<Bet> getToNotify() {
        return this.bDAO.getToNotify(user.getId());
    }

    public Game getGame(int idGame) {
       return this.gDAO.getGame(idGame);
    }

    public void notify(int idGame) {
        this.bDAO.notify(user.getId(),idGame);
    }

    public Vector<Vector> openBets() {
        return this.gDAO.openBets(this.user.getId());
    }
    
}

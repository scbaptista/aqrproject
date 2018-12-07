/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author alexandre
 */
public class Bet {
    private int idUser;
    private int idGame;
    private float amount;
    //0-Victory;1-Draw;2-Defeat (House Team)
    private int type;
    private boolean notified;

    public Bet(int idUser, int idGame, float amount, int type) {
        this.idUser = idUser;
        this.idGame = idGame;
        this.amount = amount;
        this.type = type;
        this.notified = false;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }
    
    
    
}

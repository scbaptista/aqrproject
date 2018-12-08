/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.UserObserver;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public class UpdateThread extends Thread {
    private AegisBet a;
    private UserObserver u;
    
    public UpdateThread(AegisBet a, UserObserver u) {
        this.a = a;
        this.u = u;
    }
    
    public void run() {
        while(true) {
            Set<Bet> bets = this.a.getToNotify();
            
            for(Bet b: bets) {    
                float value = 0;
                Game g = this.a.getGame(b.getIdGame());
                
                if(b.getType() == 1 && g.getGoalsHT()>g.getGoalsGT())
                    value = b.getAmount() * g.getOddVictory();
                else if(b.getType() == 2 && g.getGoalsHT()==g.getGoalsGT())
                    value = b.getAmount() * g.getOddDraw();
                else if(b.getType() == 3 && g.getGoalsHT()<g.getGoalsGT())
                    value = b.getAmount() * g.getOddDefeat();
                
                this.a.updateCoins(value);
                this.a.notify(b.getIdGame());
                this.u.update();
                
                try{
                    this.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

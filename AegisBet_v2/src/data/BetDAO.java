/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Bet;
import java.util.Set;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public interface BetDAO {
    public int makeBet(int idUser, int idGame, float amount, int type);
    public Set<Bet> getToNotify(int id);
    public void notify(int idUser, int idGame);
}

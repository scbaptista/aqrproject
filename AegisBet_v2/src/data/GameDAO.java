/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Bet;
import business.Game;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public interface GameDAO {
   public Set<Game> getAvailableGames();
   public Vector<Vector> history(int idUser);
   public Game getGame(int idGame);
   public Vector<Vector> openBets(int id);
}
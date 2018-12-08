/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.User;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public interface UserDAO {
    public User login(String email, String password);
    public User register (String email, String password, String name);
    public User update(int id, String email, String password, String name);
    public int updateCoins (float value, int id);
}

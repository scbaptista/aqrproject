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
public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private float essCoins;
    
    public User(){}
    
    public User(int id, String email, String password, String name, float essCoins) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.essCoins = essCoins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getEssCoins() {
        return essCoins;
    }

    public void setEssCoins(float essCoins) {
        this.essCoins = essCoins;
    }

    public void updateCoins(float value) {
        this.essCoins += value;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public class UserDAOImpl implements UserDAO {
    private Connection con;
    
    public User login(String email, String password) {
        User u = null;
        
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM User WHERE email = '"+email+"' AND password = '"+password+"';");
            if(result.next()) {
                u = new User(result.getInt("id"),result.getString("email"),result.getString("password"),result.getString("name"),result.getFloat("essCoins"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        
        return u;
    }

    public User register (String email, String password, String name) {
        User u = null;
        
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM User WHERE email = '"+email+"';");
            if(!result.next()) {
                stm.executeUpdate("INSERT INTO User (email,password,name,essCoins) VALUES ('"+email+"','"+password+"','"+name+"',"+0+");");
                ResultSet res = stm.executeQuery("SELECT * FROM User WHERE email = '"+email+"' AND password = '"+password+"';");
                if(res.next()) {
                    u = new User(res.getInt("id"),res.getString("email"),res.getString("password"),res.getString("name"),res.getFloat("essCoins"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        
        return u;
    }
    
    public User update(int id, String email, String password, String name) {
        User u = null;
        
        try {
            con = ConnectDB.connect();
            Statement stm = con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM User WHERE id = "+id+";");
            if(result.next()) {
                u = new User(result.getInt("id"),email,password,name,result.getFloat("essCoins"));
                stm.executeUpdate("UPDATE User SET email='"+email+"', password='"+password+"', name='"+name+"' WHERE id="+id+";");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        
        return u;
    }

    public int updateCoins (float value, int id) {
        int ret = 0;
        
        try {
            con = ConnectDB.connect();
            Statement stm =  con.createStatement();
            stm.executeQuery("USE aegisBet;");
            ResultSet result = stm.executeQuery("SELECT * FROM User WHERE id = "+id+";");
            
            if(result.next()) {
                float newVal = result.getFloat("essCoins") + value;
                stm.executeUpdate("UPDATE User SET essCoins = "+ newVal + " WHERE id ="+id+";");
                ret = 1;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.close(con);
        }
        
        return ret;
    }
    
}



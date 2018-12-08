/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexandre Teixeira
 * @author Sandra Batista
 */
public class ConnectDB {
    private static final String host = "localhost";
    private static final String database = "aegisBet";
    private static final String user = "root";
    private static final String pass = "root";
    
    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        
        return DriverManager.getConnection("jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+pass);
    }
    
    public static void close(Connection con) {
        try {
            if(con!=null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

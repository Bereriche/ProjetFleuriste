/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akram
 */
public class ConnectionSingleton {
    
    private  static ConnectionSingleton uniqueConnection = null ;
    private static Connection connect;

   private ConnectionSingleton(Connection connect) {
        this.connect = connect;
    }

    public static Connection getConnect() {
        return connect;
    }
   
    public synchronized static  Connection instance(){
        if(uniqueConnection==null){
                 try{
        Class.forName("oracle.jdbc.OracleDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
        connect = DriverManager.getConnection("jdbc:oracle:thin:@oracleadudb1.bdeb.qc.ca:1521:gdna10","ug200e02","akramov14");
            System.out.println("connected");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            uniqueConnection = new ConnectionSingleton(connect);
        }
        }
        return uniqueConnection.getConnect();
} 

    
    
   
    

}

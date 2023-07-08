/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nkhan
 */
public class DBconnector {

    private String hostName = "localhost";
    private String instance = "";

    private String dbName = "PRJDB";
    private String username = "niran";
    private String password = "niran@123456";
    private String portNumber = "1433";


    public Connection conn;

    public DBconnector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectorURL = "jdbc:sqlserver://" + hostName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty()){
             connectorURL = "jdbc:sqlserver://" + hostName + ":" + portNumber +";databaseName=" + dbName;
             }
            
            conn = DriverManager.getConnection(connectorURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
    try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
  

    
}


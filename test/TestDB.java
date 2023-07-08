

import dal.AdminDao;
import dal.DBconnector;
import dal.UserDao;
import model.User;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nkhan
 */
public class TestDB {
    public static void checkPass(){
         try {
        
             AdminDao admindao = new AdminDao();
        User user = admindao.CheckUserLogin("admin", "admin123");
        
        if (user == null) {
            String error = "Incorrect information entered, please try again.";
            System.out.println(error);
        } else {
            String message = "Welcome: " + user.FullName;
            System.out.println(message);
        }
    } catch (NumberFormatException e) {
        System.out.println(e);
    }
    }
     public static void main(String[] args) {
        DBconnector dbConnector = new DBconnector();
        checkPass();
        if (dbConnector.conn != null) {
            System.out.println("Database connection established successfully.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
        
        dbConnector.close();
    }
}

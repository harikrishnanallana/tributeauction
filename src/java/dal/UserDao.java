/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBconnect.DBconnector;
import model.User;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author nkhan
 */
public class UserDao extends DBconnector {

//     Admin Command Begin
    public ArrayList<User> getUsers() {
    ArrayList<User> list = new ArrayList<>();
    String query = "SELECT * FROM Users;";
    ResultSet rs = null; // Move the rs variable declaration outside the try block
    try {
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(query);
        while (rs.next()) {
            User user = new User(
                    rs.getInt("UserID"),
                    rs.getString("Username"),
                    rs.getString("FullName"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("Role")
            );
            list.add(user);
        }
    } catch (SQLException ex) {
        System.out.println("SQLException occurred: " + ex.getMessage());
        if (rs != null) {
            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                System.out.println("Column names in ResultSet:");
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    System.out.println(columnName);
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving column names: " + e.getMessage());
            }
        }
    }
    return list;
}


    public static void main(String[] args) {
        UserDao userdao = new UserDao();
        ArrayList<User> list = userdao.getUsers();
        System.out.println(list.get(0).toString());
    }
}

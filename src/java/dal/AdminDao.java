/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import DBconnect.DBconnector;
import java.sql.PreparedStatement;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
/**
 *
 * @author nkhan
 */
public class AdminDao extends DBconnector{
    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                User st = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("roles"),
                rs.getString("fullname"),
                rs.getBigDecimal("total_money")
                );
                list.add(st);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return list;
    }
    
    public User CheckUserLogin(String username, String password) {
    String query = "SELECT id,username,password,roles FROM users WHERE username = ? AND password = ?;";
    try {
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setString(1, username);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            User user = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("roles")
               );
            return user;
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return null;
}
    
    
    public static void main(String[] args){
        AdminDao userdao = new AdminDao();
        ArrayList<User> list = userdao.getUsers();        
        System.out.println(list.get(0).toString());
    }
}

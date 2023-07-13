package dal;

import DBconnect.DBconnector;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User.RoleType;

public class UserDao extends DBconnector {

    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("FullName"),
                        rs.getString("Password"),
                        RoleType.valueOf(rs.getString("Role").toUpperCase()),
                        rs.getString("Email")
                        
                );
                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return list;
    }

    public void saveUser(User user) {
        String query = "INSERT INTO Users (Username, FullName, Password, Email, Role) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getFullName());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.RoleDefault().toString().toLowerCase());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }
    
       public boolean checkUsernameExists(String username) {
        String query = "SELECT COUNT(*) FROM Users WHERE Username = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return false;
    }
       
       public boolean checkEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM Users WHERE Email = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return false;
    }
       
       
       public User UserLogin(String username, String password) {
    String query = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
    try {
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            User user = new User(
                    rs.getInt("UserID"),
                    rs.getString("Username"),
                    rs.getString("FullName"),
                    rs.getString("Password"),
                    RoleType.valueOf(rs.getString("Role").toUpperCase()),
                    rs.getString("Email")
            );
            return user;
        }
    } catch (SQLException ex) {
        System.out.println("SQLException occurred: " + ex.getMessage());
    }
    return null;
}


    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        ArrayList<User> list = userDao.getUsers();
        System.out.println(list.get(0).toString());
    }
}

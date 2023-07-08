/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import DBconnect.DBconnector;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
/**
 *
 * @author nkhan
 */
public class UserDao extends DBconnector{
    
//     Admin Command Begin
    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                
                User st = new User(rs.getInt("id"),
                        rs.getString("username")
                        ,rs.getString("pass")       
                        ,rs.getString("roles"),rs.getString("fullname")
                        ,rs.getBigDecimal("total_money"));
                
                list.add(st);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return list;
    }
//     Admin Command End
    
  
    
    
    public static void main(String[] args){
        UserDao userdao = new UserDao();
        ArrayList<User> list = userdao.getUsers();        
        System.out.println(list.get(0).toString());
    }
}

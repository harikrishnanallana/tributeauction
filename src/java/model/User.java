/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nkhan
 */
public class User {

    public int ID;
    public String Username;
    public String FullName;
    public String Password;
    public String Role;
    public String  Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String  Email) {
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public User(ResultSet rs) {
        try {
            this.ID = rs.getInt("UserID");
            this.Username = rs.getString("Username");
            this.FullName = rs.getString("FullName");
            this.Password = rs.getString("Password");
            this.Role = rs.getString("Role");
            this.Email = rs.getString("Email");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User(int ID, String Username, String FullName, String Password, String Role, String Email) {
        this.ID = ID;
        this.Username = Username;
        this.FullName = FullName;
        this.Password = Password;
        this.Role = Role;
        this.Email = Email;
    }
//    check login
    public User(int ID,String Username,String Password,String roles){
        this.ID=ID;
        this.Username=Username;
        this.Password=Password;
        this.Role=roles;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", Username=" + Username + ", FullName=" + FullName + ", Password=" + Password + ", Role=" + Role + ", Email=" + Email + '}';
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public User() {
    }

}

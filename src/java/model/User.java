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
    public BigDecimal total_money;

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public int getID() {
        return ID;
    }

    public User(ResultSet rs) {
        try {
            this.ID = rs.getInt("id");
            this.Username = rs.getString("username");
            this.FullName = rs.getString("fullname");
            this.Password = rs.getString("password");
            this.Role = rs.getString("roles");
            this.total_money = rs.getBigDecimal("total_money");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User(int ID, String Username, String FullName, String Password, String Role, BigDecimal total_money) {
        this.ID = ID;
        this.Username = Username;
        this.FullName = FullName;
        this.Password = Password;
        this.Role = Role;
        this.total_money = total_money;
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
        return "User{" + "ID=" + ID + ", Username=" + Username + ", FullName=" + FullName + ", Password=" + Password + ", Role=" + Role + ", total_money=" + total_money + '}';
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

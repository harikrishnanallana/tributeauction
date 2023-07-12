package model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    public int ID;
    public String Username;
    public String FullName;
    public String Password;
    public RoleType Role;
    public String Email;

    public enum RoleType {
        CLIENT,
        ADMIN
    }

    public User(ResultSet rs) {
        try {
            this.ID = rs.getInt("UserID");
            this.Username = rs.getString("Username");
            this.FullName = rs.getString("FullName");
            this.Password = rs.getString("Password");
            this.Role = RoleType.valueOf(rs.getString("Role").toUpperCase());
            this.Email = rs.getString("Email");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User(int ID, String Username, String FullName, String Password, RoleType Role, String Email) {
        this.ID = ID;
        this.Username = Username;
        this.FullName = FullName;
        this.Password = Password;
        this.Role = Role;
        this.Email = Email;
    }

    public User(int ID, String Username, String Password, RoleType Role) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
    }

    public User() {
        this.Role = RoleType.CLIENT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public RoleType getRole() {
        return Role;
    }

    public void setRole(RoleType Role) {
        this.Role = Role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String RoleDefault() {
        return RoleType.CLIENT.toString().toLowerCase();
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Password='" + Password + '\'' +
                ", Role=" + Role +
                ", Email='" + Email + '\'' +
                '}';
    }
}

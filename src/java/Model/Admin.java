/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Admin extends DBContext {
    String username, pass, level, uid;

    public Admin() {
        connectDB();
    }

    public Admin(String username, String pass) {
        this.username = username;
        this.pass = pass;
        connectDB();
    }
       

    public Admin(String username, String pass, String level) {
        connectDB();
        this.username = username;
        this.pass = pass;
        this.level = level;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
     //Khai bao cac thanh phan xu ly DB
    Connection cnn;//Ket noi DB
    PreparedStatement stm;//Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    
    //connect to DB
    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail!");
        }
    }
    
    //check login
    public boolean checkLogin() {
        try {
            String strSQL = "select * from Admin where Username = ? and Password=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, username);
            stm.setString(2, pass);
            rs = stm.executeQuery();
            while (rs.next()) {
                level = String.valueOf(rs.getInt(3));
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkLogin" + e.getMessage());
        }
        return false;
    }
    
    //return admin list
    public ArrayList<Admin> getAdminList() {
        ArrayList<Admin> data = new ArrayList<Admin>();          
        try {
            String strSQL = "select * from Admin";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {                
                String username = rs.getString(1);
                String pass = rs.getString(2);
                String level = String.valueOf(rs.getInt(3));
                Admin a = new Admin(username, pass, level);
                data.add(a);                
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:" + e.getMessage());
        }
        return data;
    }
    
    //delete
    public void delete(String Username) {
        try {
            String strSQL = "delete from Admin where Username = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, Username);
            stm.execute();   
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
    }
    
    //add
    public boolean add() {
        try{
            String strSQL="insert into Admin\n" +
                          "VALUES (?,?,?)";
            stm=cnn.prepareStatement(strSQL);
            stm.setString(1, username);
            stm.setString(2, pass);
            stm.setInt(3, Integer.parseInt(level));
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("update:"+e.getMessage());
        }
        return false;
    }
    
    //search by id
    public void getAdminByName(String name) {
       try {
            String strSQL = "select * from Admin where Username = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                username = rs.getString(1);
                pass = rs.getString(2);
                level = String.valueOf(rs.getInt(3));        
            }
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
    }
    
    //update
    public boolean update() {
        try{
            String strSQL="update Admin \n" +
                          "set Username=?, Password=?, Admin=?\n" +
                          "Where Username=?";
            stm=cnn.prepareStatement(strSQL);
            stm.setString(1, username);
            stm.setString(1, pass);
            stm.setInt(3, Integer.parseInt(level));
            stm.setString(4, username);          
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("update:"+e.getMessage());
        }
        return false;
    }
}

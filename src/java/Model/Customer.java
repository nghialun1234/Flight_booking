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
public class Customer extends DBContext{
    String ID, lastName, firstName, phone, email;

    public Customer() {
        connectDB();
    }

    public Customer(String ID, String lastName, String firstName, String phone, String email) {
        connectDB();
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    //return Customer list
    public ArrayList<Customer> getCustomerList() {
        ArrayList<Customer> data = new ArrayList<Customer>();          
        try {
            String strSQL = "select * from Customer";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {                                
                String ID = String.valueOf(rs.getInt(1));
                String LastName = rs.getString(2);
                String FirstName = rs.getString(3);
                String Phone = rs.getString(4);
                String Email = rs.getString(5);
                Customer c = new Customer(ID, LastName, FirstName, Phone, Email);
                data.add(c);                
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:" + e.getMessage());
        }
        return data;
    }
    
    //delete
    public void delete(String cID) {
        try {
            String strSQL = "delete from Customer where CustomerID = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, Integer.parseInt(cID));
            stm.execute();   
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
    }
    
    //add
    public boolean add() {
        try{
            String strSQL="insert into Customer\n" +
                          "VALUES (?,?,?,?,?)";
            stm=cnn.prepareStatement(strSQL);
            stm.setInt(1, Integer.parseInt(ID));
            stm.setString(2, lastName);
            stm.setString(3, firstName);
            stm.setString(4, phone);
            stm.setString(5, email);
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("update:"+e.getMessage());
        }
        return false;
    }
    
    //search by id
    public void getCustomerByID(String cID) {
       try {
            String strSQL = "select * from Customer where CustomerID = "+cID;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                ID = String.valueOf(rs.getInt(1));
                lastName = rs.getString(2);
                firstName = rs.getString(3);
                phone = rs.getString(4);
                email = rs.getString(5);                     
            }
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
    }
}


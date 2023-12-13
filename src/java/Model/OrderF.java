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
public class OrderF extends DBContext{
    String OID, FID, name, number, CLASS;

    public OrderF() {
        connectDB();
    }

    public OrderF(String OID, String FID, String name, String number, String CLASS) {
        this.OID = OID;
        this.FID = FID;
        this.name = name;
        this.number = number;
        this.CLASS = CLASS;
        connectDB();
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }

    

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getFID() {
        return FID;
    }

    public void setFID(String FID) {
        this.FID = FID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    
    //return Order list
    public ArrayList<OrderF> getOrderList() {
        ArrayList<OrderF> data = new ArrayList<>();          
        try {
            String strSQL = "select * from OrderF";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {                                
                String FID = String.valueOf(rs.getInt(2));
                String OID = rs.getString(1);
                String Name = rs.getString(3);
                String Phone = rs.getString(4);
                String Class = rs.getString(5);
                OrderF o = new OrderF(OID, FID, Name, Phone, Class);
                data.add(o);                
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:" + e.getMessage());
        }
        return data;
    }
    
    //delete
//    public void delete(String cID) {
//        try {
//            String strSQL = "delete from Customer where CustomerID = ?";
//            stm = cnn.prepareStatement(strSQL);
//            stm.setInt(1, Integer.parseInt(cID));
//            stm.execute();   
//        } catch (Exception e) {
//            System.out.println("getProductByID:" + e.getMessage());
//        }
//    }
    
    //add
    public boolean add() {
        try{
            String strSQL="insert into OrderF\n" +
                          "VALUES (?,?,?,?,?)";
            stm=cnn.prepareStatement(strSQL);
            stm.setInt(2, Integer.parseInt(FID));
            stm.setString(1, OID);
            stm.setString(3, name);
            stm.setString(4, number);
            stm.setString(5, CLASS);
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("update:"+e.getMessage());
        }
        return false;
    }
    
    //search by id
    public void getOrderByID(String ID) {
       try {
            String strSQL = "select * from OrderF where OrderID =?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ID);
            rs = stm.executeQuery();
            while (rs.next()) {
                FID = String.valueOf(rs.getInt(2));
                OID = rs.getString(1);
                name = rs.getString(3);
                number = rs.getString(4);
                CLASS = rs.getString(5);
            }
        } catch (Exception e) {
            System.out.println("getOrderByID:" + e.getMessage());
        }
    }
    
    //return Order list
    public ArrayList<OrderF> getOrderByNumber(String Number) {
        ArrayList<OrderF> data = new ArrayList<>();          
        try {
            String strSQL = "select * from OrderF where Number = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, Number);
            rs = stm.executeQuery();
            while (rs.next()) {                                
                String FID = String.valueOf(rs.getInt(2));
                String OID = rs.getString(1);
                String Name = rs.getString(3);
                String Phone = rs.getString(4);
                String Class = rs.getString(5);
                OrderF o = new OrderF(OID, FID, Name, Phone, Class);
                data.add(o);                
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:" + e.getMessage());
        }
        return data;
    } 
    
}

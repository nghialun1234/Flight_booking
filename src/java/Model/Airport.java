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
public class Airport extends DBContext{
    String ID, airport, city, country;

    public Airport() {
//        connectDB();
    }

    public Airport(String ID, String airport, String city, String country) {
        this.ID = ID;
        this.airport = airport;
        this.city = city;
        this.country = country;
//        connectDB();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
//     //Khai bao cac thanh phan xu ly DB
//    Connection cnn;//Ket noi DB
//    PreparedStatement stm;//Thuc hien cac cau lenh sql
//    ResultSet rs;//Luu tru va xu ly du lieu
//    
//    //connect to DB
//    private void connectDB() {
//        cnn = connection;
//        if (cnn != null) {
//            System.out.println("Connect success");
//        } else {
//            System.out.println("Connect fail!");
//        }
//    }
//    
//    //return airport list
//    public ArrayList<Airport> getAirportList() {
//        ArrayList<Airport> data = new ArrayList<Airport>();          
//        try {
//            String strSQL = "select * from Airport";
//            stm = cnn.prepareStatement(strSQL);
//            rs = stm.executeQuery();
//            while (rs.next()) {                
//                String ID = rs.getString(1);
//                String Airport = rs.getString(2);
//                String City = rs.getString(3);
//                String Country = rs.getString(4);
//                Airport a = new Airport(ID, Airport, City, Country);
//                data.add(a);                
//            }
//        } catch (Exception e) {
//            System.out.println("getNameByAccount:" + e.getMessage());
//        }
//        return data;
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Airport;
import Model.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DBControl {
     //Khai bao cac thanh phan xu ly DB
    public void DBconnect(){
        DBContext db = new DBContext();
        cnn = db.getConnection();
    }
    Connection cnn;//Ket noi DB
    PreparedStatement stm;//Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu

    public DBControl(){
    }
    //return airport list
    public ArrayList<Airport> getAirportList() {
        DBconnect();
        ArrayList<Airport> data = new ArrayList<>();          
        try {
            String strSQL = "select * from Airport";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {                
                String ID = rs.getString(1);
                String Airport = rs.getString(2);
                String City = rs.getString(3);
                String Country = rs.getString(4);
                Airport a = new Airport(ID, Airport, City, Country);
                data.add(a);                
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:" + e.getMessage());
        }
        return data;
    }
    
    //search flight by departure/arrival and date
    public ArrayList<Flight> searchFlight(String DEPA, String ARRI,String DATE) {
        ArrayList<Flight> data = new ArrayList<>();
        DBconnect();
        try {
            String strSQL = "select * from Flight where Departure = ?"
                    + " and DeparturePlace=? and ArrivalPlace=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setDate(1, java.sql.Date.valueOf(DATE));
            stm.setString(2, DEPA);
            stm.setString(3, ARRI);
            rs = stm.executeQuery();            
            while (rs.next()) {
                String ID= String.valueOf(rs.getInt(1));
                String airline = rs.getString(2);
                String departure = String.valueOf(rs.getDate(3));
                String departureTime = String.valueOf(rs.getTime(4));
                String departurePlace = rs.getString(5);
                String arrival = String.valueOf(rs.getDate(6));
                String arrivalTime = String.valueOf(rs.getTime(7));
                String arrivalPlace = rs.getString(8);
                String economy = String.valueOf(rs.getInt(9));
                String business = String.valueOf(rs.getInt(10));
                String cost = String.valueOf(rs.getFloat(11)); 
                Flight f = new Flight(ID, airline, departure, departureTime,
                        departurePlace, arrival, arrivalTime, arrivalPlace,
                        economy, business, cost);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("checkLogin" + e.getMessage());
        }
        return data;
    } 
    
    //search flight by ID
    public Flight getFlightByID(String fID) {
        DBconnect();
        Flight f = new Flight();
        try {
            String strSQL = "select * from Flight where FlightID = "+fID;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID= String.valueOf(rs.getInt(1));
                String airline = rs.getString(2);
                String departure = String.valueOf(rs.getDate(3));
                String departureTime = String.valueOf(rs.getTime(4));
                String departurePlace = rs.getString(5);
                String arrival = String.valueOf(rs.getDate(6));
                String arrivalTime = String.valueOf(rs.getTime(7));
                String arrivalPlace = rs.getString(8);
                String economy = String.valueOf(rs.getInt(9));
                String business = String.valueOf(rs.getInt(10));
                String cost = String.valueOf(rs.getFloat(11));  
                f = new Flight(ID, airline, departure, departureTime,
                        departurePlace, arrival, arrivalTime, arrivalPlace,
                        economy, business, cost);                
            }
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
        return f;
    }
}

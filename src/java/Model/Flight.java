/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Flight extends DBContext{
    String ID, airline, departure, departureTime, departurePlace,
            arrival, arrivalTime, arrivalPlace,
            economy, business, cost;

    public Flight() {
//        connectDB();
    }

    public Flight(String ID, String airline, String departure, String departureTime, String departurePlace, String arrival, String arrivalTime, String arrivalPlace, String economy, String business, String cost) {
        this.ID = ID;
        this.airline = airline;
        this.departure = departure;
        this.departureTime = departureTime;
        this.departurePlace = departurePlace;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.arrivalPlace = arrivalPlace;
        this.economy = economy;
        this.business = business;
        this.cost = cost;
//        connectDB();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
//    
//    //Khai bao cac thanh phan xu ly DB
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
//    //return Flight list
//    public ArrayList<Flight> getFlightList() {
//        ArrayList<Flight> data = new ArrayList<Flight>();          
//        try {
//            String strSQL = "select * from Flight";
//            stm = cnn.prepareStatement(strSQL);
//            rs = stm.executeQuery();
//            while (rs.next()) {                                
//                String ID = String.valueOf(rs.getInt(1));
//                String Airline = rs.getString(2);
//                String Departure = String.valueOf(rs.getDate(3));
//                String DepartureTime = String.valueOf(rs.getTime(4));
//                String DeparturePlace = rs.getString(5);
//                String Arrival = String.valueOf(rs.getDate(6));
//                String ArrivalTime = String.valueOf(rs.getTime(7));
//                String ArrivalPlace = rs.getString(8);
//                String Economy = String.valueOf(rs.getInt(9));
//                String Business = String.valueOf(rs.getInt(10));
//                String Cost = String.valueOf(rs.getFloat(11));
//                Flight f = new Flight(ID, Airline, Departure, DepartureTime, DeparturePlace, Arrival, ArrivalTime, ArrivalPlace, Economy, Business, Cost);
//                data.add(f);                
//            }
//        } catch (Exception e) {
//            System.out.println("getNameByAccount:" + e.getMessage());
//        }
//        return data;
//    }
//    
//    //delete
//    public void delete(String fID) {
//        try {
//            String strSQL = "delete from Flight where FlightID = ?";
//            stm = cnn.prepareStatement(strSQL);
//            stm.setInt(1, Integer.parseInt(fID));
//            stm.execute();   
//        } catch (Exception e) {
//            System.out.println("getProductByID:" + e.getMessage());
//        }
//    }
//    
//    //add
//    public boolean add() {
//        try{
//            String strSQL="insert into Flight (Airline,Departure,DepartureTime,"
//                    + "DeparturePlace,Arrival,ArrivalTime,ArrivalPlace,Economy,Business,Cost)\n" +
//                          "VALUES (?,?,?,?,?,?,?,?,?,?)";
//            stm=cnn.prepareStatement(strSQL);
//            
//            stm.setString(1, airline);
//            stm.setString(2, departure);
//            stm.setString(3, departureTime);
//            stm.setString(4, departurePlace);
//            stm.setString(5, arrival);
//            stm.setString(6, arrivalTime);
//            stm.setString(7, arrivalPlace);
//            stm.setString(8, economy);
//            stm.setString(9, business);
//            stm.setString(10, cost);
//            stm.execute();
//            return true;
//        }catch (Exception e){
//            System.out.println("add:"+e.getMessage());
//        }
//        return false;
//    }
//    
//    //search by id
//    public void getFlightByID(String fID) {
//       try {
//            String strSQL = "select * from Flight where FlightID = "+fID;
//            stm = cnn.prepareStatement(strSQL);
//            rs = stm.executeQuery();
//            while (rs.next()) {
//                ID = String.valueOf(rs.getInt(1));
//                airline = rs.getString(2);
//                departure = String.valueOf(rs.getDate(3));
//                departureTime = String.valueOf(rs.getTime(4));
//                departurePlace = rs.getString(5);
//                arrival = String.valueOf(rs.getDate(6));
//                arrivalTime = String.valueOf(rs.getTime(7));
//                arrivalPlace = rs.getString(8);
//                economy = String.valueOf(rs.getInt(9));
//                business = String.valueOf(rs.getInt(10));
//                cost = String.valueOf(rs.getFloat(11));                   
//            }
//        } catch (Exception e) {
//            System.out.println("getProductByID:" + e.getMessage());
//        }
//    }
//    
//    //search flight by departure/arrival and date
//    public ArrayList<String> searchFlight(String DEPA, String ARRI,String DATE) {
//        ArrayList<String> data = new ArrayList<String>();
//        try {
//            String strSQL = "select * from Flight where Departure = ? and DeparturePlace=? and ArrivalPlace=?";
//            stm = cnn.prepareStatement(strSQL);
//            stm.setDate(1, java.sql.Date.valueOf(DATE));
//            stm.setString(2, DEPA);
//            stm.setString(3, ARRI);
//            rs = stm.executeQuery();            
//            while (rs.next()) {
//                String ID= String.valueOf(rs.getInt(1));
//                data.add(ID);
//            }
//        } catch (Exception e) {
//            System.out.println("checkLogin" + e.getMessage());
//        }
//        return data;
//    }    
//    
//    public boolean update() {
//        try{
//            String strSQL="update Flight set Airline=?,Departure=?,DepartureTime=?,DeparturePlace=?,Arrival=?,ArrivalTime=?,ArrivalPlace=?,Economy=?,Business=?,Cost=?\n" +
//                    "where FlightID=?";
//            stm=cnn.prepareStatement(strSQL);            
//            stm.setString(1, airline);
//            stm.setString(2, departure);
//            stm.setString(3, departureTime);
//            stm.setString(4, departurePlace);
//            stm.setString(5, arrival);
//            stm.setString(6, arrivalTime);
//            stm.setString(7, arrivalPlace);
//            stm.setInt(8, Integer.parseInt(economy));
//            stm.setInt(9, Integer.parseInt(business));
//            stm.setFloat(10, Float.parseFloat(cost));
//            stm.setInt(11, Integer.parseInt(ID));
//            stm.execute();
//            return true;
//        }catch (Exception e){
//            System.out.println("update:"+e.getMessage());
//        }
//        return false;
//    }
//    
//    public boolean UpdateFlight(String Class){
//        if("Business".equals(Class)){
//            business=String.valueOf(Integer.parseInt(business)-1);
//        }else{
//        economy=String.valueOf(Integer.parseInt(economy)-1);
//        }
//        return this.update();
//    }   
    
}

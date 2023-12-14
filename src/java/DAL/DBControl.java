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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
                String departure = parseDateFormat(String.valueOf(rs.getDate(3)));
                String departureTime = String.valueOf(rs.getTime(4));
                String departurePlace = rs.getString(5);
                String arrival = parseDateFormat(String.valueOf(rs.getDate(6)));
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
                String departure = parseDateFormat(String.valueOf(rs.getDate(3)));
                String departureTime = String.valueOf(rs.getTime(4));
                String departurePlace = rs.getString(5);
                String arrival = parseDateFormat(String.valueOf(rs.getDate(6)));
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
    
    //update flight table
    public boolean updateFlight(Flight f) {
        DBconnect();
        try{
            String strSQL="update Flight set Airline=?,Departure=?,DepartureTime=?,DeparturePlace=?,Arrival=?,ArrivalTime=?"
                    + ",ArrivalPlace=?,Economy=?,Business=?,Cost=?\n" +
                    "where FlightID=?";
            stm=cnn.prepareStatement(strSQL);            
            stm.setString(1, f.getAirline());
            stm.setString(2, f.getDeparture());
            stm.setString(3, f.getDepartureTime());
            stm.setString(4, f.getDeparturePlace());
            stm.setString(5, f.getArrival());
            stm.setString(6, f.getArrivalTime());
            stm.setString(7, f.getArrivalPlace());
            stm.setInt(8, Integer.parseInt(f.getEconomy()));
            stm.setInt(9, Integer.parseInt(f.getBusiness()));
            stm.setFloat(10, Float.parseFloat(f.getCost()));
            stm.setInt(11, Integer.parseInt(f.getID()));
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("update:"+e.getMessage());
        }
        return false;
    }
    
    //update flight after an order by class
    public boolean updateFlightByClass(Flight f, String Class){
        if("Business".equals(Class)){
            f.setBusiness(String.valueOf(Integer.parseInt(f.getBusiness())-1));
        }else{
        f.setEconomy(String.valueOf(Integer.parseInt(f.getEconomy())-1));;
        }
        return updateFlight(f);
    }   
    
    //add to flight table
    public boolean addFlight(Flight f) {
        DBconnect();
        try{
            String strSQL="insert into Flight (Airline,Departure,DepartureTime,"
                    + "DeparturePlace,Arrival,ArrivalTime,ArrivalPlace,Economy,Business,Cost)\n" +
                          "VALUES (?,?,?,?,?,?,?,?,?,?)";
            stm=cnn.prepareStatement(strSQL);
            
            stm.setString(1, f.getAirline());
            stm.setString(2, f.getDeparture());
            stm.setString(3, f.getDepartureTime());
            stm.setString(4, f.getDeparturePlace());
            stm.setString(5, f.getArrival());
            stm.setString(6, f.getArrivalTime());
            stm.setString(7, f.getArrivalPlace());
            stm.setInt(8, Integer.parseInt(f.getEconomy()));
            stm.setInt(9, Integer.parseInt(f.getBusiness()));
            stm.setFloat(10, Float.parseFloat(f.getCost()));
            stm.execute();
            return true;
        }catch (Exception e){
            System.out.println("add:"+e.getMessage());
        }
        return false;
    }
    
    //delete from flight table
    public boolean deleteFlight(String fID) {
        DBconnect();
        try {
            String strSQL = "delete from Flight where FlightID = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, Integer.parseInt(fID));
            stm.execute();   
            return true;
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }return false;
    }
    
    
    //parse date format to dd mm yyyy
    public String parseDateFormat(String text) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        Date temp = format.parse(text);
        String result = format1.format(temp);
        return result;
    }
    
    
}

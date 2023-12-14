/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAL.DBControl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class test {
    public static void main(String[] args) {
        DBControl db = new DBControl();
        Flight f = new Flight();        
        ArrayList<Flight>search = db.searchFlight("Ha Noi (HAN)", "TP HCM (SGN)", "2023-07-22");
        for (Flight item: search){
            System.out.println(item.getArrival());
        }
    }
}

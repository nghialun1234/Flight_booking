/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class test {
    public static void main(String[] args) {
        Flight f = new Flight();        
        ArrayList<String>search = f.searchFlight("Ha Noi (HAN)", "TP HCM (SGN)", "2023-07-22");
        ArrayList<Flight> data = new ArrayList<>();
        for (int i=0; i<search.size(); i++) {
            System.out.println(search.get(i));
            Flight temp = new Flight();
            temp.getFlightByID(search.get(i));
            data.add(temp);
        }
        for (int i=0; i<data.size(); i++) {
            System.out.println(data.get(i).getID());
        }
        f.getFlightByID("11");
        System.out.println(f.getID());
        data.add(f);
        System.out.println(data.get(3).getID());
        Date date = new Date();
        System.out.println(date.toString());
    }
}

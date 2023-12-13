/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Admin;
import Model.Airport;
import Model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
@WebServlet(name="ManageFlightController", urlPatterns={"/ManageFlight"})
public class ManageFlightController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageFlightController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageFlightController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Flight f = new Flight();
        Airport a = new Airport();
        ArrayList<Airport> data2 = a.getAirportList();
        request.setAttribute("data2", data2);
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("1")){
            String id = request.getParameter("id");
            f.getFlightByID(id);
            request.setAttribute("f", f);      
            request.getRequestDispatcher("UpdateFlight.jsp").forward(request, response);
        }
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("2")){
            String id = request.getParameter("id");
            f.delete(id);
        }
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("3")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date Today = new Date();
            String today = format.format(Today);
            request.setAttribute("today", today);
            String id = request.getParameter("id");
            f.getFlightByID(id);
            request.setAttribute("f", f);  
            request.getRequestDispatcher("AddFlight.jsp").forward(request, response);
        }
        ArrayList<Flight> data = f.getFlightList();
        request.setAttribute("data", data);
        request.getRequestDispatcher("ManageFlight.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {    
        String ID ="";
        if(request.getParameter("ID")!=null){
            ID=request.getParameter("ID");
        }
        String Airline = request.getParameter("Airline");
        String Departure = request.getParameter("Departure");
        String DepartureTime = request.getParameter("DepartureTime");
        String DeparturePlace = request.getParameter("DeparturePlace");
        String Arrival = request.getParameter("Arrival");
        String ArrivalTime = request.getParameter("ArrivalTime");
        String ArrivalPlace = request.getParameter("ArrivalPlace");
        String Economy = request.getParameter("Economy");
        String Business = request.getParameter("Business");
        String Cost = request.getParameter("Cost");
        Flight f = new Flight(ID, Airline, Departure, DepartureTime, DeparturePlace, Arrival, ArrivalTime, ArrivalPlace, Economy, Business, Cost);
        if (request.getParameter("update") != null) {
            if (f.update()) {
                doGet(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    out.println("UPDATE FAIL");
                }
            }
        }
        if(request.getParameter("add")!=null){
            if (f.add()) {
                doGet(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    out.println("ADD FAIL");
                }
            }
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAL.DBControl;
import Model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@WebServlet(name="SearchFlightController", urlPatterns={"/SearchFlight"})
public class SearchFlightController extends HttpServlet {
   
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
            out.println("<title>Servlet SearchFlightController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchFlightController at " + request.getContextPath () + "</h1>");
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
        String CLASS = request.getParameter("CLASS");
        String no=request.getParameter("no");
        request.setAttribute("no", no);
        String ID=request.getParameter("id");
//        if(request.getAttribute("data2")==null){
            Flight f = new Flight();
            f.getFlightByID(ID);    
            ArrayList<Flight> data = new ArrayList<>();
            data.add(f);
            request.setAttribute("data", data);
            request.setAttribute("id", ID);
            request.setAttribute("CLASS", CLASS);
            request.getRequestDispatcher("Submit.jsp").forward(request, response);
//        }
        
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
        //take data from form
        String Depa = request.getParameter("From");
        String Arri = request.getParameter("To");
        String DATE = request.getParameter("date");
        String CLASS = request.getParameter("class");   
        String NoT=request.getParameter("no");//Number of ticket
//        //test form data
//        PrintWriter out = response.getWriter();
//        out.println(Depa);
//        out.println(Arri);
//        out.println(DATE);
//        out.println(CLASS);
//        out.println(no);
        //store data in a session
        //return to home page if sesssion run out       
        if(request.getSession(false)==null){
            HomeController hc = new HomeController();
            hc.doGet(request, response);
            return;
        }
        HttpSession sa = request.getSession();
        sa.setAttribute("Depa", Depa);
        sa.setAttribute("Arri", Arri);
        sa.setAttribute("DATE", DATE);
        sa.setAttribute("CLASS", CLASS);
        sa.setAttribute("NoT", NoT);
        
        if(request.getParameter("returnDate")!=null){
            String Return=request.getParameter("returnDate");
            ArrayList<String>data2 = new ArrayList<>();
            data2.add(Arri);
            data2.add(Depa);
            data2.add(Return);
            request.setAttribute("data2", data2);
        }
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-dd-MM");
//        String doe="";
//        try {
//            doe=format2.format(format1.parse(date));
//        } catch (ParseException ex) {
//            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        Flight f = new Flight();        
//        ArrayList<String>search = f.searchFlight(Depa, Arri, DATE);
//        ArrayList<Flight> data = new ArrayList<>();
//        for (int i=0; i<search.size(); i++) {
//            Flight temp = new Flight();
//            temp.getFlightByID(search.get(i));
//            data.add(temp);
//        }
        DBControl db = new DBControl();
        ArrayList<Flight> data = db.searchFlight(Depa, Arri, DATE);
        request.setAttribute("data", data);
        request.getRequestDispatcher("SearchFlight.jsp").forward(request, response);     
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

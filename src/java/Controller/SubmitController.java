/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAL.DBControl;
import Model.Flight;
import Model.OrderF;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author admin
 */
@WebServlet(name="SubmitController", urlPatterns={"/Submit"})
public class SubmitController extends HttpServlet {
   
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
            out.println("<title>Servlet SubmitController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubmitController at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        //return to home page if sesssion run out       
        if (request.getSession(false) == null) {
            HomeController hc = new HomeController();
            hc.doGet(request, response);
            return;
        }
        //get data from session and form
        DBControl db = new DBControl()
        HttpSession sa = request.getSession();
        String CLASS = (String) sa.getAttribute("CLASS");
        ArrayList<Flight> result = (ArrayList<Flight>) sa.getAttribute("result");
        int NoT =(int) sa.getAttribute("NoT");
        String number = request.getParameter("number");
        
        //generate random order id
        UUID randomUUID = UUID.randomUUID();
        String oID = randomUUID.toString().replaceAll("-", "").substring(0, 12);
        
        //add new order, loop for number of ticket
        for(int i=1; i<=NoT;i++){
            String paraName = String.valueOf(i);
            String name=request.getParameter(paraName);
            
            for(Flight item: result){
                OrderF o = new OrderF(oID, item.getID(), name, number, CLASS);
                o.add();
                
                f.UpdateFlight(CLASS);
            }
            
            
        }              
        
        request.setAttribute("OID", oID);
        sa.invalidate();
        request.getRequestDispatcher("Finish.jsp").forward(request, response);
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

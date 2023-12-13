/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
@WebServlet(name="ManageAdminController", urlPatterns={"/ManageAdmin"})
public class ManageAdminController extends HttpServlet {
   
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
            out.println("<title>Servlet ManageAdminController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageAdminController at " + request.getContextPath () + "</h1>");
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
        Admin a = new Admin();
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("1")){
            String username = request.getParameter("id");
            a.getAdminByName(username);
            request.setAttribute("a", a);      
            request.getRequestDispatcher("UpdateAdmin.jsp").forward(request, response);
        }
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("2")){
            String username = request.getParameter("id");
            a.delete(username);
        }
        if(request.getParameter("mod")!=null && request.getParameter("mod").equals("3")){
            String username = request.getParameter("id");
            a.getAdminByName(username);
            request.setAttribute("a", a);   
            request.getRequestDispatcher("AddAdmin.jsp").forward(request, response);
        }
        ArrayList<Admin> data = a.getAdminList();
        request.setAttribute("data", data);
        request.getRequestDispatcher("ManageAdmin.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String level = request.getParameter("level");
        Admin a = new Admin(name, pass, level);
        if (request.getParameter("update") != null) {
            if (a.update()) {
                doGet(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    out.println("UPDATE FAIL");
                }
            }
        }
        if(request.getParameter("add")!=null){
            if (a.add()) {
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

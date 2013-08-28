/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.RegistrationHelper;
import com.enb.Helper.UserLogHelper;
import com.enb.POJO.Userauth;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Title: Login class- component of the ENB tool
 * </p>
 * <p>
 * Description- It is an entity class which is used to authenticate user and create a session 
 * </p>
 * @author Avinash
 */
// HTTP servlets enable you to send and receive data using an HTML form.
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            RegistrationHelper rh=new RegistrationHelper();
            Userauth ua=rh.getUserauth(request.getParameter("email"), request.getParameter("pass")); //checks valid details are entered
            if(ua!=null){
                HttpSession session=request.getSession(); //creates a session for a valid user
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("name", ua.getName());
                session.setAttribute("uid", ua.getId());
                System.out.print("\n\nlogin"+ua.getId()+"\n\n");   // gets the id of the user logged in 
                UserLogHelper uh=new UserLogHelper();
                uh.insertlog(session.getAttribute("uid").toString(),"Login");    //creates log for the user
                response.sendRedirect("Homepage.jsp");     // opens home page in the ENB tool
            }
            // redirects to the same page if the user enters invalid email-id or password
            else{
                request.setAttribute("error", "Invalid Email-ID or Password"); // displays error message
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

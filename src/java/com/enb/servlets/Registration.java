/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.ProjectHelper;
import com.enb.Helper.RegistrationHelper;
import com.enb.Helper.UserLogHelper;
import com.enb.POJO.Userauth;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * <p>
 * Title: Registration class - A component of the ENB Tool
 * </p>
 * <p>
 * Description: It is an entity class which is used to register user details
 * </p>
 * 
 * @author Avinash
 */
// HTTP servlets enable you to send and receive data using an HTML form.

public class Registration extends HttpServlet {

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
            String email=request.getParameter("email");
            RegistrationHelper rh=new RegistrationHelper();
            if(rh.ValidateUser(email)!=null){    //checks the existence of email id
                RequestDispatcher rd=request.getRequestDispatcher("signup.jsp"); //redirects to the same page if invalid
                request.setAttribute("error", "<span class='alert'>Email ID already Exists</span>"); //displays error message
                rd.forward(request, response);
            }
            else{
                /* TODO output your page here. You may use following sample code. */
                Userauth ua = new Userauth();
                // add details to the userauthentication
                ua.setEmailId(request.getParameter("email"));
                ua.setName(request.getParameter("fname"));
                ua.setPassword(request.getParameter("pass"));
                //inserts the user details into database
                rh.insertUserauth(ua);
                HttpSession session=request.getSession(); // creates a session for the user
                Userauth ua1=rh.getUserauth(request.getParameter("email"), request.getParameter("pass"));
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("uid", ua1.getId());
                session.setAttribute("name", request.getParameter("fname"));
                UserLogHelper uh=new UserLogHelper();    // inserts into the user log
                uh.insertlog(session.getAttribute("uid").toString(),"Registered");   
                response.sendRedirect("Homepage.jsp"); // redirects to the home page of ENB if valid details are entered
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

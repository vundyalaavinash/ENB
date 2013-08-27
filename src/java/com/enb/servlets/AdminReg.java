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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author B.Revanth
 */
@WebServlet(name = "AdminReg", urlPatterns = {"/AdminReg"})
public class AdminReg extends HttpServlet {

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
            String email=request.getParameter("email");
            RegistrationHelper rh=new RegistrationHelper();
            if(rh.ValidateUser(email)!=null){
                RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
                request.setAttribute("error", "<span class='alert'>Email ID already Exists</span>");
                rd.forward(request, response);
            }
            else{
                /* TODO output your page here. You may use following sample code. */
                Userauth ua = new Userauth();

                ua.setEmailId(request.getParameter("email"));
                ua.setName(request.getParameter("fname"));
                ua.setPassword(request.getParameter("pass"));
                ua.setUserrole("mentor");
                rh.insertUserauth(ua);
                HttpSession session=request.getSession();
                Userauth ua1=rh.getUserauth(request.getParameter("email"), request.getParameter("pass"));
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("uid", ua1.getId());
                session.setAttribute("name", request.getParameter("fname"));
                UserLogHelper uh=new UserLogHelper();
                uh.insertlog(session.getAttribute("uid").toString(),"Registered");
                response.sendRedirect("adminhome.jsp");
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

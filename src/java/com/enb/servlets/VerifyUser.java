/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.RegistrationHelper;
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
 *
 * @author Avinash
 */
public class VerifyUser extends HttpServlet {

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
            //retrieving email from the prarameters 
            
            String email=request.getParameter("email");
            //retrieving code entered by the user form the parameters
            String code=request.getParameter("code");
            RegistrationHelper rh=new RegistrationHelper();
            Userauth ua=rh.getUserauth(email);
            HttpSession session=request.getSession();
            if(ua.getVerificationCode().equals(code)){
                ua.setVerificationCode("Yes");
                rh.VerifyCode(ua);
                session.setAttribute("email", ua.getEmailId());
                session.setAttribute("uid", ua.getId());
                session.setAttribute("name", ua.getName());
                session.setAttribute("batch", ua.getMentoring());
                if(ua.getUserrole().equals("mentor")){
                    response.sendRedirect("adminhome.jsp");
                }
                else{
                    response.sendRedirect("Homepage.jsp");
                }
            }   
            else{
                RequestDispatcher rd=request.getRequestDispatcher("verify.jsp");
                request.setAttribute("error", "<span class='alert'>Invalid Verification Code</span>");
                rd.forward(request, response);
            }
        } 
        catch(Exception ex){
            ex.printStackTrace();
            RequestDispatcher rd=request.getRequestDispatcher("verify.jsp");
            request.setAttribute("error", "<span class='alert'>"+ex.getMessage()+"</span>");
            rd.forward(request, response);
        }
        finally {            
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

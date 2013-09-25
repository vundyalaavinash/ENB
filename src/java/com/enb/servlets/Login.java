/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.RegistrationHelper;
import com.enb.Helper.SendMailTLS;
import com.enb.Helper.UserLogHelper;
import com.enb.MiscClasses.RandomString;
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
            RegistrationHelper rh = new RegistrationHelper();
            Userauth ua = rh.getUserauth(request.getParameter("email").toString());
            if (ua != null) {
                System.out.println("ua: "+request.getParameter("pass").toString());
                if (ua.getPassword().equals(request.getParameter("pass").toString())) {
                    if (ua.getVerificationCode() == null) {
                        RandomString rs = new RandomString(6);
                        ua.setVerificationCode(rs.nextString());
                        rh.VerifyCode(ua);
                        SendMailTLS send = new SendMailTLS();
                        send.sendMail(ua.getEmailId(), ua.getVerificationCode());
                    }
                    if (!ua.getVerificationCode().equals("Yes")) {
                        response.sendRedirect("verify.jsp?email=" + ua.getEmailId());
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("email", request.getParameter("email"));
                        session.setAttribute("name", ua.getName());
                        session.setAttribute("uid", ua.getId());
                        UserLogHelper uh = new UserLogHelper();
                        uh.insertlog(session.getAttribute("uid").toString(), "Login");
                        if(ua.getUserrole()!=null){
                            if (ua.getUserrole().equals("student")) {
                                response.sendRedirect("Homepage.jsp");
                            } else {
                                session.setAttribute("batch", ua.getMentoring());
                                response.sendRedirect("adminhome.jsp");
                            }
                        }
                        else{
                            session.setAttribute("batch", ua.getMentoring());
                            response.sendRedirect("adminhome.jsp");
                        }
                    }
                }
                else{
                    request.setAttribute("error", "Invalid Email-ID or password");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("error", "Invalid Email-ID");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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

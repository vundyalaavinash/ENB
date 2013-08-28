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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Title: Change password class- component of the ENB tool
 * </p>
 * <p>
 * Description- It is an entity class which is used to retrieve password using email
 * </p>
 * 
 * @author B.Revanth
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
// HTTP servlets enable you to send and receive data using an HTML form.
public class ChangePassword extends HttpServlet { 

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
            Userauth ua=new Userauth();
            RegistrationHelper rh=new RegistrationHelper();
            HttpSession session=request.getSession();
            System.out.println(""+request.getParameter("email"));
            System.out.println(""+request.getParameter("cpass"));
            System.out.println("");
            System.out.println("");
            Userauth ua1=rh.getUserauth(request.getParameter("email"), request.getParameter("cpass"));
            if(ua1!=null)
            {
                if(request.getParameter("npass").equals(request.getParameter("renpass")))
                {
                    Userauth id=rh.getUserId((String)session.getAttribute("email"));
                    ua.setId(id.getId());
                    ua.setEmailId(request.getParameter("email"));
                    ua.setPassword(request.getParameter("npass"));
                    ua.setName((String)session.getAttribute("name"));
                    rh.changePassword(ua);
                    UserLogHelper uh=new UserLogHelper();
                    uh.insertlog(session.getAttribute("uid").toString(),"Change Password");
                    out.print("done");
                }
                else
                      out.print("Retype Password Not Matching!");
            }
            else{
                out.print("Incorrect Old Password!");
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

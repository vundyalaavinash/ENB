/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.RegistrationHelper;
import com.enb.MiscClasses.RandomString;
import com.enb.POJO.Userauth;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Avinash
 */
public class ForgotPassword extends HttpServlet {

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
            String email = request.getParameter("email");
            RegistrationHelper rh = new RegistrationHelper();
            Userauth ua=rh.getUserauth(email);
            
            if(ua.getPassword()==null){
                RandomString rs=new RandomString(6);
                ua.setPassword(rs.nextString());
                rh.changePassword(ua);
            }
            String pass = ua.getPassword();
            final String username = "enbtool@gmail.com";
            final String password = "enbarm007";

            Properties props = new Properties();
            /*props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");*/
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");


            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                message.setSubject("Reg: Forgot Password ");
                message.setText("Dear User,"
                        + "\n\nThis is an Automates Password Retrieval Mail\n"
                        + "Username : " + email + "\n"
                        + "Password : " + pass + "\n"
                        + "\n\n\n\nHappy Using ENB Tool!");
                Transport.send(message);
                response.sendRedirect("success.jsp?id=axty1");
            } catch (MessagingException e) {
                RequestDispatcher rd = request.getRequestDispatcher("forgot.jsp");
                request.setAttribute("error", "<span class='alert'>" + e.getMessage() + "</span>");
                rd.forward(request, response);
            }
        }catch(Exception ex){
            out.println(""+ex.getMessage());
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

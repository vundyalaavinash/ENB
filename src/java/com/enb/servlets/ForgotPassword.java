/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.RegistrationHelper;
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
 *<p>
 * Title: ForgotPassword class - A component of the ENB Tool
 * </p>
 * <p>
 * Description: It is an entity class which is used to recover the password
 * </p>
 * @author Avinash
 */
// HTTP servlets enable you to send and receive data using an HTML form.
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
                String email=request.getParameter("email");
                RegistrationHelper rh=new RegistrationHelper();
                String pass=rh.getPassword(email);
                final String username = "enbtool@gmail.com";
		final String password = "enbarm007";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress("enbtool@gmail.com"));   // password is sent from the server system email
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));           // password sent to the destination address
			message.setSubject("Forgot->Password");          // setting subject to the mail
			message.setText("Dear User,\n\n"+"\t\tUserName: "+email+"\n"
				+ "\n\t\t Your PassWord is: "+pass);
 
			Transport.send(message);    //sends the password to mail
 
			System.out.println("Done"); //print success message
                        response.sendRedirect("index.jsp"); // redirects to the login page
 
		} catch (MessagingException e) {
                        RequestDispatcher rd=request.getRequestDispatcher("forgot.jsp");   // displays the same page if error occurs in sending 
                        request.setAttribute("error", "<div id='projalert'><span class='alert'>Error in sending email. Try Later!</span></div>");
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

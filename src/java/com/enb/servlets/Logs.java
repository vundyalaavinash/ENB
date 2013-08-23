/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.UserLogHelper;
import com.enb.POJO.Userlog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Avinash
 */
public class Logs extends HttpServlet {

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
            HttpSession session=request.getSession();
            String date[]=request.getParameter("to").split("/");
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE, Integer.parseInt(date[0]));
            cal.add(Calendar.MONTH, Integer.parseInt(date[1])-1);
            cal.add(Calendar.YEAR, Integer.parseInt(date[2]));
            UserLogHelper uh=new UserLogHelper();
            ArrayList<Userlog> logs=new ArrayList<Userlog>();
            logs=uh.getUserlogs(Integer.parseInt(session.getAttribute("uid").toString()), cal);
            if(!logs.isEmpty()){
                int j=0;
                String log="";
                log=log+"<table border='0' width=100%' cellspacing=10px' id='logs'><tr><td><strong>Date & Time</strong></td><td><strong>Description</strong></td></tr>";				
                for(int i=0;i<logs.size();i++){
                    log=log+"<tr><td>"+logs.get(i).getId().getLogDt() +"</td>";
                    log=log+"<td>"+logs.get(i).getDescription() +"</td></tr>";
                }
                out.print(log+"</table>");
            }
            out.print("<table border='0' width=100%' cellspacing=10px' id='logs'><tr><td><strong>Date & Time</strong></td><td><strong>Description</strong></td></tr><tr><td>No Activity on that date</td><td></td></tr></table>");
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.EnbdescHelper;
import com.enb.Helper.ProjectHelper;
import com.enb.POJO.Enbdesc;
import com.enb.POJO.Project;
import com.enb.POJO.Userauth;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

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
@WebServlet(name = "CreateForm", urlPatterns = {"/CreateForm"})
public class CreateForm extends HttpServlet {

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
            Project p=new Project();
            Enbdesc e=new Enbdesc();
            String dateFrom=request.getParameter("from");
            String dateTo=request.getParameter("to");
            p.setProjectName(request.getParameter("proj"));
            
            
            Userauth ua=new Userauth();
            HttpSession session=request.getSession();
            ua.setId(Integer.parseInt(session.getAttribute("uid").toString()));
            
            p.setUserauth(ua);
            String date[]=request.getParameter("from").toString().split("/");
            Calendar c=Calendar.getInstance();
            c.set(Calendar.YEAR, Integer.parseInt(date[2]));
            c.set(Calendar.MONTH, Integer.parseInt(date[1])-1);
            c.set(Calendar.DATE, Integer.parseInt(date[0]));
            
            String date1[]=request.getParameter("to").toString().split("/");
            Calendar c1=Calendar.getInstance();
            c1.set(Calendar.YEAR, Integer.parseInt(date1[2]));
            c1.set(Calendar.MONTH, Integer.parseInt(date1[1])-1);
            c1.set(Calendar.DATE, Integer.parseInt(date1[0]));                        
            
            p.setFromDate(c.getTime());
            p.setToDate(c1.getTime());
            
            
            Calendar now = Calendar.getInstance();  
            int weekday = now.get(Calendar.DAY_OF_WEEK);               
            int days = (Calendar.SATURDAY - weekday) % 7;  
            System.out.print(""+days);
            now.add(Calendar.DAY_OF_YEAR, days);  
            
            Calendar cal = Calendar.getInstance();
            
            ProjectHelper ph=new ProjectHelper();
            ph.insertProject(p);
            
            p=ph.getProject(ua.getId(),p.getProjectName());
            
            e.setEnbname(request.getParameter("enbname")); 
            e.setProject(p);
            e.setFromdate(cal.getTime());
            e.setTodate(now.getTime());         
            e.setUserauth(ua);          
            
            EnbdescHelper eh= new EnbdescHelper();
            eh.insertEnbdesc(e);            
            session.setAttribute("enbname", e.getEnbname());    
            session.setAttribute("emid", eh.getEnbid(e.getEnbname()).getId());
            System.out.println(""+session.getAttribute("emid"));
            response.sendRedirect("ENB.jsp");
            
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

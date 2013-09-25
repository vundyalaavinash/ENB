/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Avinash
 */
public class Groups extends HttpServlet {

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
            String[] sids = request.getParameterValues("students");
            HttpSession session=request.getSession();
            int mid=Integer.parseInt(session.getAttribute("uid").toString());            
            GroupHelper gh=new GroupHelper();
            gh.removeAllInGroups(mid);
            RegistrationHelper rh=new RegistrationHelper();
            for(int i=0;i< sids.length;i++){
                int uid=Integer.parseInt(sids[i]);
                com.enb.POJO.Groups group=new com.enb.POJO.Groups();
                com.enb.POJO.Userauth meid=new com.enb.POJO.Userauth();
                meid.setId(mid);
                com.enb.POJO.Userauth sid=new com.enb.POJO.Userauth();
                sid.setId(uid);
                group.setUserauthByMid(meid);
                group.setUserauthBySid(sid);
                gh.insertGroup(group);                
            }
            out.print("done!");
        }
        catch(Exception ex){
            ex.printStackTrace();
            out.print(""+ex.getMessage());
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

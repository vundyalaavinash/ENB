/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.POJO.Deliverablestatus;
import com.enb.POJO.Lessons;
import com.enb.POJO.Notes;
import com.enb.POJO.Plan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Avinash
 */
public class enb extends HttpServlet {

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
        int maxpl=0;
        int maxds=0;
        int maxln=0;
        try {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<String> al=new ArrayList<String>();
            Enumeration enu=request.getParameterNames();
            HashMap<String,String> map=new HashMap<String,String>();
            String Notes=request.getParameter("notes1").toString();
            int eid=Integer.parseInt(request.getParameter("eid"));
            while(enu.hasMoreElements()){
                String check=enu.nextElement().toString();
                if(check.charAt(0)=='d' && check.charAt(1)=='s'){
                    if(Integer.parseInt(""+check.charAt(3))>maxds){
                        maxds=Integer.parseInt(""+check.charAt(3));
                    }
                }
                else if(check.charAt(0)=='p' && check.charAt(1)=='l'){
                    if(Integer.parseInt(""+check.charAt(3))>maxpl){
                        maxpl=Integer.parseInt(""+check.charAt(3));
                    }
                }
                else if(check.charAt(0)=='l' && check.charAt(1)=='n'){
                    if(Integer.parseInt(""+check.charAt(3))>maxln){
                        maxln=Integer.parseInt(""+check.charAt(3));
                    }
                }
                map.put(check, request.getParameter(check));
            }        
            Lessons l[]=new Lessons[maxln];
            Plan p[]=new Plan[maxpl];
            Deliverablestatus d[]=new Deliverablestatus[maxds];
            Notes n=new Notes();
            for(int i=0;i<maxpl;i++){
                p[i]=new Plan();
                p[i].setDeliverable(map.get("pld"+i));
                p[i].setIntendToAccomplish(map.get("plw"+i));                
            }            
            for(int i=0;i<maxln;i++){
                l[i]=new Lessons();    
                l[i].setContext(map.get("lnc"+i));
                l[i].setLessons(map.get("lnl"+i));
            }            
            for(int i=0;i<maxds;i++){
                d[i]=new Deliverablestatus();
                d[i].setDeliverables(map.get("dsd"+i));
                d[i].setEffort(map.get("dse"+i));
                d[i].setPlanToAccomplish(map.get("dsp"+i));
                d[i].setActualAccomplished(map.get("dsa"+i));
                d[i].setSize(map.get("dss"+i));
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

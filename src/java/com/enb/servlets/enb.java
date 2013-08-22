/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.DeliverablesHelper;
import com.enb.Helper.LessonsHelper;
import com.enb.Helper.NotesHelper;
import com.enb.Helper.PlanHelper;
import com.enb.POJO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            
            ArrayList<String> al=new ArrayList<String>();
            Enumeration enu=request.getParameterNames();
            HashMap<String,String> map=new HashMap<String,String>();
            
            HttpSession session=request.getSession();
            
            String notes=request.getParameter("notes1").toString();
            int eid=0;
            if(request.getParameter("eid")==null){
                eid=Integer.parseInt(session.getAttribute("emid").toString());
            }
            else{
                eid=Integer.parseInt(request.getParameter("eid"));
            }
            
            
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
            Enbdesc e=new Enbdesc();
            
            Calendar savedtime=Calendar.getInstance();
            notes=notes+"<br/><br/>"+savedtime.get(Calendar.DATE)+"-"+savedtime.get(Calendar.MONTH)+"-"+savedtime.get(Calendar.YEAR)+" @ "+savedtime.get(Calendar.HOUR)+":"+savedtime.get(Calendar.MINUTE)+":"+savedtime.get(Calendar.SECOND);
            
            e.setId(eid);                                 
            n.setNotes(notes.getBytes());
            n.setEnbdesc(e);
            n.setEnbid(eid);
            
            PlanHelper ph=new PlanHelper();
            LessonsHelper lh=new LessonsHelper();
            DeliverablesHelper dh=new DeliverablesHelper();
            NotesHelper nh=new NotesHelper();
            
            
            System.out.println("enb ID : "+eid);
            nh.removeNotes(eid);
            ph.removePlan(eid);
            lh.deleteLessons(eid);
            dh.removeDeliverablestatus(eid);
            
            nh.insertNotes(n);
            for(int i=0;i<maxpl;i++){
                p[i]=new Plan();
                
                PlanId pid=new PlanId();
                pid.setEnbid(eid);
                pid.setSno(i);  
                
                p[i].setId(pid);
                p[i].setDeliverable(map.get("pld"+(i+1)));
                p[i].setIntendToAccomplish(map.get("plw"+(i+1)));           
                p[i].setEnbdesc(e);
                ph.insertPlan(p[i]);
            }           
            
            for(int i=0;i<maxln;i++){
                
                l[i]=new Lessons();    
                
                LessonsId lid=new LessonsId();
                lid.setEnbid(eid);
                lid.setSno(i);  
                l[i].setId(lid);
                
                l[i].setContext(map.get("lnc"+(i+1)));
                l[i].setLessons(map.get("lnl"+(i+1)));
                l[i].setEnbdesc(e);
                lh.insertLessons(l[i]);
            }      
            
            for(int i=0;i<maxds;i++){
                d[i]=new Deliverablestatus();
                
                DeliverablestatusId did=new DeliverablestatusId();
                did.setEnbid(eid);
                did.setSno(i);               
                
                d[i].setId(did);
                d[i].setDeliverables(map.get("dsd"+(i+1)));
                d[i].setEffort(map.get("dse"+(i+1)));
                d[i].setPlanToAccomplish(map.get("dsp"+(i+1)));
                d[i].setActualAccomplished(map.get("dsa"+(i+1)));
                d[i].setSize(map.get("dss"+(i+1)));
                d[i].setEnbdesc(e);
                dh.insertDeliverablestatus(d[i]);
            }
            out.print("done");
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

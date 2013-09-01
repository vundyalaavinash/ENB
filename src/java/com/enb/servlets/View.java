/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.*;
import com.enb.POJO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Avinash
 */
public class View extends HttpServlet {

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
        HttpSession session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            int eid = Integer.parseInt(request.getParameter("eid"));
            int uid = Integer.parseInt(session.getAttribute("uid").toString());
            EnbdescHelper eh = new EnbdescHelper();
            Enbdesc ed = eh.getEnbdescID(eid);
            RegistrationHelper rh = new RegistrationHelper();
            NotesHelper nh = new NotesHelper();
            DeliverablesHelper dh = new DeliverablesHelper();
            LessonsHelper lh = new LessonsHelper();
            PlanHelper plh = new PlanHelper();
            
            Calendar from = Calendar.getInstance();
            from.setTime(ed.getFromdate());

            Calendar to = Calendar.getInstance();
            to.setTime(ed.getTodate());

            String proj = ed.getProject().getProjectName();
            Set notes = ed.getNoteses();
            Set ds =  ed.getDeliverablestatuses();
            Set ln = ed.getLessonses();
            Set pl = ed.getPlans();
            

            out.print("<table width='100%'><tr><td colspan='2'><h2>" + proj.toUpperCase() + "</h2></td></tr><tr>");
            out.print("<td width='50%'>Engineer: <span style='color:#47a3da;'>");
            if (session.getAttribute("name") == null) {
                response.sendRedirect("index.jsp");
            } 
            else {
                out.println(session.getAttribute("name"));
            }
            out.print("</span></td>");
            out.print("<td width='50%' align='right'>Duration: <span style='color:#47a3da;'>");
            out.print("&nbsp;&nbsp;&nbsp;"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR));
            out.print("</span>&nbsp;&nbsp;to<span style='color:#47a3da;'>");
            out.print("&nbsp;&nbsp;&nbsp;"+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR));
            out.print("</span></td></tr></table><br><hr><br>");
            
            String enbname = ed.getEnbname();
            EnbdescHelper eh1 = new EnbdescHelper();
            Enbdesc enb = eh1.getEnbid(enbname, uid);
            
            //Notes
            out.print("<h2>Notes</h2><table><tr><td><div style='font-size:15px; width:100%;'>");
            ArrayList<Notes> itr = nh.getNote(ed.getId());
            if (!itr.isEmpty()) {
                Notes note = (Notes) itr.get(0);
                String s = new String(note.getNotes());
                out.print(s);
            }
            else{
                out.println("No Notes in the ENB ....");
            }
            out.print("</div></td></tr></table><br><hr><br>");

            //Deliverable Status
            out.print("<h2>Deliverable Status</h2><table width='100%' border='0' cellspacing='10'><tr><td width='5%'>SNO</td><td width='16%'>Deliverable</td><td width='27%'>What did you plan to accomplish?</td><td width='27%'>What did you actually accomplish?</td><td width='10%'>Size</td><td width='10%'>Effort</td></tr>");
            int i=0;
            ArrayList<Deliverablestatus> dsi = dh.getDeliverablestatus(ed.getId());            
            for (i = 0; i < dsi.size(); i++) {
                Deliverablestatus dso=dsi.get(i);
                out.print("<tr><td>"+(i+1)+"</td><td>"+dso.getDeliverables()+"</td><td>"+dso.getPlanToAccomplish()+"</td><td>"+dso.getActualAccomplished()+"</td><td>"+dso.getSize()+"</td><td>"+dso.getEffort()+"</td></tr>");
            }
            out.print("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr></table><br><hr><br>");
            //Lessons Learned  
            
            out.print("<h2>Lessons Learned Reflection</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO.</td><td width='25%'>Context</td><td width='65%'>Lesson</td></tr>");
            ArrayList<Lessons> lni = lh.getLessons(ed.getId());
            for (i = 0; i < lni.size(); i++) {
                Lessons lno = lni.get(i);
                out.print("<tr><td>"+(i+1)+"</td><td>"+lno.getContext()+"</td><td>"+lno.getLessons()+"</td></tr>");
            }
            out.print("<tr><td></td><td></td><td></td></tr></table><br><hr><br>");
            
            //plans
            out.print("<h2>Plan for the Next Week</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO</td><td width='25%'>Deliverable</td><td width='65%'>What do you intend to accomplish and why</td></tr>");
            ArrayList<Plan> pli = plh.getPlan(ed.getId());
            for (i = 0; i < pli.size(); i++) {
                Plan plo = pli.get(i);
                out.print("<tr><td width='10%'>"+(i+1)+"</td><td width='25%'>"+plo.getDeliverable()+"</td><td width='65%'>"+plo.getIntendToAccomplish()+"</td></tr>");
            }
            out.print("<tr><td></td><td></td><td></td></tr></table>");
            UserLogHelper uh=new UserLogHelper();
            if(session.getAttribute("uid")==null)
                response.sendRedirect("index.jsp");
            uh.insertlog(session.getAttribute("uid").toString(),"View ENB-"+ed.getEnbname());
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.EnbdescHelper;
import com.enb.Helper.UserLogHelper;
import com.enb.POJO.*;
import java.io.IOException;
import java.io.PrintWriter;
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

            EnbdescHelper eh = new EnbdescHelper();
            Enbdesc ed = eh.getEnbdescID(eid);

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
            
            //Notes
            Iterator<Notes> n=notes.iterator();
            out.print("<h2>Notes</h2><table><tr><td><div style='font-size:15px; width:100%;'>");
            if(n.hasNext()){
                String note = new String(n.next().getNotes());
                out.print(note);
            }
            else{
                out.println("No Notes in the ENB ....");
            }
            out.print("</div></td></tr></table><br><hr><br>");

            //Deliverable Status
            Iterator<Deliverablestatus> dsi=ds.iterator();
            out.print("<h2>Deliverable Status</h2><table width='100%' border='0' cellspacing='10'><tr><td width='5%'>SNO</td><td width='16%'>Deliverable</td><td width='27%'>What did you plan to accomplish?</td><td width='27%'>What did you actually accomplish?</td><td width='10%'>Size</td><td width='10%'>Effort</td></tr>");
            int i=0;
            while(dsi.hasNext()){
                i++;
                Deliverablestatus dso=dsi.next();
                out.print("<tr><td>"+i+"</td><td>"+dso.getDeliverables()+"</td><td>"+dso.getPlanToAccomplish()+"</td><td>"+dso.getActualAccomplished()+"</td><td>"+dso.getSize()+"</td><td>"+dso.getEffort()+"</td></tr>");
            }
            out.print("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr></table><br><hr><br>");
            //Lessons Learned  
            Iterator<Lessons> lni=ln.iterator();
            out.print("<h2>Lessons Learned Reflection</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO.</td><td width='25%'>Context</td><td width='65%'>Lesson</td></tr>");
            i=0;
            while(lni.hasNext()){
                i++;
                Lessons lno=lni.next();
                out.print("<tr><td>"+i+"</td><td>"+lno.getContext()+"</td><td>"+lno.getLessons()+"</td></tr>");
            }
            out.print("<tr><td></td><td></td><td></td></tr></table><br><hr><br>");
            
            //plans
            Iterator<Plan> pli=pl.iterator();
            out.print("<h2>Plan for the Next Week</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO</td><td width='25%'>Deliverable</td><td width='65%'>What do you intend to accomplish and why</td></tr>");
            i=0;
            while(pli.hasNext()){
                i++;
                Plan plo=pli.next();
                out.print("<tr><td width='10%'>"+i+"</td><td width='25%'>"+plo.getDeliverable()+"</td><td width='65%'>"+plo.getIntendToAccomplish()+"</td></tr>");
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

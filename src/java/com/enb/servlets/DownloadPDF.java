/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.DeliverablesHelper;
import com.enb.Helper.EnbdescHelper;
import com.enb.Helper.LessonsHelper;

import com.enb.Helper.NotesHelper;
import com.enb.Helper.PlanHelper;
import com.enb.Helper.RegistrationHelper;
import com.enb.Helper.UserLogHelper;
import com.enb.POJO.Deliverablestatus;
import com.enb.POJO.Enbdesc;
import com.enb.POJO.Lessons;
import com.enb.POJO.Plan;
import com.enb.POJO.Userauth;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "DownloadPDF", urlPatterns = {"/DownloadPDF"})
public class DownloadPDF extends HttpServlet {

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
            throws ServletException, IOException, FileNotFoundException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FileOutputStream file=null;
        try {
            HttpSession session=request.getSession();
            String html=request.getParameter("htmlcontent");
            String enbname=request.getParameter("selectenb");
            out.println(html);
            int eid=Integer.parseInt(enbname);
            EnbdescHelper eh = new EnbdescHelper();
            Enbdesc ed = eh.getEnbdescID(eid);

            Calendar from = Calendar.getInstance();
            from.setTime(ed.getFromdate());

            Calendar to = Calendar.getInstance();
            to.setTime(ed.getTodate());
            NotesHelper nh=new NotesHelper();
            DeliverablesHelper dsh=new DeliverablesHelper();
            String proj = ed.getProject().getProjectName();
            Set notes = ed.getNoteses();
            Set ds =  ed.getDeliverablestatuses();
            Set ln = ed.getLessonses();
            Set pl = ed.getPlans();
            //Client client = new Client("hemanth", "62ebd12b355aac3c0020b484bbc92ec9");
           
            UserLogHelper uh=new UserLogHelper();
            RegistrationHelper rh=new RegistrationHelper();
            String path="C:\\Users\\Avinash\\Documents\\NetBeansProjects\\ENB\\web\\pdfs\\";
            uh.insertlog(session.getAttribute("uid").toString(),"Download PDF-"+enbname);
            Userauth ua=rh.getDetails(Integer.parseInt(session.getAttribute("uid").toString()));
            new File(path +ua.getEmailId()).delete();
            new File(path +ua.getEmailId()).mkdir();
            file = new FileOutputStream(new File(path +ua.getEmailId()+"\\"+enbname + ".pdf"));
            StringBuilder sb = new StringBuilder();
            //client.convertHtml(html, file);
            Document document = new Document(PageSize.LETTER);
            PdfWriter.getInstance(document, file);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            sb.append("<html><head></head><body>");
            
            
            sb.append("<table width='100%'><tr><td colspan='2'><h2>" + proj.toUpperCase() + "</h2></td></tr><tr>");
            sb.append("<td width='50%'>Engineer: <span style='color:#47a3da;'>");
            if (session.getAttribute("name") == null) {
                response.sendRedirect("index.jsp");
            } 
            else {
                sb.append(session.getAttribute("name").toString());
            }
            sb.append("</span></td>");
            sb.append("<td width='50%' align='right'>Duration: <span style='color:#47a3da;'>");
            sb.append("&nbsp;&nbsp;&nbsp;"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR));
            sb.append("</span>&nbsp;&nbsp;to<span style='color:#47a3da;'>");
            sb.append("&nbsp;&nbsp;&nbsp;"+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR));
            sb.append("</span></td></tr></table><br><br><br>");
            
            //Notes
            //Iterator n=notes.iterator();
            
            sb.append("<h2>Notes</h2><table><tr><td><div style='font-size:15px; width:100%;'>");
            sb.append(nh.getNotes(eid));
          
            sb.append("</div></td></tr></table><br><br><br>");
            
            //Deliverable Status
            
            sb.append("<h2>Deliverable Status</h2><table width='100%' border='0' cellspacing='10'><tr><td width='5%'>SNO</td><td width='16%'>Deliverable</td><td width='27%'>What did you plan to accomplish?</td><td width='27%'>What did you actually accomplish?</td><td width='10%'>Size</td><td width='10%'>Effort</td></tr>");
            
            
            ArrayList<Deliverablestatus> del = new ArrayList<Deliverablestatus>();
            del = dsh.getDeliverablestatus(eid);
            for (int i = 0; i < del.size(); i++) {
                sb.append("<tr>");
                sb.append("<td>" + i + 1 );
                sb.append("<td>" + del.get(i).getDeliverables() + "</td>");
                sb.append("<td>" + del.get(i).getPlanToAccomplish() + "</td>");
                sb.append("<td>" + del.get(i).getActualAccomplished() + "</td>");
                sb.append("<td>" + del.get(i).getSize() + "</td>");
                sb.append("<td>" + del.get(i).getEffort() + "</td>");
                sb.append("</tr>");
            }
            sb.append("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr></table><br><br><br>");
            //Lessons Learned  
            
            sb.append("<h2>Lessons Learned Reflection</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO.</td><td width='25%'>Context</td><td width='65%'>Lesson</td></tr>");
          
            ArrayList<Lessons> les = new ArrayList<Lessons>();
            LessonsHelper lh = new LessonsHelper();
            les = lh.getLessons(eid);
            for (int i = 0; i < les.size(); i++) {
                sb.append("<tr>");
                sb.append("<td>" + i + 1 + "</td>");
                sb.append("<td>" + les.get(i).getContext() + "</td>");
                sb.append("<td>" + les.get(i).getLessons() + "</td>");
                sb.append("</tr>");
            }
            sb.append("<tr><td></td><td></td><td></td></tr></table><br><br><br>");
            
            //plans
            
            sb.append("<h2>Plan for the Next Week</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO</td><td width='25%'>Deliverable</td><td width='65%'>What do you intend to accomplish and why</td></tr>");
            ArrayList<Plan> plan = new ArrayList<Plan>();
            PlanHelper ph = new PlanHelper();
            plan = ph.getPlan(eid);
            for (int i = 0; i < plan.size(); i++) {
                sb.append("<tr>");
                sb.append("<td>" + i + 1 + "</td>");
                sb.append("<td>" + plan.get(i).getDeliverable() + "</td>");
                sb.append("<td>" + plan.get(i).getIntendToAccomplish() + "</td>");
                sb.append("</tr>");
            }
            sb.append("<tr><td></td><td></td><td></td></tr></table>");
            
            
            sb.append("</body></html>");
            
            
            htmlWorker.parse(new StringReader(sb.toString()));
            document.close();
            
            file.close();
            response.sendRedirect("pdfs\\"+ua.getEmailId()+"\\"+enbname + ".pdf");
        }
        catch(Exception ex){
            ex.printStackTrace();
            file.close();
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
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(DownloadPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(DownloadPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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

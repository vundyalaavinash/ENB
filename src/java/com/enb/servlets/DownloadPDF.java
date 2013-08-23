/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.MiscClasses.Download;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdfcrowd.Client;
import java.io.ByteArrayOutputStream;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
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
        try {
            
            String html=request.getParameter("htmlcontent");
            String enbname=request.getParameter("selectenb");
            Client client = new Client("hemanth", "62ebd12b355aac3c0020b484bbc92ec9");
            out.println(html);
            FileOutputStream file = new FileOutputStream(new File("E:\\" + enbname + ".pdf"));
          // ByteArrayOutputStream memStream  = new ByteArrayOutputStream();
            
            client.convertHtml(html, file);
          //  Document document = new Document();
           // PdfWriter.getInstance(document, file);

          //  document.open();
          //  HTMLWorker htmlWorker = new HTMLWorker(document);
          //  htmlWorker.parse(new StringReader(html));
            

         //   document.close();
            
            file.close();
            /* TODO output your page here. You may use following sample code. */
           /* HttpSession session=request.getSession();
            String enbname=request.getParameter("selectenb");
            String name=(String)session.getAttribute("name");
            //int uid=Integer.parseInt((String)session.getAttribute("uid"));
            Download d=new Download();
            String path=d.enbPdf(enbname, name,Integer.parseInt(session.getAttribute("uid").toString()));
            out.println(""+path);*/
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.servlets;

import com.enb.Helper.UserLogHelper;
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
 *<p>
 * Title: Search class - A component of the ENB Tool
 * </p>
 * <p>
 * Description: It is an entity class which is used to download the contents from the ENB tool
 * </p>
 *
 * @author B.Revanth
 */
@WebServlet(name = "DownloadPDF", urlPatterns = {"/DownloadPDF"})
// HTTP servlets enable you to send and receive data using an HTML form
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
            String enbname=request.getParameter("selectenb"); //select the enb name 
            Client client = new Client("hemanth", "62ebd12b355aac3c0020b484bbc92ec9");
            out.println(html);
            UserLogHelper uh=new UserLogHelper();
            uh.insertlog(session.getAttribute("uid").toString(),"Download PDF-"+enbname); // maintains log for this download activity
            file = new FileOutputStream(new File("E:\\" + session.getAttribute("uid").toString() +"-"+enbname + ".pdf"));  /* save the file in the given 
                                                                                                                           loc in pdf format */
           
            client.convertHtml(html, file); // convert the content in enb into file
            file.close(); //close the file
        }
        catch(Exception ex){
            file.close(); //close the file even if an exception occurs
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

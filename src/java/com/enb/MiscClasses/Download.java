package com.enb.MiscClasses;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.enb.Helper.EnbdescHelper;
import com.enb.POJO.Deliverablestatus;
import com.enb.POJO.Enbdesc;
import com.enb.POJO.Lessons;
import com.enb.POJO.Notes;
import com.enb.POJO.Plan;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author B.Revanth
 */
public class Download {

    public String enbPdf(String enbname, String name, int uid) throws FileNotFoundException, DocumentException, IOException {
        EnbdescHelper eh1 = new EnbdescHelper();
        Enbdesc enb = eh1.getEnbdescID(Integer.parseInt(enbname));
        System.out.println("name : " + enb.getEnbname());

        Document document = new Document();
        
        
        String path="E:\\" + enbname + ".pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\" + enbname + ".pdf"));
        String usrpas = enbname;
        String ownrpas = enbname;
        writer.setEncryption(usrpas.getBytes(), ownrpas.getBytes(), PdfWriter.AllowPrinting, true);
        document.open();
         //HeaderFooter header = new HeaderFooter(new Phrase("This is page: ", new Font(Font.COURIER)), true);

        //header.setAlignment(Element.ALIGN_CENTER);
        HTMLWorker htmlWorker = new HTMLWorker(document);
        StringBuilder sb = new StringBuilder();
        Paragraph paragraph = new Paragraph();

        Set set = enb.getNoteses();
        Iterator itr = set.iterator();
        PdfPTable table = new PdfPTable(1);
        while (itr.hasNext()) {
            Notes notes = (Notes) itr.next();
            String s = new String(notes.getNotes());
            System.out.println("notes : " + s);
            htmlWorker.parse(new StringReader(s));
            //paragraph.add(s);
            //System.out.println(itr.next());
        }
        Chunk chunk1 = new Chunk("Delivearables");
       
        PdfPTable table1 = new PdfPTable(6);
        table1.addCell("Sno");
        table1.addCell("Deliverables");
        table1.addCell("Plan to accomplish");
        table1.addCell("Acyually Accomplished");
        table1.addCell("Size");
        table1.addCell("Effort");
        Set set1 = enb.getDeliverablestatuses();
        itr = set1.iterator();
        int i = 1;
        while (itr.hasNext()) {

            Deliverablestatus del = (Deliverablestatus) itr.next();
            int j = i;
            String sno = "" + j;
            table1.addCell(sno);
            table1.addCell(del.getDeliverables());
            table1.addCell(del.getPlanToAccomplish());
            table1.addCell(del.getActualAccomplished());
            table1.addCell(del.getSize());
            table1.addCell(del.getEffort());
            i++;
        }
        
        PdfPTable table2 = new PdfPTable(3);
        table2.addCell("Sno");
        table2.addCell("Context");
        table2.addCell("Lessons");
        Set set2 = enb.getLessonses();
        itr = set2.iterator();
        i = 1;
        while (itr.hasNext()) {

            Lessons les = (Lessons) itr.next();
            int j = i;
            String sno = "" + j;
            table2.addCell(sno);
            table2.addCell(les.getContext());
            table2.addCell(les.getLessons());
            i++;
        }


       
        PdfPTable table3 = new PdfPTable(3);
        table3.addCell("Sno");
        table3.addCell("Deliverable");
        table3.addCell("What do you intend to accomplish and why");
        Set set3 = enb.getPlans();
        itr = set3.iterator();
        i = 1;
        while (itr.hasNext()) {
            Plan plan = (Plan) itr.next();
            int j = i;
            String sno = "" + j;
            table3.addCell(sno);
            table3.addCell(plan.getDeliverable());
            table3.addCell(plan.getIntendToAccomplish());
            i++;
        }

       // document.add(ch);
       // document.add(ch1);

        
        document.add(paragraph);
        document.add(chunk1);
        document.add(table1);
        
        document.add(table2);
        
        document.add(table3);
        document.close();
        return path;
    }
}

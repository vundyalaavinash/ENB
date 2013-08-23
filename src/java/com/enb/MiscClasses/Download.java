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
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author B.Revanth
 */
public class Download {
    
    public boolean enbPdf(String enbname,String name,int uid) throws FileNotFoundException, DocumentException
    {
        Document document=new Document();
        PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("E:\\"+enbname+".pdf"));
        String usrpas=enbname;
        String ownrpas=enbname;
        writer.setEncryption(usrpas.getBytes(), ownrpas.getBytes(), PdfWriter.AllowPrinting, true);
        document.open();
        HeaderFooter header=new HeaderFooter(new Phrase("Name : "+name+"\n"+"EnbName : "+enbname), false);
        header.setAlignment(HeaderFooter.ALIGN_CENTER);
        Chunk chunk = new Chunk("Notes");
	Font font = new Font(Font.COURIER);
	font.setStyle(Font.UNDERLINE);
	font.setStyle(Font.ITALIC);
	chunk.setFont(font);
	chunk.setBackground(Color.CYAN);
        Paragraph paragraph = new Paragraph();
        EnbdescHelper eh1=new EnbdescHelper();
        
        Enbdesc enb=eh1.getEnbid(enbname,uid);
        
        Set set=enb.getNoteses();
        Iterator itr = set.iterator();

        while(itr.hasNext())
        {
            Notes notes=(Notes)itr.next();
            paragraph.add(notes.getNotes().toString());
            //System.out.println(itr.next());
        }
       
        
        Chunk chunk1 = new Chunk("Delivearables");
        chunk1.setFont(font);
	chunk1.setBackground(Color.CYAN);
        PdfPTable table1=new PdfPTable(6);
        table1.addCell("Sno");
        table1.addCell("Deliverables");
        table1.addCell("Plan to accomplish");
        table1.addCell("Acyually Accomplished");
        table1.addCell("Size");
        table1.addCell("Effort");
        Set set1=enb.getDeliverablestatuses();
                                          itr = set1.iterator();
                                   int i=1;
                                    while(itr.hasNext())
                                    {
                                        
                                        Deliverablestatus del=(Deliverablestatus)itr.next();
                                        int j=i;
                                String sno=""+j;
                                                            table1.addCell(sno);
                                table1.addCell(del.getDeliverables());
                                table1.addCell(del.getPlanToAccomplish());
                                table1.addCell(del.getActualAccomplished());
                                table1.addCell(del.getSize());
                                table1.addCell(del.getEffort());
                                              i++;
                                    }
       
        
        Chunk chunk2 = new Chunk("Plan");
        chunk2.setFont(font);
	chunk2.setBackground(Color.CYAN);
        PdfPTable table2=new PdfPTable(3);
        table2.addCell("Sno");
        table2.addCell("Context");
        table2.addCell("Lessons");
        Set set2=enb.getLessonses();
                                                  itr = set2.iterator();
                                   i=1;
                                    while(itr.hasNext())
                                    {
                                        
                                        Lessons les=(Lessons)itr.next();
                                        int j=i;
            String sno=""+j;
            table2.addCell(sno);
            table2.addCell(les.getContext());
            table2.addCell(les.getLessons());
                                                      i++;
                                    }
       
        
        Chunk chunk3 = new Chunk("Reflection");
        chunk3.setFont(font);
	chunk3.setBackground(Color.CYAN);
        PdfPTable table3=new PdfPTable(3);
        table3.addCell("Sno");
        table3.addCell("Deliverable");
        table3.addCell("What do you intend to accomplish and why");
        Set set3=enb.getPlans();
                                          itr = set3.iterator();
                                   i=1;
                                    while(itr.hasNext())
                                    {
                                         Plan plan=(Plan)itr.next();
                                        int j=i;
            String sno=""+j;
            table3.addCell(sno);
            table3.addCell(plan.getDeliverable());
            table3.addCell(plan.getIntendToAccomplish());
                                                      i++;
                                    }
       
        document.setHeader(header);
        document.add(chunk);
        document.add(paragraph);
        document.add(chunk1);
        document.add(table1);
        document.add(chunk2);
        document.add(table2);
        document.add(chunk3);
        document.add(table3);
       document.close();
        return true;
    }
}

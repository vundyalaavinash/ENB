/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoup.Jsoup;

/**
 *
 * @author Avinash
 */
public class SearchHelper {
    
    Session session = null;
    public SearchHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public String html2text(String html) {
        return Jsoup.parse(html).text();
    }
    
    public ArrayList<Notes> getAllNotes(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Notes> userinfo = new ArrayList<Notes>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Notes");
            userinfo = (ArrayList<Notes>) q.list();
            return userinfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Notes> Search(String Keyword,int uid){
        String keys[]=Keyword.split(" ");
        ArrayList<Notes> all=getAllNotes();
        ArrayList<Notes> found=new ArrayList<Notes>();
        for(int i=0;i<all.size();i++){
            Notes n=all.get(i);
            String note=new String(n.getNotes());            
            if(n.getEnbdesc().getUserauth().getId()==uid){
                for(int j=0;j<keys.length;j++){
                    String ah=html2text(note);                   
                    if(ah.toLowerCase().contains(keys[j].toLowerCase())){
                        System.out.println("text:"+ah);
                        if(!found.contains(all.get(i))){
                            found.add(all.get(i));
                        }
                    }
                }
            }
        }
        return found;
    }
    
    public String Searching(String keyword,int uid){
        ArrayList<Notes> found=Search(keyword,uid);
        String st="";
        st="<b>"+found.size()+" results</b> Found";
        for(int i=0;i<found.size();i++){
            Notes note=found.get(i);
            Calendar from=Calendar.getInstance();
            Calendar to=Calendar.getInstance();
            from.setTime(note.getEnbdesc().getProject().getFromDate());
            to.setTime(note.getEnbdesc().getProject().getToDate());
            String fd=from.get(Calendar.DATE)+"/"+from.get(Calendar.MONTH)+"/"+from.get(Calendar.YEAR);
            String td=to.get(Calendar.DATE)+"/"+to.get(Calendar.MONTH)+"/"+to.get(Calendar.YEAR);
            st=st+"<table><tr><td width='70%'><a href='viewenbnotes.jsp?eid="+note.getEnbdesc().getId()+"'><h2>"+note.getEnbdesc().getEnbname()+"</h2></a></td>"
                    + "<td width='30%'>Project Duration :&nbsp;&nbsp;<span style='color:#47a3da;'>"+fd+"</span>&nbsp;&nbsp;to &nbsp;&nbsp;"
                    + "<span style='color:#47a3da;'>"+td+"</span></td></tr><tr><td>Project : &nbsp;&nbsp;&nbsp;"+note.getEnbdesc().getProject().getProjectName()+"</td></tr></table><br/><hr><br/>";
        }
        return st;
    }
}

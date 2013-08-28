/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Avinash
 */
public class NotesHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public boolean insertNotes (Notes notes){
         try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(notes);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateNotes (Notes notes){
        return false;
    }
    
    public boolean removeNotes (int eid){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("delete from Notes where ENBID="+eid+"");
            int result = q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Notes getNotes (int pid,Date from,Date to){
        return null;
    }
    public ArrayList<Notes> getNotes (int pid){
        return null;
    }
    
    public String constuctCrossThrough (String text){
        return "";
    }
    
    public String constuctHyperLink (String url){
        return "";
    }
    
    public String colorText (String text){
        return "";
    }    
}

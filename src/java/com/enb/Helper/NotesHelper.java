/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
/**
 *
 * @author Avinash
 */
public class NotesHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public boolean insertNotes (Notes notes){
        return false;
    }
    
    public boolean updateNotes (Notes notes){
        return false;
    }
    
    public boolean removeNotes (Notes notes){
        return false;
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

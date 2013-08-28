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
 * <p> Title: NotesHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations of notes of enb on database i.e., inserting, retrieving and
 * deleting the notes of enb of specified user id or enb id or email</p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 * @version 1.00
 */
public class NotesHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    /**
     * inserts the enb notes in the database
     *
     * @param notes The notes reference to access the notes
     * @return true if save or update is successful else false
     */
    public boolean insertNotes(Notes notes) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();                   // load the connection for the given session
            session.saveOrUpdate(notes);                // code for inserting or updating the notes
            System.out.println("this is query : \t" + trans.toString());
            trans.commit();                         // database is updated
            return true;
        }// catches if any exception in updating the enb notes in the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * class which does nothing
     *
     * @param notes
     * @return
     */
    public boolean updateNotes(Notes notes) {
        return false;
    }

    /**
     * deletes the enb notes from the lesson table
     *
     * @param eid The enb id
     * @return true if required enb notes is deleted successfully otherwise
     * false
     */
    public boolean removeNotes(int eid) {
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();                // load the connection for the given session
            Query q = session.createQuery("delete from Notes where ENBID=" + eid + "");    // query for deleting the required notes details using eid
            int result = q.executeUpdate();         // database is updated
            session.flush();
            return true;
        }// catches if any exception in deleting the enb notes in the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * class which does nothing
     *
     * @param pid
     * @return
     */
    public String getNotes(int eid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Notes> userinfo = new ArrayList<Notes>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Notes where ENBID="+eid);
            userinfo = (ArrayList<Notes>) q.list();
            if(userinfo.size()==1)
            {
                String str=new String(userinfo.get(0).getNotes());
            return str; 
            }
             return "No Notes";          
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Notes> getNote(int eid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Notes> userinfo = new ArrayList<Notes>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Notes where ENBID="+eid);
            userinfo = (ArrayList<Notes>) q.list();
            return userinfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * class which does nothing
     *
     * @param text
     * @return
     */
    public String constuctCrossThrough(String text) {
        return "";
    }

    /**
     * class which does nothing
     *
     * @param url
     * @return
     */
    public String constuctHyperLink(String url) {
        return "";
    }

    /**
     * class which does nothing
     *
     * @param text
     * @return
     */
    public String colorText(String text) {
        return "";
    }
}

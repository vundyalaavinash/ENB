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
 * <p> Title: LessonsHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations of lessons on database i.e., inserting, retrieving and deleting
 * the lessons of enb for a specified user id or enb id or email</p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 * @version 1.00
 */
public class LessonsHelper {

    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
        
    /**
     * inserts the enb lessons in the database
     *
     * @param lessons The Lessons reference to access the Lessons
     * @return true if save or update is successful else false
     */
    public boolean insertLessons(Lessons lessons) {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            // load the connection for the given session
            Transaction trans = session.beginTransaction();
            // code for inserting or updating the lessons
            session.saveOrUpdate(lessons);
            trans.commit();                 // database is updated
            session.flush();
            return true;
        } // catches if any exception in updating the enb lessons in the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * deletes the enb lesson from the lesson table
     *
     * @param eid The enb id
     * @return true if required enb lesson is deleted successfully otherwise
     * false
     */
    public boolean deleteLessons(int eid) {
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            // load the connection for the given session
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("delete from Lessons where ENBID="+eid+"");
            int result = q.executeUpdate();           
            session.flush();
            return true;                  //returns true if deletes successfully
        } // catches if any exception in deleting the enb lessons in the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();   // session is closed
        }
    }
    
    public ArrayList<Lessons> getLessons(int eid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Lessons> userinfo = new ArrayList<Lessons>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Lessons where ENBID="+eid);
            userinfo = (ArrayList<Lessons>) q.list();
            return userinfo;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    /**
     * class which does nothing
     *
     * @param lessons
     * @return
     */
    public boolean updateLessons(Lessons lessons) {
        return false;
    }

    /**
     * class which does nothing
     *
     * @param id
     * @param to
     * @param From
     * @return
     */
    public ArrayList<Lessons> getLessons(String id, Date to, Date From) {
        return null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.Groups;
import com.enb.POJO.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Avinash
 */


public class GroupHelper {
    
    Session session =  null;
    
    public boolean insertGroup(Groups group){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            // load the connection for the given session
            Transaction trans = session.beginTransaction();
            // code for inserting the enb details
            session.saveOrUpdate(group);
            trans.commit();
            return true;
        } // catches if any exception in updating the enb in the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            session.close();
        }
    }
    
    
    public boolean deleteGroup(Groups group){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            // load the connection for the given session
            Transaction trans = session.beginTransaction();
            // code for inserting the enb details
            session.delete(group);
            trans.commit();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            session.close();
        }
    }
    
    public boolean removeAllInGroups(int mid) {
        this.session = HibernateUtil.getSessionFactory().openSession();          // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        try {
            Transaction tx = session.beginTransaction();                                // load the connection for the given session
            // query for deleting the required enb deliverables
            // Query instance is obtained
            Query q = session.createQuery("delete from Groups where MID=" + mid + "");
            int result = q.executeUpdate();                                             // changes updated in database
            tx.commit();
            return true;
        } // catches if any exception in deleting the enb in database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
            session.close();
        }
    }
    
    public ArrayList<Groups> getAllGroups(int mid) {
        this.session = HibernateUtil.getSessionFactory().openSession();          // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        try {
            Transaction tx = session.beginTransaction();                                // load the connection for the given session
            Query q = session.createQuery("from Groups where MID=" + mid + "");
            ArrayList<Groups> result =(ArrayList<Groups>) q.list();                                             // changes updated in database
            tx.commit();
            return result;
        } // catches if any exception in deleting the enb in database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }
    
    
    
}

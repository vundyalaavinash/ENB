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
 * <p> Title: DeliverablesHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations of deliverables on database i.e., inserting, retrieving and
 * deleting the deliverables of enb for a specified user id or enb id or email
 * </p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 * @version 1.00
 */
public class DeliverablesHelper {

    /**
     * This is the class attribute Create the SessionFactory from standard
     * (hibernate.cfg.xml) config file
     */
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /**
     * class which does nothing
     *
     * @param pid The project id
     * @param to The project to date
     * @param From The project from date
     * @return the deliverables objects in an Arraylist
     */
    public ArrayList<Deliverablestatus> getDeliverablestatus(String pid, Date to, Date From) {
        return null;
    }

    /**
     * updates the required enb deliverables in deliverablestatus table by
     * inserting or updating the rows
     *
     * @param ds The Deliverablestatus reference to access the Deliverablestatus
     * @return true if deliverables is saved or update else false if it fails or
     * any exception occurs
     */
    public boolean insertDeliverablestatus(Deliverablestatus ds) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();                             // load the connection for the given session
            // code for inserting or updating the deliverables
            session.saveOrUpdate(ds);
            trans.commit();                                                             // database is updated
            return true;
        } // catches if any exception in updating the enb in the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
<<<<<<< HEAD
    
    public ArrayList<Deliverablestatus> getDeliverablestatus(int eid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Deliverablestatus> userinfo = new ArrayList<Deliverablestatus>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Deliverablestatus where ENBID="+eid);
            userinfo = (ArrayList<Deliverablestatus>) q.list();
            return userinfo;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean removeDeliverablestatus(int eid){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("delete from Deliverablestatus where ENBID="+eid);
            int result = q.executeUpdate();
            System.out.println(eid+":"+result);
=======

    /**
     * deletes the required enb deliverables from deliverablestatus table
     *
     * @param eid The enb id
     * @return true if deliverables is deleted else false if it fails or any
     * exception occurs
     */
    public boolean removeDeliverablestatus(int eid) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();           // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        try {
            Transaction tx = session.beginTransaction();                                // load the connection for the given session
            // query for deleting the required enb deliverables
            // Query instance is obtained
            Query q = session.createQuery("delete from Deliverablestatus where ENBID=" + eid + "");
            int result = q.executeUpdate();                                             // changes updated in database
            System.out.println(eid + ":" + result);
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
            return true;
        } // catches if any exception in deleting the enb in database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * class which does nothing
     *
     * @param ds
     * @return
     */
    public boolean updateDeliverablestatus(Deliverablestatus ds) {
        return false;
    }
}

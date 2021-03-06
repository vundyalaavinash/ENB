/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.*;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <p> Title: EnbdescHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations enb details on database i.e., inserting, retrieving and deleting
 * the details of enb for a specified user id or enb id or email or project
 * id</p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 * @version 1.00
 */
public class EnbdescHelper {
    
    Session session =  null;
       
    /**
     * inserts the new enb details in enbdesc table in database
     *
     * @param enbdes The Enbdesc reference to access the Enbdesc
     * @return true if enb details is saved else false if it fails or any
     * exception occurs
     */
    public boolean insertEnbdesc(Enbdesc enbdes) {
        /**
     * This is the class attribute Create the SessionFactory from standard
     * (hibernate.cfg.xml) config file
     */
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            // load the connection for the given session
            Transaction trans = session.beginTransaction();
            // code for inserting the enb details
            session.save(enbdes);
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

    /**
     * retrieves the enb details from enbdesc table
     *
     * @param pid The project id
     * @return the list of Enbdesc references otherwise null
     */
    public ArrayList<Enbdesc> getEnbdesc(int pid) {
        session = HibernateUtil.getSessionFactory().openSession();
        // creates the Arraylist of Enbdesc reference type
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();     // arraylist which stores instances of Enbdesc class
        try {
            // load the connection for the given session
            org.hibernate.Transaction tx = session.beginTransaction();
            // query for retrieving  the required enb details using pid
            Query q = session.createQuery("from Enbdesc where PID='" + pid + "'");     //Query instance is obtained
            userinfo = (ArrayList<Enbdesc>) q.list();                               //list of instances are stored in arraylist
            tx.commit();
            return userinfo;
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }

    }    
    
    public ArrayList<Enbdesc> getEnbdesc2(int uid) {
        session = HibernateUtil.getSessionFactory().openSession();
        // creates the Arraylist of Enbdesc reference type
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();     // arraylist which stores instances of Enbdesc class
        try {
            // load the connection for the given session
            org.hibernate.Transaction tx = session.beginTransaction();
            // query for retrieving  the required enb details using pid
            Query q = session.createQuery("from Enbdesc where UID="+ uid +"");     //Query instance is obtained
            userinfo = (ArrayList<Enbdesc>) q.list();                               //list of instances are stored in arraylist
            tx.commit();
            return userinfo;
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }

   /*  * retrieves the enb details from enbdesc table
     *
     * @param pid The project id
     * @return the Enbdesc instance otherwise null
     */
    public Enbdesc getEnbdescPID(int pid) {
        session = HibernateUtil.getSessionFactory().openSession();
        // creates the Arraylist of Enbdesc reference type
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();
        try {
            // load the connection for the given session
            org.hibernate.Transaction tx = session.beginTransaction();
            // query for retrieving  the required enb details using pid
            Query q = session.createQuery("from Enbdesc where PID='" + pid + "' and Todate>=curdate()");   //Query instance is obtained
            userinfo = (ArrayList<Enbdesc>) q.list();       //list of instances are stored in arraylist
            // checks the size of arraylist whether the enb details are available for the given pid or not.
            tx.commit();
            if (userinfo.size() > 0) {
                return userinfo.get(0);         // if true then returns the enbdesc reference
            } else {
                return null;                    // otherwise return null
            }
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }

    
    /**
     * retrieves the enb details from enbdesc table
     *
     * @param pid The project id
     * @return the Enbdesc instance otherwise null
     */

    public ArrayList<Enbdesc> getEnbdescUID(int uid) {
        session = HibernateUtil.getSessionFactory().openSession();
        // creates the Arraylist of Enbdesc reference type
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();
        try {
            // load the connection for the given session
            org.hibernate.Transaction tx = session.beginTransaction();
            // query for retrieving  the required enb details using pid
            Query q = session.createQuery("from Enbdesc where UID='" + uid + "' and Todate>=curdate()");   //Query instance is obtained
            userinfo = (ArrayList<Enbdesc>) q.list();       //list of instances are stored in arraylist
            // checks the size of arraylist whether the enb details are available for the given pid or not.      
            tx.commit();
            return userinfo;         // if true then returns the enbdesc reference
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }


    /**
     *
     * @param eid The enb id
     * @return the Enbdesc instance otherwise null
     */
    public Enbdesc getEnbdescID(int eid) {
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Enbdesc> enbinfo = new ArrayList<Enbdesc>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Enbdesc where ID='" + eid + "'");          //Query instance is obtained
            enbinfo = (ArrayList<Enbdesc>) q.list();        //list of instances are stored in arraylist
            tx.commit();
            if (enbinfo.size() == 1) {                          // checks the size of arraylist is 1 or not
                return enbinfo.get(0);                      // if 1 then returns the 1st instance of enbdesc from the arraylist
            }
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
        return null;
    }

    /**
     * retrieves the enb details from enbdesc table based on the enbname and
     * user id
     *
     * @param enbname The enb name
     * @param uid The user id
     * @return the Enbdesc instance otherwise null
     */
    public Enbdesc getEnbid(String enbname, int uid) {
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Enbdesc> enbinfo = new ArrayList<Enbdesc>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Enbdesc where enbname='" + enbname + "' and uid='" + uid + "'");       //Query instance is obtained
            enbinfo = (ArrayList<Enbdesc>) q.list();            //list of instances are stored in arraylist
            tx.commit();
            if (enbinfo.size() == 1) {                              // checks the size of arraylist is 1 or not
                return enbinfo.get(0);                          // if 1 then returns the 1st instance of enbdesc from the arraylist
            }
        } // catches if any exception in retrieving the enb from the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
        return null;
    }
    
}

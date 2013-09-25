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
 * <p> Title: PlanHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations on database </p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 * @version 1.00
 */
public class PlanHelper {
    // Create the SessionFactory from standard (hibernate.cfg.xml) config file

    Session session = null;


    /**
     * inserts the enb plan in the database
     *
     * @param plan The plan reference to access the plan
     * @return true if save or update is successful else false
     */
    public String insertPlan(Plan plan) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();               // load the connection for the given session
            session.saveOrUpdate(plan);                // code for inserting or updating the plan
            trans.commit();                           // database is updated
            return "true";
        }// catches if any exception in updating the enb plan in the database or loading the connection for session
        catch (Exception ex) {
           return ex.getMessage();
        }
        finally{
            session.close();
        }
    }


    /**
     * deletes the enb plan from the lesson table
     *
     * @param eid The enb id
     * @return true if required enb plan is deleted successfully otherwise false
     */
    public boolean removePlan(int eid) {
        this.session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        try {
            Transaction tx = session.beginTransaction();                // load the connection for the given session
            Query q = session.createQuery("delete from Plan where ENBID=" + eid + "");  // query for deleting the required plan details using eid
            int result = q.executeUpdate();
            tx.commit();
            return true;
        }// catches if any exception in deleting the enb plan in the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
            session.close();
        }
    } 
    
    public ArrayList<Plan> getPlan(int eid){
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Plan> userinfo = new ArrayList<Plan>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Plan where ENBID="+eid);
            userinfo = (ArrayList<Plan>) q.list();
            tx.commit();
            return userinfo;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    } 
    
}

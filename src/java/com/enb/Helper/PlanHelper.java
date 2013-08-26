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

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /**
     * class which does nothing
     *
     * @param pid
     * @param to
     * @param from
     * @return
     */
    public ArrayList<PlanHelper> getPlan(int pid, Date to, Date from) {
        return null;
    }

    /**
     * inserts the enb plan in the database
     *
     * @param plan The plan reference to access the plan
     * @return true if save or update is successful else false
     */
    public boolean insertPlan(Plan plan) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();               // load the connection for the given session
            session.saveOrUpdate(plan);                // code for inserting or updating the plan
            trans.commit();                           // database is updated
            return true;
        }// catches if any exception in updating the enb plan in the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * class which does nothing
     *
     * @param plan
     * @return
     */
    public boolean updatePlan(Plan plan) {
        return false;
    }

    /**
     * deletes the enb plan from the lesson table
     *
     * @param eid The enb id
     * @return true if required enb plan is deleted successfully otherwise false
     */
    public boolean removePlan(int eid) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        try {
            Transaction tx = session.beginTransaction();                // load the connection for the given session
            Query q = session.createQuery("delete from Plan where ENBID=" + eid + "");  // query for deleting the required plan details using eid
            int result = q.executeUpdate();
            return true;
        }// catches if any exception in deleting the enb plan in the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

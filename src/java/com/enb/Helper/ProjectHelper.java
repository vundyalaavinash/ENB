/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.HibernateUtil;
import com.enb.POJO.Project;
import com.enb.POJO.Userauth;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <p> Title: ProjectHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations of project details on database i.e., inserting, retrieving and
 * deleting the details of project of specified user id or enb id or email or
 * project id</p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 */
public class ProjectHelper {
    Session session = null;
        
    /**
     * retrieves projects from database for a given user id
     *
     * @param uid The user id
     * @return the project instances in an Arraylist
     */
    public ArrayList<Project> getProject(int uid) {
        session = HibernateUtil.getSessionFactory().openSession();           // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();             // arraylist which stores instances of project class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where UID='" + uid + "' and Todate>=curdate()");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();                       //list of instances are stored in arraylist
            tx.commit();
            return userinfo;                // returns list of instances
        }// catches if any exception in retrieving the projects in the database or loading the connection for session
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
     * retrieves projects from database for a given user id and project name
     *
     * @param uid The user id
     * @param ProjectName The project name
     * @return instance of project
     */
    public Project getProject(int uid, String ProjectName) {
        session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();             // arraylist which stores instances of project class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where UID='" + uid + "' and ProjectName='" + ProjectName + "'");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();           //list of instances are stored in arraylist
            tx.commit();
            if (userinfo.size() != 0) {
                return userinfo.get(0);
            }
        } // catches if any exception in retrieving the projects from the database or loading the connection for session
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
     * retrieves projects from database for a given user id
     *
     * @param uid The user id
     * @return the project instances
     */
    public Project getProjectID(int uid) {
        session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();                 // arraylist which stores instances of project class
        try {
            org.hibernate.Transaction tx = session.beginTransaction(); 
            Query q = session.createQuery ("from Project where UID='"+uid+"' ORDER BY Id DESC");
            userinfo = (ArrayList<Project>) q.list();
            tx.commit();
            if(userinfo.size()!=0){
                return (userinfo.get(0));            
            } else {
                return null;
            }
        } // catches if any exception in retrieving the projects from the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }

    /**
     * retrieves projects from database for a given project id
     *
     * @param pid
     * @return the project instances
     */
    public Project getProjectPID(int pid) {
        session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();         // arraylist which stores instances of project class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where ID='" + pid + "'");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();       //list of instances are stored in arraylist
            tx.commit();
            if (userinfo.size() != 0) {
                return (userinfo.get(0));
            } else {
                return null;
            }
        }// catches if any exception in retrieving the projects from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }      
    /**
     * inserting the project details
     *
     * @param project The Project reference to access the Project
     * @return true if inserted project details is successful else false
     */
    public boolean insertProject(Project project) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();       // load the connection for the given session
            session.save(project);              //code for inserting the details in 
            trans.commit();                 // database is updated            
            return true;
        }// catches if any exception in inserting the projects into the database or loading the connection for session 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            session.close();
        }
    }
}

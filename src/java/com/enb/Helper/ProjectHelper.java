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
<<<<<<< HEAD
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    
    public ArrayList<Project> getProject (int uid){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        
        ArrayList<Project> userinfo = new ArrayList<Project>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();                      
            Query q = session.createQuery ("from Project where UID='"+uid+"' and Todate>=curdate()");            
            userinfo = (ArrayList<Project>) q.list();
            
            return userinfo;            
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
=======
    // Create the SessionFactory from standard (hibernate.cfg.xml) config file

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /**
     * retrieves projects from database for a given user id
     *
     * @param uid The user id
     * @return the project instances in an Arraylist
     */
    public ArrayList<Project> getProject(int uid) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();           // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();             // arraylist which stores instances of project class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where UID='" + uid + "' and Todate>=curdate()");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();                       //list of instances are stored in arraylist
            return userinfo;                // returns list of instances
        }// catches if any exception in retrieving the projects in the database or loading the connection for session
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
            e.printStackTrace();
            return null;
        }
    }
<<<<<<< HEAD
    
    public Project getProject (int uid, String ProjectName){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();        
        ArrayList<Project> userinfo = new ArrayList<Project>();
=======

    /**
     * retrieves projects from database for a given user id and project name
     *
     * @param uid The user id
     * @param ProjectName The project name
     * @return instance of project
     */
    public Project getProject(int uid, String ProjectName) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();             // arraylist which stores instances of project class
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where UID='" + uid + "' and ProjectName='" + ProjectName + "'");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();           //list of instances are stored in arraylist
            if (userinfo.size() != 0) {
                return userinfo.get(0);
            }
        } // catches if any exception in retrieving the projects from the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
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
        session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();                 // arraylist which stores instances of project class
        try {
<<<<<<< HEAD
            org.hibernate.Transaction tx = session.beginTransaction(); 
            Query q = session.createQuery ("from Project where UID='"+uid+"' ORDER BY Id DESC");
            userinfo = (ArrayList<Project>) q.list();
            if(userinfo.size()!=0){
=======
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where UID='" + uid + "' ORDER BY Id DESC");    //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();           //list of instances are stored in arraylist
            if (userinfo.size() != 0) {
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
                return (userinfo.get(0));
            } else {
                return null;
            }
        } // catches if any exception in retrieving the projects from the database or loading the connection for session
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * retrieves projects from database for a given project id
     *
     * @param pid
     * @return the project instances
     */
    public Project getProjectPID(int pid) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Project> userinfo = new ArrayList<Project>();         // arraylist which stores instances of project class
        try {
<<<<<<< HEAD
            org.hibernate.Transaction tx = session.beginTransaction();
            session.clear(); 
            Query q = session.createQuery ("from Project where ID='"+pid+"'");
            userinfo = (ArrayList<Project>) q.list();
            if(userinfo.size()!=0){
=======
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Project where ID='" + pid + "'");   //Query instance is obtained
            userinfo = (ArrayList<Project>) q.list();       //list of instances are stored in arraylist
            if (userinfo.size() != 0) {
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
                return (userinfo.get(0));
            } else {
                return null;
            }
        }// catches if any exception in retrieving the projects from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
<<<<<<< HEAD
    
    public boolean insertProject(Project project){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(project);
            trans.commit();
            session.flush();
=======

    /**
     * inserting the project details
     *
     * @param project The Project reference to access the Project
     * @return true if inserted project details is successful else false
     */
    public boolean insertProject(Project project) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();       // load the connection for the given session
            session.save(project);              //code for inserting the details in database
            System.out.println("this is query : \t" + trans.toString());
            trans.commit();                 // database is updated
>>>>>>> d47e1b0fa0eced3e0ae5868adfacb974aa538ab4
            return true;
        }// catches if any exception in inserting the projects into the database or loading the connection for session 
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
    public boolean updateProject(ProjectHelper plan) {
        return false;
    }

    /**
     * class which does nothing
     *
     * @param plan
     * @return
     */
    public boolean removeProject(ProjectHelper plan) {
        return false;
    }
}

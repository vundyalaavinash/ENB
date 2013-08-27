/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.*;
import javax.mail.internet.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * <p> Title: RegistrationHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to control the
 * operations of user details on database i.e., inserting, retrieving and
 * deleting the user details. retrieving of details is for specified email</p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 */
public class RegistrationHelper {

    Session session = null;

    /**
     * default class which initializes session
     */
    public RegistrationHelper() {
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * retrieves userauth instance for given email id
     *
     * @param email The email id
     * @return instance of userauth
     */
    public Userauth ValidateUser(String email) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();               // arraylist which stores instances of Userauth class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();      // load the connection for the given session
            Query q = session.createQuery("from Userauth where emailId='" + email + "'");  //Query instance is obtained
            userinfo = (ArrayList<Userauth>) q.list();      //list of instances are stored in arraylist
            // checks the size of arraylist whether the user details are available for the given email or not.
            if (userinfo.size() == 1) {
                return userinfo.get(0);             // if true then returns the userauth reference
            } else {
                return null;
            }
        }// catches if any exception in retrieving the user details from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * class which does nothing
     *
     * @param uauth
     * @return
     */
    public boolean CheckEmail(Userauth uauth) {
        return false;
    }

    /**
     * inserts the user details into the database
     *
     * @param uauth The Userauth reference to access the Userauth
     * @return
     */
    public boolean insertUserauth(Userauth uauth) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();       // load the connection for the given session
            session.save(uauth);                //code for inserting the details in database
            System.out.println("this is query : \t" + trans.toString());
            trans.commit();         // database is updated
            return true;
        }// catches if any exception in inserting the user details into the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * updates the user details into the database
     *
     * @param uauth The Userauth reference to access the Userauth
     * @return true if updated user details is successful else false
     */
    public boolean updateUserauth(Userauth uauth) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            Transaction trans = session.beginTransaction();           // load the connection for the given session
            session.update(uauth);              //code for updating the details in database
            System.out.println("this is query : \t" + trans.toString());
            trans.commit();             // database is updated
            return true;
        }// catches if any exception in updating the user details into the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * changes the password of the user
     *
     * @param uauth The Userauth reference to access the Userauth
     * @return true if updated user details is successful else false
     */
    public boolean changePassword(Userauth uauth) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();  // Create the SessionFactory from standard (hibernate.cfg.xml) config file
            session = sessionFactory.openSession();
            Transaction trans = session.beginTransaction();           // load the connection for the given session
            session.update(uauth);          //code for updating the details in database
            System.out.println("this is query : \t" + trans.toString());
            trans.commit();         // database is updated
            return true;
        }// catches if any exception in updating the user details into the database or loading the connection for session
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param uauth
     * @return
     */
    public boolean forgotPassword(Userauth uauth) {
        return false;
    }

    public Userauth getUserauth(String email) {
        return null;
    }

    /**
     * retrieves the user details for a given email and password
     *
     * @param email The email id
     * @param Password The password
     * @return the userauth instance for given email and password
     */
    public Userauth getUserauth(String email, String Password) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();   // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();               // arraylist which stores instances of Userauth class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();          // load the connection for the given session
            Query q = session.createQuery("from Userauth where emailId='" + email + "' and password='" + Password + "'");  //Query instance is obtained
            userinfo = (ArrayList<Userauth>) q.list();      //list of instances are stored in arraylist
            // checks the size of arraylist whether the user details are available for the given email and password or not.
            if (userinfo.size() == 1) {
                return userinfo.get(0);
            }
        }// catches if any exception in retrieving the user details from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * retrieves the user details for a given email
     *
     * @param email The email id
     * @return the userauth instance for a given email
     */
    public Userauth getUserId(String email) {
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();            // arraylist which stores instances of Userauth class
        Transaction tx = session.beginTransaction();             // load the connection for the given session
        Query q = session.createQuery("from Userauth where emailId='" + email + "'");   //Query instance is obtained
        userinfo = (ArrayList<Userauth>) q.list();       //list of instances are stored in arraylist
        // checks the size of arraylist whether the user details are available for the given email or not.
        if (userinfo.size() != 0) {
            return userinfo.get(0);
        }
        return null;
    }

    /**
     * retrieves the password of the user for a given email
     *
     * @param email The email id
     * @return the password for the given email
     */
    public String getPassword(String email) {
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();           // arraylist which stores instances of Userauth class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();          // load the connection for the given session
            Query q = session.createQuery("from Userauth where emailId='" + email + "'");  //Query instance is obtained
            userinfo = (ArrayList<Userauth>) q.list();      //list of instances are stored in arraylist
            // checks the size of arraylist whether the user details are available for the given email or not.
            if (userinfo.size() == 1) {
                return userinfo.get(0).getPassword();
            }
        }// catches if any exception in retrieving the user details from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public ArrayList<Userauth> getMentors()
    {
        ArrayList<Userauth> mentorinfo = new ArrayList<Userauth>();
         Transaction tx = session.beginTransaction();             // load the connection for the given session
        Query q = session.createQuery("from Userauth where userrole='mentor'");   //Query instance is obtained
        mentorinfo = (ArrayList<Userauth>) q.list();
        if(mentorinfo.size()!=0)
            return mentorinfo;
        return null;
    }
    public ArrayList<Userauth> getNames(int uid)
    {
        ArrayList<Userauth> names = new ArrayList<Userauth>();
        Transaction tx = session.beginTransaction();             // load the connection for the given session
        Query q = session.createQuery("from Userauth where mentoring="+uid);   //Query instance is obtained
        names = (ArrayList<Userauth>) q.list();
        if(names.size()!=0)
            return names;
        return null;
        
    }
    public Userauth getDetails(int uid)
    {
        ArrayList<Userauth> names = new ArrayList<Userauth>();
        Transaction tx = session.beginTransaction();             // load the connection for the given session
        Query q = session.createQuery("from Userauth where id="+uid);   //Query instance is obtained
        names = (ArrayList<Userauth>) q.list();
        if(names.size()!=0)
            return names.get(0);
        return null;
    }
}

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
 *
 * <p>
 * Title: RegistrationHelper Class - A component of the ENB Tool 
 * </p>
 * 
 * <p>
 * Description: controller class that is used to control operations on the database
 * </p>
 * 
 * @author Avinash
 */

public class RegistrationHelper {
    Session session = null;
    /**
     * default constructor which is used to create a session
     */
    public RegistrationHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    } 
    /**
     * 
     * @param email takes the email id of the user
     * @return the userinfo if the email id is valid
     */    
    public Userauth ValidateUser(String email){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();     // storing the user details in an array 
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userauth where emailId='"+email+"'");  //  
            userinfo = (ArrayList<Userauth>) q.list();
            if(userinfo.size()==1){
                return userinfo.get(0);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean CheckEmail(Userauth uauth){
        return false;
    }
    /**
     * 
     * @param uauth contains all the details of the user
     * @return true if the details are saved successfully to the database
     */
    public boolean insertUserauth(Userauth uauth){        
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(uauth);            // save the user details
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        } 
    }
    /**
     * 
     * @param uauth
     * @return 
     */
    public boolean updateUserauth (Userauth uauth){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.update(uauth);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    } 
    /**
     * 
     * @param uauth
     * @return 
     */
    public boolean changePassword (Userauth uauth){
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.update(uauth);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean forgotPassword (Userauth uauth){
        return false;
    }
    public Userauth getUserauth (String email){
        return null;
    }
    /**
     * 
     * @param email 
     * @param Password
     * @return 
     */
    public Userauth getUserauth (String email,String Password){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userauth where emailId='"+email+"' and password='"+Password+"'");
            userinfo = (ArrayList<Userauth>) q.list();
            if(userinfo.size()==1){
                return userinfo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
        return null;
    } 
    /**
     * 
     * @param email
     * @return 
     */
    public Userauth getUserId(String email)
    {
       ArrayList<Userauth> userinfo = new ArrayList<Userauth>();
       Transaction tx = session.beginTransaction();
       Query q = session.createQuery ("from Userauth where emailId='"+email+"'");
       userinfo = (ArrayList<Userauth>) q.list();
       if(userinfo.size()!=0){
                return userinfo.get(0);
            }
        return null; 
    }
    /**
     * 
     * @param email
     * @return 
     */
     public String getPassword(String email){
        ArrayList<Userauth> userinfo = new ArrayList<Userauth>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userauth where emailId='"+email+"'");
            userinfo = (ArrayList<Userauth>) q.list();
            if(userinfo.size()==1){
                return userinfo.get(0).getPassword();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
<<<<<<< HEAD
        }        
=======
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
        return names;
        
    }
    public Userauth getDetails(int uid)
    {
        ArrayList<Userauth> names = new ArrayList<Userauth>();
        Transaction tx = session.beginTransaction();             // load the connection for the given session
        Query q = session.createQuery("from Userauth where id="+uid);   //Query instance is obtained
        names = (ArrayList<Userauth>) q.list();
        if(names.size()!=0)
            return names.get(0);
>>>>>>> fa12f8528339e7fdbdd5f48ebd0eeab1ae97b5d5
        return null;
    }
}

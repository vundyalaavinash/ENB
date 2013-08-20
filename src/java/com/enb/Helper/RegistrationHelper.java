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
 * @author Avinash
 */
public class RegistrationHelper {
    Session session = null;
    public RegistrationHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    } 
        
    public boolean ValidateUser(String email){
        return false;
    }
    public boolean CheckEmail(Userauth uauth){
        return false;
    }
    public boolean insertUserauth(Userauth uauth){        
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(uauth);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        } 
    }
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
    public Userauth getUserauth (String email,String Password){
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
}

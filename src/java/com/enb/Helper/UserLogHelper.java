/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.HibernateUtil;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * <p>
 * Title: UserLogHelper class - A component of the ENB Tool
 * </p>
 * <p>
 * Description: It is an controller class which is used to log user activities to the database 
 * </p>
 * 
 * @author Avinash
 */

public class UserLogHelper {
    Session session = null;
    /**
     * constructor- UserLogHelper
     * 
     */
    public UserLogHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /**
     * method- insertlog
     * It is used to save activities of user based on user id and description
     * @param uid
     * @param Description 
     */
    public void insertlog(String uid,String Description){
        Userlog log=new Userlog();      
        log.setUid(""+uid);
        Calendar cal=Calendar.getInstance();
        log.setLogDt(cal.getTime());
        log.setDescription(Description);
        insertUserlog(log);
    }
    /**
     * method- insertUserlog
     * It is used to insert the log details of the user
     * @param log- reference to the userlog class
     * @return true if log saved successfully (else)
     * @return false 
     * 
     */
    public boolean insertUserlog(Userlog log){        
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(log); //save the log details of the user
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        } 
    }     
    /**
     * method- getUserlogs
     * It is uses to display log details of the user based on user id and date
     * @param uid
     * @param cal
     * @return all the activities of the user on the selected date
     */
    public ArrayList<Userlog> getUserlogs (int uid,String cal){
        ArrayList<Userlog> userinfo = new ArrayList<Userlog>();   // arraylist is used to maintain userlog
        try {
            
            String h[]=cal.split("/");
            String a1=h[2]+"-"+h[1]+"-"+h[0]+" 00:00:00";
            String a2=h[2]+"-"+h[1]+"-"+h[0]+" 23:59:59";
            System.out.print("\n"+a1);
            System.out.print("\n"+a2);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userlog where uid='"+uid+"' and LogDT>='"+a1+"' and LogDt<='"+a2+"'");
            userinfo = (ArrayList<Userlog>) q.list();  //get all the activities of user for the given date
            return userinfo; //returns user logs
        } catch (Exception e) {
            e.printStackTrace();
            return null;   //return an exception 
        }        
    } 
    
}

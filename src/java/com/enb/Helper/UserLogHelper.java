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
 * @author Avinash
 */
public class UserLogHelper {
    Session session = null;
    
    public void insertlog(String uid,String Description){
        Userlog log=new Userlog();      
        log.setUid(""+uid);
        Calendar cal=Calendar.getInstance();
        log.setLogDt(cal.getTime());
        log.setDescription(Description);
        insertUserlog(log);
    }
    
    public boolean insertUserlog(Userlog log){        
        this.session = HibernateUtil.getSessionFactory().openSession();
        try{
            
            Transaction trans=session.beginTransaction();
            session.save(log);
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        } 
        finally{
            session.close();
        }
    }     
    
    public ArrayList<Userlog> getUserlogs (int uid,String cal){
        this.session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Userlog> userinfo = new ArrayList<Userlog>();
        try {
            
            String h[]=cal.split("/");
            String a1=h[2]+"-"+h[1]+"-"+h[0]+" 00:00:00";
            String a2=h[2]+"-"+h[1]+"-"+h[0]+" 23:59:59";
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userlog where uid='"+uid+"' and LogDT>='"+a1+"' and LogDt<='"+a2+"'");
            userinfo = (ArrayList<Userlog>) q.list();
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

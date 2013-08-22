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
    public UserLogHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void insertlog(int uid,String Description){
        Userlog log=new Userlog();      
        UserlogId usid=new UserlogId();
        usid.setUid(uid);
        Calendar cal=Calendar.getInstance();
        usid.setLogDt(cal.getTime());
        log.setId(usid);
        log.setDescription(Description);
        insertUserlog(log);
    }
    
    public boolean insertUserlog(Userlog log){        
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(log);
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        } 
    }     
    
    public ArrayList<Userlog> getUserlogs (int uid,Date date){
        ArrayList<Userlog> userinfo = new ArrayList<Userlog>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userlog where uid='"+uid+"' and LogDT='"+date+"'");
            userinfo = (ArrayList<Userlog>) q.list();
            if(userinfo.size()>=1){
                return userinfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
        return null;
    } 
    
}

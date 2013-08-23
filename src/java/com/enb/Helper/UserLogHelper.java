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
    
    public ArrayList<Userlog> getUserlogs (int uid,Calendar cal){
        ArrayList<Userlog> userinfo = new ArrayList<Userlog>();
        try {
            cal.add(Calendar.DATE, -1);
            String date1=cal.get(Calendar.YEAR)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DATE);
            cal.add(Calendar.DATE, +2);
            String date2=cal.get(Calendar.YEAR)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DATE);
            System.out.print("\n"+date1);
            System.out.print("\n"+date2);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Userlog where uid='"+uid+"' and LogDT>'"+date1+"' and LogDT<'"+date2+"'");
            userinfo = (ArrayList<Userlog>) q.list();
            return userinfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    } 
    
}

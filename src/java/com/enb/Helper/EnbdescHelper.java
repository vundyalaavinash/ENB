/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Avinash
 */
public class EnbdescHelper {
    
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    
    public boolean insertEnbdesc(Enbdesc enbdes){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(enbdes);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            session.flush();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateEnbdesc(Enbdesc enbdes){
        return false;
    }
    
    public boolean removeEnbdesc(Enbdesc enbdesc){
        return false;
    }   
    
    public ArrayList<Enbdesc> getEnbdesc(int pid){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Enbdesc where PID='"+pid+"'");
            userinfo = (ArrayList<Enbdesc>) q.list();
            return userinfo;
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
     public Enbdesc getEnbdescPID(int pid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Enbdesc> userinfo = new ArrayList<Enbdesc>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Enbdesc where PID='"+pid+"' and Todate>=curdate()");
            userinfo = (ArrayList<Enbdesc>) q.list();
            if(userinfo.size()>0){
                session.update(userinfo.get(0));
                return userinfo.get(0);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public Enbdesc getEnbdescID(int eid){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Enbdesc> enbinfo = new ArrayList<Enbdesc>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Enbdesc where ID='"+eid+"'");
            enbinfo = (ArrayList<Enbdesc>) q.list();
            if(enbinfo.size()==1){
                return enbinfo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public boolean checkproject(String pname){
        return false;
    }
    public Enbdesc getEnbid(String enbname,int uid)
    {
        session =  HibernateUtil.getSessionFactory().openSession();
        ArrayList<Enbdesc> enbinfo = new ArrayList<Enbdesc>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Enbdesc where enbname='"+enbname+"' and uid='"+uid+"'");
            enbinfo = (ArrayList<Enbdesc>) q.list();
            if(enbinfo.size()==1){
                return enbinfo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }        
}

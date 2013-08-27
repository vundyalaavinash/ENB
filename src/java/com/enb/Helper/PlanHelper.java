/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Avinash
 */
public class PlanHelper {

    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public ArrayList<PlanHelper> getPlan (int pid,Date to,Date from){
        return null;
    }
    
    public boolean insertPlan(Plan plan){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(plan);
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePlan(Plan plan){
        return false;
    } 
    public boolean removePlan(int eid){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("delete from Plan where ENBID="+eid+"");
            int result = q.executeUpdate();            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    public ArrayList<Plan> getPlan(int eid){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Plan> userinfo = new ArrayList<Plan>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Plan where ENBID="+eid);
            userinfo = (ArrayList<Plan>) q.list();
            return userinfo;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
}

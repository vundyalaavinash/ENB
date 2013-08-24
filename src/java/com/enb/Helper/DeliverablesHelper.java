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
public class DeliverablesHelper {
    
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public ArrayList<Deliverablestatus> getDeliverablestatus (String pid, Date to, Date From){
        return null;
    }
    
    public boolean insertDeliverablestatus(Deliverablestatus ds){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(ds);
            trans.commit();            
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean removeDeliverablestatus(int eid){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("delete from Deliverablestatus where ENBID="+eid+"");
            int result = q.executeUpdate();
            System.out.println(eid+":"+result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateDeliverablestatus(Deliverablestatus ds){
        return false;
    }
    
}

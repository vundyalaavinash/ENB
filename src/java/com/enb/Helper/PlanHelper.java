/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Date;
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
            session.save(plan);
            System.out.println("this is query : \t"+trans.toString());
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
    public boolean removePlan(Plan plan){
        return false;
    } 
    
}

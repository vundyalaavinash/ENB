/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
/**
 *
 * @author Avinash
 */
public class PlanHelper {

    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public ArrayList<PlanHelper> getPlan (int pid,Date to,Date from){
        return null;
    }
    
    public boolean insertPlan(PlanHelper plan){
        return false;
    }
    
    public boolean updatePlan(PlanHelper plan){
        return false;
    } 
    public boolean removePlan(PlanHelper plan){
        return false;
    } 
    
}

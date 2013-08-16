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
public class DeliverablesHelper {
    
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public ArrayList<Deliverablestatus> getDeliverablestatus (String pid, Date to, Date From){
        return null;
    }
    
    public boolean insertDeliverablestatus(Deliverablestatus ds){
        return false;
    }
    
    public boolean removeDeliverablestatus(Deliverablestatus ds){
        return false;
    }
    
    public boolean updateDeliverablestatus(Deliverablestatus ds){
        return false;
    }
    
}

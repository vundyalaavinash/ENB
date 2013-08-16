/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;
import com.enb.POJO.*;
import org.hibernate.Session;
/**
 *
 * @author Avinash
 */
public class EnbdescHelper {
    
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    
    public boolean insertEnbdesc(Enbdesc enbdes){
        return false;
    }
    
    public boolean updateEnbdesc(Enbdesc enbdes){
        return false;
    }
    
    public boolean removeEnbdesc(Enbdesc enbdesc){
        return false;
    }
    public Enbdesc getEnbdesc(String Pid){
        return null;
    }
    public boolean checkproject(String pname){
        return false;
    }
    
}

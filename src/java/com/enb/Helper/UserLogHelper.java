/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Avinash
 */
public class UserLogHelper {
    Session session = null;
    public UserLogHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    
}

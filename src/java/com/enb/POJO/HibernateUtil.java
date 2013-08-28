/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.POJO;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *  <p>
 * Description- HibernateUtil class is a boundary class which is responsible for communication with the user
 * </p>
 *
 * @author Avinash
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);  // sends error if problem in creating session exists
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

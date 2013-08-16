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
public class LessonsHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public boolean insertLessons(Lessons lessons){
        return false;
    }
    public boolean deleteLessons(Lessons lessons){
        return false;
    }
    public boolean updateLessons(Lessons lessons){
        return false;
    }
    public ArrayList<Lessons> getLessons(String id, Date to, Date From){
        return null;
    }
}

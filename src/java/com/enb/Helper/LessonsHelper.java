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
public class LessonsHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    public boolean insertLessons(Lessons lessons){
         try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(lessons);
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean deleteLessons(int eid){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("delete from Lessons where ENBID="+eid+"");
            int result = q.executeUpdate();
            System.out.println(eid+":"+result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
             session.close();
         }
    }
    public boolean updateLessons(Lessons lessons){
        return false;
    }
    public ArrayList<Lessons> getLessons(String id, Date to, Date From){
        return null;
    }
}

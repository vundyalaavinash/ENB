/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.HibernateUtil;
import com.enb.POJO.Project;
import com.enb.POJO.Userauth;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Avinash
 */
public class ProjectHelper {
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
    
    public ArrayList<Project> getProject (int uid){
        ArrayList<Project> userinfo = new ArrayList<Project>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Project where UID='"+uid+"' and Todate>=curdate()");
            userinfo = (ArrayList<Project>) q.list();
            return userinfo;
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public Project getProject (int uid, String ProjectName){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Project> userinfo = new ArrayList<Project>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Project where UID='"+uid+"' and ProjectName='"+ProjectName+"'");
            userinfo = (ArrayList<Project>) q.list();
            if(userinfo.size()!=0){
                return userinfo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
        return null;
    }
    
    
    
    
    public Project getProjectID (int uid){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Project> userinfo = new ArrayList<Project>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Project where UID='"+uid+"' ORDER BY Id DESC");
            userinfo = (ArrayList<Project>) q.list();
            if(userinfo.size()!=0){
                return (userinfo.get(0));
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    public Project getProjectPID (int pid){
        session =  HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<Project> userinfo = new ArrayList<Project>();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Project where ID='"+pid+"'");
            userinfo = (ArrayList<Project>) q.list();
            if(userinfo.size()!=0){
                return (userinfo.get(0));
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    public boolean insertProject(Project project){
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(project);
            System.out.println("this is query : \t"+trans.toString());
            trans.commit();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateProject(ProjectHelper plan){
        return false;
    } 
    public boolean removeProject(ProjectHelper plan){
        return false;
    } 
}

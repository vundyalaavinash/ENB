/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.MiscClasses;

import com.enb.Helper.*;

import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Avinash
 */
public class ConstructString {
    public String getProjectsView(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        System.out.println("Got back");
        String projects="";
        System.out.println(""+alp.size());
        if(!alp.isEmpty()){
            int j=1;
            projects=projects+"<ul>";
            for(int i=0;i<alp.size();i++){
                Calendar from=Calendar.getInstance();
                Calendar to=Calendar.getInstance();
                from.setTime(alp.get(i).getFromDate());
                to.setTime(alp.get(i).getToDate());
                
                ;
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                i++;
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                }
                i++;
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                }
                j++;
            }
            projects=projects+"</ul>";
            return projects;
        }
        else{
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    
    public String getProjectsManage(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        System.out.println("Got back");
        String projects="";
        System.out.println(""+alp.size());
        if(!alp.isEmpty()){
            int j=1;
            projects=projects+"<ul>";
            for(int i=0;i<alp.size();i++){
                Calendar from=Calendar.getInstance();
                Calendar to=Calendar.getInstance();
                from.setTime(alp.get(i).getFromDate());
                to.setTime(alp.get(i).getToDate());
                
                ;
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='manage.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                i++;
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='manage.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                }
                i++;
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='manage.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p></a></center></span></li>";
                }
                j++;
            }
            projects=projects+"</ul>";
            return projects;
        }
        else{
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    
    public String getProjects(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        String projects="";
        if(!alp.isEmpty()){
            int j=1;
            projects=projects+"<ul>";
            for(int i=0;i<alp.size();i++){
                Calendar from=Calendar.getInstance();
                Calendar to=Calendar.getInstance();
                from.setTime(alp.get(i).getFromDate());
                to.setTime(alp.get(i).getToDate());                
                projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p><div style='width:80%'><a href='manage.jsp?pid="+alp.get(i).getId()+"' style='float:left;'>Manage</a><a href='viewenb.jsp?pid="+alp.get(i).getId()+"' style='float:right;'>View</a></center></span></li>";
                i++;
                System.out.println(""+alp.size());
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p><div style='width:80%'><a href='manage.jsp?pid="+alp.get(i).getId()+"' style='float:left;'>Manage</a><a href='viewenb.jsp?pid="+alp.get(i).getId()+"' style='float:right;'>View</a></center></span></li>";
                }
                i++;
                if(i<alp.size()){
                    from.setTime(alp.get(i).getFromDate());
                    to.setTime(alp.get(i).getToDate());
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>"+alp.get(i).getProjectName() +"</h2><p>"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR)+" to "+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR)+"</p><div style='width:80%'><a href='manage.jsp?pid="+alp.get(i).getId()+"' style='float:left;'>Manage</a><a href='viewenb.jsp?pid="+alp.get(i).getId()+"' style='float:right;'>View</a></center></span></li>";
                }
                j++;
            }
            projects=projects+"</ul>";
            return projects;
        }
        else{
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    
    public String getProjectsList(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        String projects="";
        if(!alp.isEmpty()){
            int j=1;
            for(int i=0;i<alp.size();i++){
                projects=projects+"<option value='"+alp.get(i).getId() +"'>"+alp.get(i).getProjectName() +"</option>";
            }
            return projects;
        }
        else{
            return "";
        }
    }
    
    public String getENBList(int pid){        
        EnbdescHelper edh=new EnbdescHelper();          
        ArrayList<Enbdesc> alp=edh.getEnbdesc(pid);
        System.out.println("Got back");
        String enbs="";
        if(!alp.isEmpty()){
            int j=1;
            for(int i=0;i<alp.size();i++){
                enbs=enbs+"<option value='"+alp.get(i).getId() +"'>"+alp.get(i).getEnbname() +"</option>";
            }
            return enbs;
        }
        else{
            return "";
        }
    }
    
    public static String getLogs(int uid,String cal){
        UserLogHelper uh=new UserLogHelper();
        ArrayList<Userlog> logs=new ArrayList<Userlog>();
        logs=uh.getUserlogs(uid, cal);
        if(!logs.isEmpty()){
            int j=0;
            String log="";
            for(int i=0;i<logs.size();i++){
                log=log+"<tr><td>"+logs.get(i).getLogDt() +"</td>";
                log=log+"<td>"+logs.get(i).getDescription() +"</td></tr>";
            }
            return log;
        }
        return "<tr><td>No Activity on that date</td><td></td></tr>";
    }
}

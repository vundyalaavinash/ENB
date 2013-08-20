/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.MiscClasses;

import com.enb.Helper.ProjectHelper;
import com.enb.POJO.Project;
import java.util.ArrayList;

/**
 *
 * @author Avinash
 */
public class ConstructString {
    public static String getProjects(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        System.out.println("Got back");
        String projects="";
        if(!alp.isEmpty()){
            int j=1;
            projects=projects+"<ul>";
            for(int i=0;i<alp.size();i++){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+alp.get(i).getFromDate().getDate()+"-"+(alp.get(i).getFromDate().getMonth()+1)+"-"+alp.get(i).getFromDate().getYear()+" to "+alp.get(i).getToDate().getDate()+"-"+(alp.get(i).getToDate().getMonth()+1)+"-"+alp.get(i).getToDate().getYear()+"</p></a></center></span></li>";
                i++;
                if(i<alp.size()){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+alp.get(i).getFromDate().getDate()+"-"+(alp.get(i).getFromDate().getMonth()+1)+"-"+alp.get(i).getFromDate().getYear()+" to "+alp.get(i).getToDate().getDate()+"-"+(alp.get(i).getToDate().getMonth()+1)+"-"+alp.get(i).getToDate().getYear()+"</p></a></center></span></li>";
                }
                i++;
                if(i<alp.size()){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><a href='viewenb.jsp?pid="+alp.get(i).getId()+"'><h2>"+alp.get(i).getProjectName() +"</h2><p>"+alp.get(i).getFromDate().getDate()+"-"+(alp.get(i).getFromDate().getMonth()+1)+"-"+alp.get(i).getFromDate().getYear()+" to "+alp.get(i).getToDate().getDate()+"-"+(alp.get(i).getToDate().getMonth()+1)+"-"+alp.get(i).getToDate().getYear()+"</p></a></center></span></li>";
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
    
    public static String getProjectsList(String Uname){        
        ProjectHelper ph=new ProjectHelper();            
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));
        System.out.println("Got back");
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
}

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
        String projects="";
        if(alp.size()!=0){
            int j=1;
            for(int i=0;i<alp.size();i++){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>"+alp.get(i).getProjectName() +"</h2><p>"+alp.get(i).getFrom().getDate()+"-"+(alp.get(i).getFrom().getMonth()+1)+"-"+alp.get(i).getFrom().getYear()+" to "+alp.get(i).getTo().getDate()+"-"+(alp.get(i).getTo().getMonth()+1)+"-"+alp.get(i).getTo().getYear()+"</p></center></span></li>";
                i++;
                if(i<alp.size()){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>Fries & Wings SCM</h2><p>21-07-2013 to 21-08-2013</p></center></span></li>";
                }
                i++;
                if(i<alp.size()){
                    projects=projects+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='1'><span><center><h2>Fries & Wings SCM</h2><p>21-07-2013 to 21-08-2013</p></center></span></li>";
                }
                j++;
            }
            return projects;
        }
        else{
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
}

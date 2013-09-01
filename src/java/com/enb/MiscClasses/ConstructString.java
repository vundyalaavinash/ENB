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
 * <p> Title: ConstructString Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class </p>
 * @author Avinash
 */
public class ConstructString {
    /**
     * retrieves the project names and duration dates of a specified user 
     * @param Uname The user name
     * @return the html tag string with the projects names and from date to to date
     */
    public String getProjectsView(String Uname){        
        ProjectHelper ph=new ProjectHelper();                   // ceates the instances of projecthelper class to retrive the project details
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));  // calls the getproject method for retrieving the instances of project class
        System.out.println("Got back");
        String projects="";
        System.out.println(""+alp.size());
        if(!alp.isEmpty()){             // checks for arraylist is empty or not
            // code for the arraylist is not empty i.e., projects are available for the given user
            int j=1;
            projects=projects+"<ul>";
            System.out.println(""+alp.size());
            // code for retrieving all the projects and duration of the project and it is appended to the string with html tags
            for(int i=0;i<alp.size();i++){
                Calendar from=Calendar.getInstance();
                Calendar to=Calendar.getInstance();
                from.setTime(alp.get(i).getFromDate());
                to.setTime(alp.get(i).getToDate());
                
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
        else{                       // if arraylist is empty then it returns the below string
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    /**
     * retrieves the project names and duration dates of a specified user
     * @param Uname The user
     * @return the html tag string with the projects names and from date to to date
     */
    public String getProjectsManage(String Uname){        
        ProjectHelper ph=new ProjectHelper();                   // ceates the instances of projecthelper class to retrive the project details       
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));      // calls the getproject method for retrieving the instances of project class
        System.out.println("Got back");
        String projects="";
        System.out.println(""+alp.size());  
        if(!alp.isEmpty()){                 // checks for arraylist is empty or not
            // code for the arraylist is not empty i.e., projects are available for the given user
            int j=1;
            projects=projects+"<ul>";
            // code for retrieving all the projects and duration of the project and it is appended to the string with html tags
            for(int i=0;i<alp.size();i++){
                Calendar from=Calendar.getInstance();
                Calendar to=Calendar.getInstance();
                from.setTime(alp.get(i).getFromDate());
                to.setTime(alp.get(i).getToDate());
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
        else{           // if arraylist is empty then it returns the below string
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    /**
     * retrieves the project names and duration dates of a specified user
     * @param Uname The user
     * @return the html tag string with the projects names and from date to to date 
     */
    public String getProjects(String Uname){        
        ProjectHelper ph=new ProjectHelper();            // ceates the instances of projecthelper class to retrive the project details
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));           // calls the getproject method for retrieving the instances of project class
        String projects="";
        if(!alp.isEmpty()){         // checks for arraylist is empty or not
            // code for the arraylist is not empty i.e., projects are available for the given user
            int j=1;
            projects=projects+"<ul>";
             // code for retrieving all the projects and duration of the project and it is appended to the string with html tags
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
        else{               // if arraylist is empty then it returns the below string
            return "<h3>You do not have any ENBs. Please <a href='create.jsp'>Create an ENB</a> </h3>";
        }
    }
    /**
     * retrieves the project names and duration dates of a specified user
     * @param Uname The user
     * @return the html tag string with the projects names and from date to to date 
     */
    public String getProjectsList(String Uname){        
        ProjectHelper ph=new ProjectHelper();           // ceates the instances of projecthelper class to retrive the project details 
        ArrayList<Project> alp=ph.getProject(Integer.parseInt(Uname));      // calls the getproject method for retrieving the instances of project class
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
    /**
     * 
     * @param pid
     * @return 
     */
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
        public String getENBList2(int uid){        
        EnbdescHelper edh=new EnbdescHelper();          
        ArrayList<Enbdesc> alp=edh.getEnbdesc2(uid);
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
            return "<option value='Default'>No ENBs</option>";
        }
    }
        public String getENBList3(int uid){        
        EnbdescHelper edh=new EnbdescHelper();          
        ArrayList<Enbdesc> alp=edh.getEnbdescUID(uid);
        System.out.println("Got back");
        String enbs="";
        if(!alp.isEmpty()){
            for(int i=0;i<alp.size();i++){
                enbs=enbs+"<option value='"+alp.get(i).getId() +"'>"+alp.get(i).getEnbname() +"</option>";                
            }
            return enbs;
        }
         return "<option value='Default'>No ENBs</option>";
        
    }
    /**
     * 
     * @param uid
     * @param cal
     * @return 
     */
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
    public String getStudents(int uid)
    {
        RegistrationHelper ua=new RegistrationHelper();
        String str="";
        ArrayList<Userauth> names=ua.getNames(uid);
        if(!names.isEmpty())
        {
            int j=1;
            str=str+"<ul>";
            for(int i=0;i<names.size();i++)
            {
                str=str+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='0.6'><span><center><h2>"+names.get(i).getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getId()+"' style='float:right;'>View All ENB</a>" +"</center></span></li>";
                i++;
                if(i<names.size())
                {
                    str=str+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='0.6'><span><center><h2>"+names.get(i).getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getId()+"' style='float:right;'>View All ENB</a>" +"</h2></center></span></li>";
                    //str=str+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='0.5'><span><center><h2>"+names.get(i).getName() +"</h2></center></span></li>";
                }
                i++;
                if(i<names.size())
                {
                    str=str+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='0.6'><span><center><h2>"+names.get(i).getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getId()+"' style='float:right;'>View All ENB</a>" +"</h2></center></span></li>";
                    //str=str+"<li data-row='"+j+"' data-col='1' data-sizex='2' data-sizey='0.5'><span><center><h2>"+names.get(i).getName() +"</h2></center></span></li>";
                }
                j++;
            }
            str=str+"</ul>";
            return str;
        }
        
        return "No Students Registered under you!";
        
        
    }
    public ArrayList<Userauth> getStudentDetails(int uid)
    {
        RegistrationHelper ua=new RegistrationHelper();
        ArrayList<Userauth> names=ua.getNames(uid);
        return names;
    }
}

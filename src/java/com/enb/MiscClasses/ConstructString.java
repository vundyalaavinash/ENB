/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.MiscClasses;

import com.enb.Helper.*;

import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

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
        String projects="";
        if(!alp.isEmpty()){             // checks for arraylist is empty or not
            // code for the arraylist is not empty i.e., projects are available for the given user
            int j=1;
            projects=projects+"<ul>";
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
        String projects="";
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
        //System.out=out+"Got back");
        String enbs="";
        if(!alp.isEmpty()){
            int j=1;
            for(int i=0;i<alp.size();i++){
                enbs=enbs+"<option value='"+alp.get(i).getId() +"'>"+alp.get(i).getEnbname() +"</option>";
            }
            return enbs;
        }
        else{
            return "No ENBs";
        }
    }
        public String getENBList2(int uid){        
        EnbdescHelper edh=new EnbdescHelper();          
        ArrayList<Enbdesc> alp=edh.getEnbdesc2(uid);
        //System.out=out+"Got back");
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
        //System.out=out+"Got back");
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
        GroupHelper gh=new GroupHelper();                
        String str="";
        ArrayList<Groups> names=gh.getAllGroups(uid);
        if(!names.isEmpty())
        {
            int j=1;
            int k=1;
            str=str+"<ul>";
            for(int i=0;i<names.size();i++)
            {                                
                str=str+"<li data-row='"+j+"' data-col='"+k+"' data-sizex='2' data-sizey='1'><span><center><h2>"+names.get(i).getUserauthBySid().getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:right;'>View All ENB</a>" +"</center></span></li>";
                i++;
                k++;
                if(i<names.size())
                {
                    str=str+"<li data-row='"+j+"' data-col='"+k+"' data-sizex='2' data-sizey='1'><span><center><h2>"+names.get(i).getUserauthBySid().getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:right;'>View All ENB</a>" +"</h2></center></span></li>";                    
                }
                i++;
                k++;
                if(i<names.size())
                {
                    str=str+"<li data-row='"+j+"' data-col='"+k+"' data-sizex='2' data-sizey='1'><span><center><h2>"+names.get(i).getUserauthBySid().getName()+"</h2><div style='width:80%'><a href='current.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:left;'>Current ENB</a><a href='allenb.jsp?uid="+names.get(i).getUserauthBySid().getId()+"' style='float:right;'>View All ENB</a>" +"</h2></center></span></li>";                    
                }
                j++;
                k=1;
            }
            str=str+"</ul>";
            return str;
        }
        
        return "No Students Registered under you!";
        
        
    }
    public String getStudentDetails(int uid)
    {
        int eid=0;
        
        RegistrationHelper ua=new RegistrationHelper();
        ArrayList<Userauth> names=ua.getNames(uid);
        
        EnbdescHelper eh = new EnbdescHelper();
        Enbdesc ed = eh.getEnbdescID(eid);
        RegistrationHelper rh = new RegistrationHelper();
        NotesHelper nh = new NotesHelper();
        DeliverablesHelper dh = new DeliverablesHelper();
        LessonsHelper lh = new LessonsHelper();
        PlanHelper plh = new PlanHelper();

        Calendar from = Calendar.getInstance();
        from.setTime(ed.getFromdate());

        Calendar to = Calendar.getInstance();
        to.setTime(ed.getTodate());

        String proj = ed.getProject().getProjectName();
        Set notes = ed.getNoteses();
        Set ds =  ed.getDeliverablestatuses();
        Set ln = ed.getLessonses();
        Set pl = ed.getPlans();
        
        String out="";
        out=out+"<table width='100%'><tr><td colspan='2'><h2>" + proj.toUpperCase() + "</h2></td></tr><tr>";
        out=out+"<td width='50%'>Engineer: <span style='color:#47a3da;'>";

        out=out+"</span></td>";
        out=out+"<td width='50%' align='right'>Duration: <span style='color:#47a3da;'>";
        out=out+"&nbsp;&nbsp;&nbsp;"+from.get(Calendar.DATE)+"-"+from.get(Calendar.MONTH)+"-"+from.get(Calendar.YEAR);
        out=out+"</span>&nbsp;&nbsp;to<span style='color:#47a3da;'>";
        out=out+"&nbsp;&nbsp;&nbsp;"+to.get(Calendar.DATE)+"-"+to.get(Calendar.MONTH)+"-"+to.get(Calendar.YEAR);
        out=out+"</span></td></tr></table><br><hr><br>";

        String enbname = ed.getEnbname();
        EnbdescHelper eh1 = new EnbdescHelper();
        Enbdesc enb = eh1.getEnbid(enbname, uid);

        //Notes
        out=out+"<h2>Notes</h2><table><tr><td><div style='font-size:15px; width:100%;'>";
        ArrayList<Notes> itr = nh.getNote(ed.getId());
        if (!itr.isEmpty()) {
            Notes note = (Notes) itr.get(0);
            String s = new String(note.getNotes());
            out=out+s;
        }
        else{
            out=out+"No Notes in the ENB ....";
        }
        out=out+"</div></td></tr></table><br><hr><br>";

        //Deliverable Status
        out=out+"<h2>Deliverable Status</h2><table width='100%' border='0' cellspacing='10'><tr><td width='5%'>SNO</td><td width='16%'>Deliverable</td><td width='27%'>What did you plan to accomplish?</td><td width='27%'>What did you actually accomplish?</td><td width='10%'>Size</td><td width='10%'>Effort</td></tr>";
        int i=0;
        ArrayList<Deliverablestatus> dsi = dh.getDeliverablestatus(ed.getId());            
        for (i = 0; i < dsi.size(); i++) {
            Deliverablestatus dso=dsi.get(i);
            out=out+"<tr><td>"+(i+1)+"</td><td>"+dso.getDeliverables()+"</td><td>"+dso.getPlanToAccomplish()+"</td><td>"+dso.getActualAccomplished()+"</td><td>"+dso.getSize()+"</td><td>"+dso.getEffort()+"</td></tr>";
        }
        out=out+"<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr></table><br><hr><br>";
        //Lessons Learned  

        out=out+"<h2>Lessons Learned Reflection</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO.</td><td width='25%'>Context</td><td width='65%'>Lesson</td></tr>";
        ArrayList<Lessons> lni = lh.getLessons(ed.getId());
        for (i = 0; i < lni.size(); i++) {
            Lessons lno = lni.get(i);
            out=out+"<tr><td>"+(i+1)+"</td><td>"+lno.getContext()+"</td><td>"+lno.getLessons()+"</td></tr>";
        }
        out=out+"<tr><td></td><td></td><td></td></tr></table><br><hr><br>";

        //plans
        out=out+"<h2>Plan for the Next Week</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO</td><td width='25%'>Deliverable</td><td width='65%'>What do you intend to accomplish and why</td></tr>";
        ArrayList<Plan> pli = plh.getPlan(ed.getId());
        for (i = 0; i < pli.size(); i++) {
            Plan plo = pli.get(i);
            out=out+"<tr><td width='10%'>"+(i+1)+"</td><td width='25%'>"+plo.getDeliverable()+"</td><td width='65%'>"+plo.getIntendToAccomplish()+"</td></tr>";
        }
        out=out+"<tr><td></td><td></td><td></td></tr></table>";
        out=out+"<hr>";
            
        return out;
    }
}

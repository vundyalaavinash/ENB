package com.enb.POJO;
// Generated Aug 19, 2013 6:07:04 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Enbdesc generated by hbm2java
 */
public class Enbdesc  implements java.io.Serializable {


     private Integer id;
     private Userauth userauth;
     private Project project;
     private Date from;
     private Date to;
     private String monthlyWeekly;
     private String enbname;
     private Set lessonses = new HashSet(0);
     private Set deliverablestatuses = new HashSet(0);
     private Set noteses = new HashSet(0);
     private Set plans = new HashSet(0);

    public Enbdesc() {
    }

    public Enbdesc(Userauth userauth, Project project, Date from, Date to, String monthlyWeekly, String enbname, Set lessonses, Set deliverablestatuses, Set noteses, Set plans) {
       this.userauth = userauth;
       this.project = project;
       this.from = from;
       this.to = to;
       this.monthlyWeekly = monthlyWeekly;
       this.enbname = enbname;
       this.lessonses = lessonses;
       this.deliverablestatuses = deliverablestatuses;
       this.noteses = noteses;
       this.plans = plans;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Userauth getUserauth() {
        return this.userauth;
    }
    
    public void setUserauth(Userauth userauth) {
        this.userauth = userauth;
    }
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    public Date getFrom() {
        return this.from;
    }
    
    public void setFrom(Date from) {
        this.from = from;
    }
    public Date getTo() {
        return this.to;
    }
    
    public void setTo(Date to) {
        this.to = to;
    }
    public String getMonthlyWeekly() {
        return this.monthlyWeekly;
    }
    
    public void setMonthlyWeekly(String monthlyWeekly) {
        this.monthlyWeekly = monthlyWeekly;
    }
    public String getEnbname() {
        return this.enbname;
    }
    
    public void setEnbname(String enbname) {
        this.enbname = enbname;
    }
    public Set getLessonses() {
        return this.lessonses;
    }
    
    public void setLessonses(Set lessonses) {
        this.lessonses = lessonses;
    }
    public Set getDeliverablestatuses() {
        return this.deliverablestatuses;
    }
    
    public void setDeliverablestatuses(Set deliverablestatuses) {
        this.deliverablestatuses = deliverablestatuses;
    }
    public Set getNoteses() {
        return this.noteses;
    }
    
    public void setNoteses(Set noteses) {
        this.noteses = noteses;
    }
    public Set getPlans() {
        return this.plans;
    }
    
    public void setPlans(Set plans) {
        this.plans = plans;
    }




}



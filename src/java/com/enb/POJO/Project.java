package com.enb.POJO;
// Generated Aug 23, 2013 11:30:59 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Project generated by hbm2java
 */
public class Project  implements java.io.Serializable {


     private Integer id;
     private Userauth userauth;
     private String projectName;
     private Date fromDate;
     private Date toDate;
     private String isMonthly;
     private Set enbdescs = new HashSet(0);

    public Project() {
    }

    public Project(Userauth userauth, String projectName, Date fromDate, Date toDate, String isMonthly, Set enbdescs) {
       this.userauth = userauth;
       this.projectName = projectName;
       this.fromDate = fromDate;
       this.toDate = toDate;
       this.isMonthly = isMonthly;
       this.enbdescs = enbdescs;
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
    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return this.toDate;
    }
    
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public String getIsMonthly() {
        return this.isMonthly;
    }
    
    public void setIsMonthly(String isMonthly) {
        this.isMonthly = isMonthly;
    }
    public Set getEnbdescs() {
        return this.enbdescs;
    }
    
    public void setEnbdescs(Set enbdescs) {
        this.enbdescs = enbdescs;
    }




}



package com.enb.POJO;
// Generated Aug 19, 2013 3:22:20 PM by Hibernate Tools 3.2.1.GA



/**
 * Lessons generated by hbm2java
 */
public class Lessons  implements java.io.Serializable {


     private Integer id;
     private Enbdesc enbdesc;
     private String context;
     private String lessons;

    public Lessons() {
    }

    public Lessons(Enbdesc enbdesc, String context, String lessons) {
       this.enbdesc = enbdesc;
       this.context = context;
       this.lessons = lessons;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Enbdesc getEnbdesc() {
        return this.enbdesc;
    }
    
    public void setEnbdesc(Enbdesc enbdesc) {
        this.enbdesc = enbdesc;
    }
    public String getContext() {
        return this.context;
    }
    
    public void setContext(String context) {
        this.context = context;
    }
    public String getLessons() {
        return this.lessons;
    }
    
    public void setLessons(String lessons) {
        this.lessons = lessons;
    }




}



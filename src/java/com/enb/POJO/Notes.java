package com.enb.POJO;
// Generated Aug 23, 2013 11:30:59 PM by Hibernate Tools 3.2.1.GA



/**
 * Notes generated by hbm2java
 */
public class Notes  implements java.io.Serializable {


     private int enbid;
     private Enbdesc enbdesc;
     private byte[] notes;

    public Notes() {
    }

	
    public Notes(int enbid, Enbdesc enbdesc) {
        this.enbid = enbid;
        this.enbdesc = enbdesc;
    }
    public Notes(int enbid, Enbdesc enbdesc, byte[] notes) {
       this.enbid = enbid;
       this.enbdesc = enbdesc;
       this.notes = notes;
    }
   
    public int getEnbid() {
        return this.enbid;
    }
    
    public void setEnbid(int enbid) {
        this.enbid = enbid;
    }
    public Enbdesc getEnbdesc() {
        return this.enbdesc;
    }
    
    public void setEnbdesc(Enbdesc enbdesc) {
        this.enbdesc = enbdesc;
    }
    public byte[] getNotes() {
        return this.notes;
    }
    
    public void setNotes(byte[] notes) {
        this.notes = notes;
    }




}



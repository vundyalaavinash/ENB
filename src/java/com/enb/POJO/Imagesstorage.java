package com.enb.POJO;
// Generated Sep 24, 2013 10:52:21 AM by Hibernate Tools 3.2.1.GA



/**
 * Imagesstorage generated by hbm2java
 */
public class Imagesstorage  implements java.io.Serializable {


     private Integer id;
     private Enbdesc enbdesc;
     private Userauth userauth;
     private byte[] imageBlob;
     private String imageUrl;

    public Imagesstorage() {
    }

    public Imagesstorage(Enbdesc enbdesc, Userauth userauth, byte[] imageBlob, String imageUrl) {
       this.enbdesc = enbdesc;
       this.userauth = userauth;
       this.imageBlob = imageBlob;
       this.imageUrl = imageUrl;
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
    public Userauth getUserauth() {
        return this.userauth;
    }
    
    public void setUserauth(Userauth userauth) {
        this.userauth = userauth;
    }
    public byte[] getImageBlob() {
        return this.imageBlob;
    }
    
    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}


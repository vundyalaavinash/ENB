/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.MiscClasses;

import java.sql.*;

public class Creation {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/enb";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public String execute(String command) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE `groups` (" +
"  `Id` int(11) NOT NULL AUTO_INCREMENT," +
"  `MID` int(11) DEFAULT NULL," +
"  `SID` int(11) DEFAULT NULL," +
"  PRIMARY KEY (`Id`)," +
"  KEY `Fk_Uid_idx` (`SID`)," +
"  KEY `Fk_MID_idx` (`MID`)," +
"  CONSTRAINT `Fk_MID` FOREIGN KEY (`MID`) REFERENCES `userauth` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION," +
"  CONSTRAINT `Fk_SID` FOREIGN KEY (`SID`) REFERENCES `userauth` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION" +
");"; 
      return ""+stmt.executeUpdate(sql);      
   }catch(SQLException se){
      se.printStackTrace();
      return ""+se.getMessage();
   }catch(Exception e){      
      e.printStackTrace();
      return ""+e.getMessage();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
         return ""+se.getMessage(); 
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
         return ""+se.getMessage();
      }
   }
}
   
   public String  alltables(){
       Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");      
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      DatabaseMetaData md = conn.getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);
        String a="<br>";
        while (rs.next()) {
          a=a+rs.getString(3)+"<br>";
        }
      return a;
   }catch(SQLException se){
      se.printStackTrace();
      return ""+se.getMessage();
   }catch(Exception e){      
      e.printStackTrace();
      return ""+e.getMessage();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
         return ""+se.getMessage(); 
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
         return ""+se.getMessage();
      }
   }
   
        
   }
}
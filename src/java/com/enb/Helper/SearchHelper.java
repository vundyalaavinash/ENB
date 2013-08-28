/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import com.enb.POJO.*;
import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoup.Jsoup;

/**
 * <p> Title: SearchHelper Class - - A component of the ENBTool </p>
 *
 * <p> Description: A controller object class that is used to search the notes
 * instances of a given string of the enb
 * </p>
 *
 * <p> Copyright: Copyright 2013 </p>
 *
 * @author Avinash
 */
public class SearchHelper {

    Session session = null;

    /**
     * default class which initializes the session
     */
    public SearchHelper() {
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file
    }

    /**
     *
     * @param html
     * @return
     */
    public String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    /**
     * retrieves the all enb notes details
     *
     * @return the notes instances in an arraylist
     */
    public ArrayList<Notes> getAllNotes() {
        this.session = HibernateUtil.getSessionFactory().openSession();       // Create the SessionFactory from standard (hibernate.cfg.xml) config file
        ArrayList<Notes> userinfo = new ArrayList<Notes>();         // arraylist which stores instances of Notes class
        try {
            org.hibernate.Transaction tx = session.beginTransaction();       // load the connection for the given session
            Query q = session.createQuery("from Notes");           //Query instance is obtained
            userinfo = (ArrayList<Notes>) q.list();         //list of instances are stored in arraylist
            return userinfo;
        }// catches if any exception in retrieving the notes from the database or loading the connection for session 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }

    /**
     * retrieves the notes instances for specific keyword for a given user id
     *
     * @param Keyword The searching string
     * @param uid The user id
     * @return the notes instances in an arraylist
     */
    public ArrayList<Notes> Search(String Keyword, int uid) {
        String keys[] = Keyword.split(" ");           // given string is splitted into words and stores in string array
        ArrayList<Notes> all = getAllNotes();         // gets all the notes of the enb
        ArrayList<Notes> found = new ArrayList<Notes>(); // arraylist which stores instances of Notes class in which the keyword is present
        // code for finding the notes in which the given string is present in the notes
        for (int i = 0; i < all.size(); i++) {
            Notes n = all.get(i);             // assigns the instance of notes from the arraylist
            String note = new String(n.getNotes());     // assigns the enb notes text       
            if (n.getEnbdesc().getUserauth().getId() == uid) {      // checks for the enb notes is belongs to the current user id
                for (int j = 0; j < keys.length; j++) {
                    String ah = html2text(note);    
                    if (ah.toLowerCase().contains(keys[j].toLowerCase())) {
                        System.out.println("text:" + ah);
                        if (!found.contains(all.get(i))) {      // chcks for the word found in notes or not if found then the noets instance is inserted into the arraylist
                            found.add(all.get(i));
                        }
                    }
                }
            }
        }
        return found;
    }

    /**
     *retrieves the notes that contains the keyword that belongs to the specified user enb
     * @param keyword
     * @param uid
     * @return  
     */
    public String Searching(String keyword, int uid) {
        ArrayList<Notes> found = Search(keyword, uid); //store all the instances of notes class where the ketword is found for required user id
        String st = "";
        st = "<b>" + found.size() + " results</b> Found";
        // code for finding the notes in which the given string is present in the notes
        for (int i = 0; i < found.size(); i++) {
            Notes note = found.get(i);            // assigns the instance of notes from the arraylist
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.setTime(note.getEnbdesc().getProject().getFromDate());
            to.setTime(note.getEnbdesc().getProject().getToDate());
            String fd = from.get(Calendar.DATE) + "/" + from.get(Calendar.MONTH) + "/" + from.get(Calendar.YEAR);
            String td = to.get(Calendar.DATE) + "/" + to.get(Calendar.MONTH) + "/" + to.get(Calendar.YEAR);
            st = st + "<table><tr><td width='70%'><a href='viewenbnotes.jsp?eid=" + note.getEnbdesc().getId() + "'><h2>" + note.getEnbdesc().getEnbname() + "</h2></a></td>"
                    + "<td width='30%'>Project Duration :&nbsp;&nbsp;<span style='color:#47a3da;'>" + fd + "</span>&nbsp;&nbsp;to &nbsp;&nbsp;"
                    + "<span style='color:#47a3da;'>" + td + "</span></td></tr><tr><td>Project : &nbsp;&nbsp;&nbsp;" + note.getEnbdesc().getProject().getProjectName() + "</td></tr></table><br/><hr><br/>";
        }
        return st;
    }
}

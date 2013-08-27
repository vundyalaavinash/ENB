/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enb.Helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Avinash
 */
public class MailHelper {
    /**
     * 
     * @param uname
     * @param email
     * @param url
     * @return 
     */
    public boolean mail(String uname, String email, String url) {
        final String username = "enbtool@gmail.com";
        final String password = "team4enb";
        //SMTP Server (Outgoing Messages)
        //Googlemail/Gmail SMTP POP3 Serve
        // Reference https://support.google.com/mail/answer/13287?hl=en
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");//Secure connection for SMTP server. Default is checked Optional Gmail pop3 setting, configure pop3 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");//Server for outgoing mail. Gmail uses smtp.gmail.com
        props.put("mail.smtp.port", "587");//Port for outgoing mail. The dafault Gmail smtp port is 587.

         // Getting the default Session object.
        Session sess;
        sess = Session.getInstance(props,
        new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
});

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(sess);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(email));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            //Setting the Email Heading
            message.setSubject("Testing Subject");
            //Setting Email message
            message.setText("Dear " + uname + ",\n\nWelcome to Locomate\nPlease verify your account!!\nYour Activation Link!!\n\n" + url);
            //Sending the message
            Transport.send(message);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}

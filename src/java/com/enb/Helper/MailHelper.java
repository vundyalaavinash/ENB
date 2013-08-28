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
    public boolean mail(String uname, String email, String url) {
        final String username = "enbtool@gmail.com";
        final String password = "team4enb";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session sess;
        sess = Session.getInstance(props,
        new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
});

        try {
            Message message = new MimeMessage(sess);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Testing Subject");
            message.setText("Dear " + uname + ",\n\nWelcome to Locomate\nPlease verify your account!!\nYour Activation Link!!\n\n" + url);
            Transport.send(message);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}

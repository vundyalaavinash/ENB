package com.enb.Helper;

import com.enb.Helper.RegistrationHelper;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;

public class SendMailTLS {

    public void sendMail(String email, String code) {
            final String username = "enbtool@gmail.com";
            final String password = "enbarm007";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");


            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                message.setSubject("Reg: Vefication code");
                message.setText("Dear User,"
                        + "\n\nThe activation code is \n"
                        + "" + code + "\n"
                        + "\n\n\n\nHappy Using ENB Tool!");
                Transport.send(message);
            } catch (MessagingException e) {
                
            }
    }   
}
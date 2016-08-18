package com.accolite.chat.controller;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by Diksha Garg on 8/10/2016.
 */
public class sendMail implements Runnable{

    private String newUser;
    private String nickName;
    private String address;

    sendMail(String newUser, String nickName, String address) {
        this.newUser=newUser;
        this.nickName=nickName;
        this.address=address;
    }

    public void run() {
        System.out.println("hello world");
        final String username = "chatster.accolite@gmail.com";
        final String password = "chatsteraccolite";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(javax.mail.Message.RecipientType.TO,
                    InternetAddress.parse(address));
            message.setSubject("Welcome " + newUser + " as " + nickName + " to Chaster - The Accolite Chat Group");
            message.setText("Welcome on-board " + newUser + " We are very happy to have you as part of our chat group.");

            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



}

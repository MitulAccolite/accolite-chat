package com.accolite.chat.controller;

import com.accolite.chat.dao.IUserDao;
import com.accolite.chat.dao.impl.UserDao;
import com.accolite.chat.model.User;
import manager.ChatManager;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Mitul Kapoor on 8/7/2016.
 */
public class OfflineUsers {
    private List<String> offlineUsers;
    private List<String> onlineUsers;
    private List<String> registeredUsers;

    public OfflineUsers(){
        offlineUsers = new ArrayList<String>();
        onlineUsers = new ArrayList<String>();
        registeredUsers = new ArrayList<String>();
    }

    public List<String> getAllRegisteredUsers(){
        IUserDao userDao = new UserDao();

        List<User> allUsers = userDao.listAddUsers();
        for(User user : allUsers){
            registeredUsers.add(user.getEmail());
        }
        return registeredUsers;
    }


    public List<String> getAllOfflineUsers(){
        List<String> allUsers = getAllRegisteredUsers();
        Set<User> onlineUsers = ChatManager.getActiveUsers();

        List<String> temp = new ArrayList<String>();
        for(User user : onlineUsers){
            temp.add(user.getEmail());
        }

        for(int i=0;i<onlineUsers.size();i++){
            allUsers.remove(temp.get(0));
        }

        for(String user : allUsers){
            System.out.println("USer : " + user);
        }

        return allUsers;
    }


    public void notifyUsersForNewRegistration(String newUser,String nickName){

        try {
            List<String> addresses = getAllOfflineUsers();
            for (int i = 0; i < addresses.size(); i++) {
                final String username = "saumyadeepjndi@gmail.com";
                final String password = "jndijndi123123";

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
                            InternetAddress.parse(addresses.get(0)));
                    message.setSubject("Welcome " + newUser + " as " + nickName + " to Chaster - The Accolite Chat Group");
                    message.setText("Welcome on-board " + newUser + " We are very happy to have you as part of our chat group.");

                    Transport.send(message);
                    System.out.println("Done");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}

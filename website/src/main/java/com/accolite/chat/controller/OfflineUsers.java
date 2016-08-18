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
                Thread notify=new Thread(new sendMail(newUser,nickName,addresses.get(i)));
                notify.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

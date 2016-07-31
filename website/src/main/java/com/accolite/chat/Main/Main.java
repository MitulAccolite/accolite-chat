package com.accolite.chat.Main;

import com.accolite.chat.dao.*;
import com.accolite.chat.model.User;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class Main {

    public static void main(String[] args){
        /*java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
*/
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        GroupDao groupDao = new GroupDao();
        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        MessageDao messageDao = new MessageDao();
        NotificationDao notificationDao = new NotificationDao();
        UserDao userDao = new UserDao();
        UserRoleDao userRoleDao = new UserRoleDao();

        User user = new User("mitul","k","kapoor",date,date,true,"mitu","mitul.kapoor@accoliteindia.com");
        userDao.addNewUser(user);

        userRoleDao.addUserRole(user.getId(),"USER");

        User user1 = userDao.findUserByNickname("mitu");
        System.out.println("Nickname is : " + user1.getNickName());


        System.out.println("Mitul kapoor");
    }
}

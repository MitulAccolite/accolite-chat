package com.accolite.chat.Main;

import com.accolite.chat.dao.IChatGroupDao;
import com.accolite.chat.dao.IMessageDao;
import com.accolite.chat.dao.IUserDao;
import com.accolite.chat.dao.impl.ChatGroupDao;
import com.accolite.chat.dao.impl.MessageDao;
import com.accolite.chat.dao.impl.UserDao;
import com.accolite.chat.model.ChatGroup;
import com.accolite.chat.model.Credential;
import com.accolite.chat.model.Message;
import com.accolite.chat.model.Role;
import com.accolite.chat.model.Roles;
import com.accolite.chat.model.User;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class Main {

    public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        Credential credential = new Credential("u1", "p1", new Date(), new Date());
        userDao.add(credential);
        Role role = new Role(Roles.USER);
        userDao.add(role);

        Role roleByName = userDao.findRoleByName(Roles.USER);
        User user = new User("f1", "m1", "l1", new Date(), new Date(), true, "n1", "e1", Arrays.asList(roleByName), credential);
        userDao.add(user);

        com.accolite.chat.model.ChatGroup g1 = new com.accolite.chat.model.ChatGroup("PUBLIC", new Date());
        IChatGroupDao groupDao = new ChatGroupDao();
        groupDao.add(g1);

       /* for (ChatGroupDao chatGroup : groupDao.all()) {
            System.out.println(chatGroup);
        }*/


        g1.getUsers().add(user);
        groupDao.merge(g1);

        ChatGroup groupById = groupDao.findById(g1.getId());


        Message m1 = new Message("M1", new Date(), user);
        IMessageDao messageDao = new MessageDao();
        messageDao.save(m1);

        groupDao.addMessageToGroup(g1,m1);


//        System.out.println(groupById);



       /* java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        GroupDao groupDao = new GroupDao();
        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        MessageDao messageDao = new MessageDao();
        NotificationDao notificationDao = new NotificationDao();
        UserDao userDao = new UserDao();
        UserRoleDao userRoleDao = new UserRoleDao();

        User user = new User("mitul", "k", "kapoor", date, date, true, "mitu", "mitul.kapoor@accoliteindia.com");
        userDao.add(user);

        userRoleDao.addUserRole(user.getId(), "USER");

        User user1 = userDao.findUserByNickname("mitu");
        System.out.println("Nickname is : " + user1.getNickName());


        System.out.println("Mitul kapoor");*/
    }
}

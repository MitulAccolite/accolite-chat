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

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class Main {

    public static void main(String[] args) {
/*

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


        g1.getUsers().add(user);
        groupDao.merge(g1);

        ChatGroup groupById = groupDao.findById(g1.getId());


        Message m1 = new Message("M1", new Date(), user);
        IMessageDao messageDao = new MessageDao();
        messageDao.save(m1);

        groupDao.addMessageToGroup(g1,m1);

*/
    IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup chatGroup = new ChatGroup("PUBLIC",new Date());
        chatGroupDao.add(chatGroup);
    }
/*

    public static void main(String [] args)
    {
        // Recipient's email ID needs to be mentioned.
        String to = "mitul.kapoor@accoliteindia.com";

        // Sender's email ID needs to be mentioned
        String from = "mitul.kapoor@accoliteindia.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        properties.setProperty("mail.user", "saumyadeepjndi@gmail.com");
        properties.setProperty("mail.password", "jndijndi123123");
        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
*/

}

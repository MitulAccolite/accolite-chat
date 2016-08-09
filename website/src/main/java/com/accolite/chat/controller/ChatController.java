package com.accolite.chat.controller;

import com.accolite.chat.dao.*;
import com.accolite.chat.dao.impl.*;
import com.accolite.chat.model.*;
import com.accolite.chat.model.Message;
import com.accolite.chat.model.Role;
import manager.ChatManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by Mitul Kapoor on 7/31/2016.
 */
@Controller
public class ChatController {

    /*private List<User> activeUsers = new ArrayList<User>();

    @RequestMapping(value = "/authenticate")
    public ModelAndView authenticate(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("authenticate");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value = "/chatRoom")
    public ModelAndView chatRoom(
            @RequestParam("user") User user,
            HttpServletRequest servletRequest) throws Exception {
                ModelAndView modelAndView = new ModelAndView("chat_room");
            modelAndView.addObject("user",user);
            String details = "Name : " + user.getFirstName() + "email : " +user.getEmail();
                System.out.println(details);
        return modelAndView;
    }

    @RequestMapping(value = "/error")
    public ModelAndView error(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("error404");
        return modelAndView;
    }*/

    @RequestMapping(value = "/getstarted")
    public ModelAndView getStarted(HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("authenticate");
        return modelAndView;
    }

    @RequestMapping(value = "/registered_user")
    public ModelAndView registeredUser(
                                              @ModelAttribute("user")UserRegistration registration,
                                              HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("registered_user");
        String firstName = registration.getFirstName();
        String middleName = registration.getMiddleName();
        String lastName = registration.getLastName();
        String nickName = registration.getNickName();
        String email = registration.getUserMail();
        String password = registration.getUserPassword();
        String phone = registration.getUserMobile();
        System.out.println(registration.toString());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        //check whether the user is already registereed or not.
        //to be done here.

        Role role = new Role(Roles.USER);
        List<Role> userRole = new ArrayList<Role>();
        userRole.add(role);
        Credential credential = new Credential(email,password,date,date);

        User user = new User(firstName,middleName,lastName,date,date,true,nickName,email,userRole,credential);
        UserDao userDao = new UserDao();
        userDao.addNewUser(user);

        ILoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        loginCredentialsDao.addUser(credential);

        IUserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.addUserRole(userDao.getUserId(email), Roles.USER);

        OfflineUsers offlineUsers = new OfflineUsers();
        offlineUsers.notifyUsersForNewRegistration(firstName,nickName);

        return modelAndView;
    }


    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value = "/validate")
    public ModelAndView validateUserCredentials(
                                                       @RequestParam("user_login")String username,
                                                       @RequestParam("user_password")String password,
                                                       HttpServletRequest servletRequest) throws Exception {

        System.out.println("username : " + username);
        System.out.println("password : " + password);

        ModelAndView modelAndView  = null;
        ILoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        Credential user = loginCredentialsDao.verifyCredentials(username, password);
        if (user==null) {
            return new ModelAndView("error404");
        }
        System.out.println("User Details : ");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Password : " + user.getPassword());
        modelAndView = new ModelAndView("chat_room");
        IUserDao userDao = new UserDao();
        User user1 = userDao.findUserByEmail(user.getUsername());

        servletRequest.getSession().setAttribute("user",user1);
        modelAndView.addObject("user", user1);
        ChatManager.setUserOnline(user1);


        ///////
        List<Message> message = (List<Message>) (new MessageDao()).showMessagesToPersonInGroup(user1.getId(),1);
        modelAndView.addObject("messages",message);

        if(message.size() >0 ) {
            for (Message message1 : message) {
                System.out.println("user : " + message1.getUser().getNickName() + " message : " + message1.getMessage());
            }
        }

        /////

        return modelAndView;
    }

    @RequestMapping(value = "/profileView")
    public ModelAndView profileView(
                                           @RequestParam("user")String username,
                                           HttpServletRequest servletRequest) throws Exception {

        if(servletRequest.getSession().getAttribute("user")==null){
            return new ModelAndView("error403");
        }

        ModelAndView modelAndView = new ModelAndView("profile_view");
        IUserDao userDao = new UserDao();
        System.out.println("user email : " + username);
        User user = userDao.findUserByEmail(username);

        modelAndView.addObject("user",user);
        System.out.println("Profile view : ");
        System.out.println("user name : " + user.getFirstName());
        return modelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("index");
        servletRequest.getSession().removeAttribute("user");
        return modelAndView;
    }

    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    public ModelAndView postMessage(
                                           @RequestParam("message")String message,
                                           @RequestParam("userID")int userid,
                                           @RequestParam("userEmail")String userEmail,
                                           @RequestParam("created")Long date,
                                           @RequestParam("groupID")int groupid,
                                           HttpServletRequest servletRequest){

        System.out.println("values obtained : " + message + " : " + userid);
        IMessageDao messageDao = new MessageDao();
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(userEmail);
        Message message1 = new Message(message,new Date(date),user);

        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup chatGroup = chatGroupDao.findById(groupid);

        message1.setChatGroup(chatGroup);

        messageDao.save(message1);

        System.out.println("Message saved successfully");

        return new ModelAndView("chat_room");
        //return message;
    }

    @RequestMapping(value = "userprofile")
    public ModelAndView userprofile(HttpServletRequest servletRequest,
                                    @RequestParam("user")String email){

        ModelAndView modelAndView = new ModelAndView("userprofile");
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "groupView")
    public ModelAndView groupView(HttpServletRequest servletRequest,
                                  @RequestParam("groupID")int groupID,
                                  @RequestParam("userEmail")String email
                                  ){
        ModelAndView modelAndView = new ModelAndView("groupview");
        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup group = chatGroupDao.getChatGroupById(groupID);

        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);

        modelAndView.addObject("user",user);
        modelAndView.addObject("group",group);
        return modelAndView;
    }

    @RequestMapping(value = "/profile_edit")
    public ModelAndView ediProfile(
            @RequestParam("userEmail")String email,
            HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("profile_edit");
        modelAndView.addObject("user",(new UserDao()).findUserByEmail(email));
        return modelAndView;
    }
}

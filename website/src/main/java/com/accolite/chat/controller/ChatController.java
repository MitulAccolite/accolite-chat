package com.accolite.chat.controller;

import com.accolite.chat.dao.impl.ChatGroupDao;
import com.accolite.chat.dao.impl.LoginCredentialsDao;
import com.accolite.chat.dao.impl.UserDao;
import com.accolite.chat.dao.impl.UserRoleDao;
import com.accolite.chat.model.*;
import com.accolite.chat.model.Role;
import manager.ChatManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/profileView")
    public ModelAndView profileView(
            //@ModelAttribute("user")User user,
            @RequestParam("user")String username,
            HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("profile_view");
        UserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(username);
        modelAndView.addObject("user",user);
        System.out.println("Profile view : ");
        System.out.println("user name : " + user.getFirstName());
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

        //check whether the user is already registereed or not.
        //to be done here.

        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        User user = new User(firstName,middleName,lastName,date,date,true,nickName,email);
        UserDao userDao = new UserDao();
        userDao.addNewUser(user);

        LoginCredentials loginCredentials = new LoginCredentials(email,password,date,date,userDao.getUserId(email));
        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        loginCredentialsDao.addUser(loginCredentials);

        UserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.addUserRole(userDao.getUserId(email),"USER");

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
            LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
            LoginCredentials user = loginCredentialsDao.verifyCredentials(username, password);
            if (user==null) {
                return new ModelAndView("error404");
            }
        System.out.println("User Details : ");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Password : " + user.getPassword());
        modelAndView = new ModelAndView("chat_room");
            UserDao userDao = new UserDao();
            User user1 = userDao.findUserByEmail(user.getUsername());

        servletRequest.setAttribute("user",user1);
            modelAndView.addObject("user", user1);
        ChatManager.setUserOnline(user1);
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
/*
    @RequestMapping(value = "/registered_user")
    public ModelAndView register(
            @ModelAttribute("user")UserRegistration registration,
            HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("registered_user");


        System.out.println("User name : " + registration.getFirstName() + " " + registration.getMiddleName() + " " + registration.getLastName());
        System.out.println("Password : " + registration.getUserPassword());
        System.out.println("Mail : " + registration.getUserMail());
        return modelAndView;
    }*/


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

        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        loginCredentialsDao.addUser(credential);

        UserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.addUserRole(userDao.getUserId(email), Roles.USER);

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
        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        Credential user = loginCredentialsDao.verifyCredentials(username, password);
        if (user==null) {
            return new ModelAndView("error404");
        }
        System.out.println("User Details : ");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Password : " + user.getPassword());
        modelAndView = new ModelAndView("chat_room");
        UserDao userDao = new UserDao();
        User user1 = userDao.findUserByEmail(user.getUsername());

        servletRequest.setAttribute("user",user1);
        modelAndView.addObject("user", user1);
        ChatManager.setUserOnline(user1);

        return modelAndView;
    }


    @RequestMapping(value = "/profileView")
    public ModelAndView profileView(
           @RequestParam("user")String username,
           HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("profile_view");
        UserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(username);
        modelAndView.addObject("user",user);
        System.out.println("Profile view : ");
        System.out.println("user name : " + user.getFirstName());
        return modelAndView;
    }


}

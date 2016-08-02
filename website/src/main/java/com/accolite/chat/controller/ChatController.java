package com.accolite.chat.controller;

import com.accolite.chat.dao.LoginCredentialsDao;
import com.accolite.chat.dao.UserDao;
import com.accolite.chat.model.LoginCredentials;
import com.accolite.chat.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/31/2016.
 */
@Controller
public class ChatController {

    private List<User> activeUsers = new ArrayList<User>();

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

    @RequestMapping(value = "/validate")
    public ModelAndView validateUserCredentials(
            @RequestParam("user_login")String username,
            @RequestParam("user_password")String password,
            HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView;
        LoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        LoginCredentials user = loginCredentialsDao.verifyCredentials(username,password);
        if(user!=null){
            //////
            UserDao userDao = new UserDao();
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            userDao.addNewUser(new User("mitul","k","kapoor",date,date,true,"Mit","qwe@qwe.com"));
            //////
            modelAndView = new ModelAndView("chat_room");
            User user1 = userDao.findUserByEmail(username);
            modelAndView.addObject("user",user1);
            return modelAndView;
        }
        modelAndView = new ModelAndView("error404");
        return modelAndView;
    }


    @RequestMapping(value = "/chatRoom")
    public String chatRoom(
            @RequestParam("user") User user,
            HttpServletRequest servletRequest) throws Exception {
            String details = "Name : " + user.getFirstName() + "email : " +user.getEmail();
                System.out.println(details);
        return details;
    }


    @RequestMapping(value = "/error")
    public ModelAndView error(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("error404");
        return modelAndView;
    }

}

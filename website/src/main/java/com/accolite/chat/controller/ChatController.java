package com.accolite.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mitul Kapoor on 7/31/2016.
 */
@Controller
public class ChatController {

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value = "/chatRoom")
    public ModelAndView chatRoom(
            @RequestParam("user_login")String username,
            @RequestParam("user_password")String password,
            HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("chat_room");
        modelAndView.addObject("username",username);
        modelAndView.addObject("password",password);
        return modelAndView;
    }


    @RequestMapping(value = "/error")
    public ModelAndView error(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("error404");
        return modelAndView;
    }



}

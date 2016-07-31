package com.accolite.chat.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
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


}

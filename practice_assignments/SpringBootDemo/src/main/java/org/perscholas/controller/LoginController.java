package org.perscholas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = {  "/login" }, method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }

    @RequestMapping(value = {  "/logoutSuccess" }, method = RequestMethod.GET)
    public ModelAndView logoutSuccess() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/logoutSuccess");
        return response;
    }



}



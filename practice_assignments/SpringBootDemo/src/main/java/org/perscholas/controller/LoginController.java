package org.perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @RequestMapping(value =  "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute("username");

        //checks if user is already logged in
        if ( StringUtils.equals(username, "tom")) {
            response.setViewName("login/loginSuccess");
            response.addObject("username", username);
        } else {
            response.setViewName("login/login");
        }

        return response;
    }

    @RequestMapping(value =  "/loginSubmit", method = RequestMethod.GET)
    public ModelAndView loginSubmit(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //saves username and password to session if correct values are submitted in the form
        if ( StringUtils.equals(username, "tom") && StringUtils.equals(password,"jerry")) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.setViewName("login/loginSuccess");
            return response;
        }

        //refers to the name of the jsp file it will load
        response.setViewName("login/login");

        return response;
    }
}

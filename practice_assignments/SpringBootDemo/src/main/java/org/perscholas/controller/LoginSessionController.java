package org.perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.form.LoginFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/session")
public class LoginSessionController {

    private static String SESSION_KEY = "username";
    private static String SESSION_ERROR_MESSAGE = "";

    @RequestMapping(value =  "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute("username");

        //checks if user is already logged in
        if ( StringUtils.equals(username, "tom")) {
            response.setViewName("redirect:/loginSubmit2");
//            response.addObject("username", username);
        } else {
            response.addObject("loginFailed", "Invalid username or password");
            response.setViewName("login/login");
        }

        return response;
    }

//    @RequestMapping(value =  "/loginSubmit", method = RequestMethod.GET)
//    public ModelAndView loginSubmit(HttpServletRequest request, HttpSession session) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //saves username and password to session if correct values are submitted in the form
//        if ( StringUtils.equals(username, "tom") && StringUtils.equals(password,"jerry")) {
//            session.setAttribute("username", username);
//            session.setAttribute("password", password);
//            response.setViewName("redirect:/success");
//        } else {
//            session.setAttribute("username", null);
//            response.setViewName("redirect:/login");
//        }
//
//        return response;
//    }


    //better way of accessing username and password
    @RequestMapping(value = "/loginSubmit2", method = RequestMethod.GET)
    public ModelAndView loginFormSubmit(LoginFormBean form, HttpSession session ) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = form.getUsername();
        String password = form.getPassword();

        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute(SESSION_KEY, form.getUsername());
            response.setViewName("redirect:/success");
        } else {
            // invalid login
            // setting session to null to ensure the user is logged out
            response.addObject(SESSION_KEY, null);
            response.addObject(SESSION_ERROR_MESSAGE, "Incorrect username or password");
            response.setViewName("redirect:/login");
        }

        return response;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        // this method is checking to see if the user is logged in by looking at the session
        // if logged in ( user is in the session ) then show the success page.
        // if not logged in ( user is not in the session ) then show the login page
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute("username");
        if (StringUtils.equals(username, "tom")) {
            response.addObject("username", username);
            response.setViewName("/login/loginSuccess");
        } else {
            // need to implement here to redirect back to login page
            // because it means the user has requested the /success url
            // but is not in the session
            response.setViewName("redirect:/login");
        }

        return response;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) throws Exception {
        // this is how to destroy the current user session
        // always implement a logout method this way.
        session.invalidate();
        ModelAndView response = new ModelAndView();
        // this is how to do a redirect in spring mvc usin the model
        // this will change the url to be localhost:8080/login
        // which is preferable because the URL is the same as the page you are on
        response.setViewName("redirect:/login");

        // doing it this way will work but is not best practice
        //response.setViewName("login/login");

        return response;
    }
}
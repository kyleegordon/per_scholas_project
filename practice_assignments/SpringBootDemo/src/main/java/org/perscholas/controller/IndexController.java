package org.perscholas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    //tells tomcat server to listen on "/" and "/index", then creates model view and sets name to index
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        //refers to the name of the jsp file
        response.setViewName("index");

        return response;
    }


    @RequestMapping(value= {"/indexSubmit" }, method = RequestMethod.GET)
    public ModelAndView indexSubmit(HttpServletRequest request, HttpSession session) throws Exception {

        //collects data from the html form
        //must have names assigned to each input for this to work, .getParameter arg must match name
        String companyName = request.getParameter("company_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        String numEmployees = request.getParameter("employees");
        String industry = request.getParameter("industry");
        String securityProfessionals= request.getParameter("security_professionals");
        //figure out how to collect multiple values from checkboxes, right now it only gets one
        String dataTypes= request.getParameter("data_types");

        //saves a value in the session so it can continue to be accessed throughout the program until the session ends
        session.setAttribute("company_name", companyName);

        //the following code allows you to pass variables to the jsp page that it redirects to
        ModelAndView response = new ModelAndView();
        response.addObject("company_name", companyName);
        response.addObject("email", email);
        response.addObject("password", password);
        response.addObject("phone", phone);
        response.addObject("website", website);
        response.addObject("employees", numEmployees);
        response.addObject("industry", industry);
        response.addObject("security_professionals", securityProfessionals);
        response.addObject("data_types", dataTypes);

        //this redirects page to indexSubmit
        response.setViewName("indexSubmit");

        return response;
    }

}

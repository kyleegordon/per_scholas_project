package org.perscholas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}

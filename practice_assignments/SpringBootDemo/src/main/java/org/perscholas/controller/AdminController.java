package org.perscholas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = {  "/home" }, method = RequestMethod.GET)
    public ModelAndView adminHome() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/home");
        return response;
    }
}


package org.perscholas.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @RequestMapping(value = {  "/user/profile" }, method = RequestMethod.GET)
    public ModelAndView userProfile() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");
        return response;
    }
}

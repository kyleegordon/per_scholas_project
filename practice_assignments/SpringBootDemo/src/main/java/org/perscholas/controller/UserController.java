package org.perscholas.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//automatically sets up logging
@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = {  "/user/profile" }, method = RequestMethod.GET)
    public ModelAndView userProfile() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);


        return response;
    }
}

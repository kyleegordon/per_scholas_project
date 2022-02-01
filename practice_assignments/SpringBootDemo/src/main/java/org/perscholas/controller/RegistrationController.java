package org.perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.perscholas.form.RegisterFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value =  "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        return response;
    }

    @RequestMapping(value =  "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.addObject("formBeanKey", form);
        response.setViewName("registration/register");

        System.out.println(form);

        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("Error: " + error.getField() + " " + error.getDefaultMessage());
            }


            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        } else {
            //there are no errors, redirect to the login page
            //you would save the user info to the database at this point
            User user = new User();
            user.setUsername(form.getUsername());
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setPassword(form.getPassword());
            userDao.save(user);
            response.setViewName("registration/userList");
        }
        return response;
    }

    @RequestMapping(value =  "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        //this finds all users with a firstname that matches the value saved in search
        //can then be used to display user info on userList.jsp
        if (!StringUtils.isEmpty(search)) {
            List<User> users = userDao.findByFirstName(search);
            response.addObject("userListKey", users);
        }



        return response;
    }
}

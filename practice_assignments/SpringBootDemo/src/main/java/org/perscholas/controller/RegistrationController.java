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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    @Autowired
    private UserDAO userDao;


//    @RequestMapping(value =  "/register", method = RequestMethod.GET)
//    public ModelAndView register() throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("registration/register");
//
//        return response;
//    }

    //if this method is called with an id it will be a create
    //if this method is called with an id it will be an edit
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");


        if (id != null) {
            //id has been passed so it is an update
            User user = userDao.findById(id);

            RegisterFormBean form = new RegisterFormBean();
            form.setEmail((user.getEmail()));
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setPassword(user.getPassword());
            form.setId(user.getId());

            response.addObject("formBeanKey", form);

        } else {
            //an id has not been passed, will create new
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.addObject("formBeanKey", form);
        response.setViewName("registration/register");

        System.out.println(form);

        //Create from CRUD
        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("Error: " + error.getField() + " " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        } else {
            //there are no errors, so this is either a create or an update request
            //you would save the user info to the database at this point
            User user = new User();

            if(form.getId() != null) { //this indicates an update, must load user from database first
                //this finds user info from database and assigns it to user, which will ensure the id
                // is set before updating information
                user = userDao.findById(form.getId());
            }

            //if id is null, it will not have been set already which will prompt the database to create a new user
            //if id was not null and user id was set above, it will instead update the information
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

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search,
                                 @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        //this finds all users with a firstname that matches the value saved in search
        //can then be used to display user info on userList.jsp
        if (!StringUtils.isEmpty(search)) {
            List<User> users = userDao.findByFirstName(search);
            response.addObject("userListKey", users);
            response.addObject("searchFormValue", search);
        }

        if (!StringUtils.isEmpty(firstName) || !StringUtils.isEmpty(lastName)) {
            List<User> users = userDao.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);
            response.addObject("firstNameForm1", firstName);
            response.addObject("lastNameForm1", lastName);
        }


        return response;
    }

    @RequestMapping(value = "/userListResult", method = RequestMethod.GET)
    public ModelAndView userListResult(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        //search by first and last name case insensitive
        //Read of CRUD
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            List<User> users = userDao.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);
            response.addObject("firstNameForm2", firstName);
            response.addObject("lastNameForm2", lastName);
        }


        return response;
    }


    //this deletes user from database
    //can add javascript on jsp page to display an alert that asks user if they are sure they want to delete and/or confirm it has been deleted
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(required = true) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/registration/userList");

        User delete = userDao.findById(id);
        userDao.delete(delete);
        return response;
    }
}

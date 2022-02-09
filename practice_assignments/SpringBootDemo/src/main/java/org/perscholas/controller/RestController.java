package org.perscholas.controller;

import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@Controller - this is included in @RestController
//@ResponseBody - this is included in @RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    private UserDAO userDAO;

    //in a rest controller, a get method is always used for reads
    //REST controllers always return JSON

    //https://www.baeldung.com/spring-pathvariable
    //this url for this method changes based on the variable id
    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        User user = userDAO.findById(id);
        return user;
    }

    @GetMapping("/list")
    public List<User> getList(@RequestParam String firstName) {
        List<User> users = userDAO.findByFirstName(firstName);
        return users;
    }
}

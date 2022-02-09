package org.perscholas.controller;

import org.json.JSONObject;
import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
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
    //this url for this method contains the variable id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable Integer id) {
        User user = userDAO.findById(id);
        return user;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getList(@RequestParam String firstName) {
        List<User> users = userDAO.findByFirstName(firstName);
        return users;
    }

    //this method deleted user found by id and returns success confirmation as JSON
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> delete(@PathVariable Integer id) {
        User user = userDAO.findById(id);

        if (id != null && user != null) {
            userDAO.delete(user);
            return new ResponseEntity<Long>(id.longValue(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }





//        JSONObject jo = new JSONObject();
//        jo.put("status", "success");
//
//        return jo.toString();
    }
}

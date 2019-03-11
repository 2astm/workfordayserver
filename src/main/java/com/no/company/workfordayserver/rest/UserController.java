package com.no.company.workfordayserver.rest;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    //FULL PATH: localhost:8080/user/test

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;

    }

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        if (user.getLogin() != null && (user.getPassword() != null)) {
            service.addUser(user);
        }
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeUser(@RequestBody User user, @RequestHeader(name = "login") String login,
                           @RequestHeader(name = "password") String password) {

        service.updateUser(user.getId(), user);
    }

    /*
    TODO think about it
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestBody User user) {
        service.remove(user);
    }
    */

}
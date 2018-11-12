package com.no.company.workfordayserver.rest;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    //FULL PATH: localhost:8080/user/test

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
/*
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void test(@RequestBody User user, @RequestHeader(name = "login") String login, @RequestHeader(name = "password") String password){
        User oldUser = userService.getUserByLogin(login);
        if (oldUser != null && oldUser.getPassword().equals(password)){
            userService.updateUser(oldUser.getId(), user);
        }
    }*/
}

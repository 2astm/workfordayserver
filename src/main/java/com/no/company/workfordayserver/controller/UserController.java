package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void setUser(@RequestBody User newUser){
        userService.saveUser(newUser);
    }

    @RequestMapping(value = "/get")

    public User getUser(Principal principal){
        Optional<User> user = userService.getUserByEmail(principal.getName());
        if (user.isPresent()) {
            user.get().setPassword(null);
            return user.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    /*
      Todo Secutirty need
      Todo editData
     */

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

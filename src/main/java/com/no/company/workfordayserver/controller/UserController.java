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

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    /*
      Todo create User
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void setUser(@RequestBody User newUser){
        userService.saveUser(newUser);
    }
    /*
      Todo Secutirty need
      Todo getUserBy email and password
     */
    @RequestMapping(value = "/get")
   // @Secured(SecurityRoles.USER)
    public User getUser(@RequestParam(name = "email") String email){
        System.out.println(email);
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isPresent())
            return user.get();
        else{
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

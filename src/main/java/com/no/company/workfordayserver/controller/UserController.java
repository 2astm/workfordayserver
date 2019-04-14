package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.controller.jsonmodels.UserEdit;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.PrinterIOException;
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
        User user = userService.getUserByEmail(principal.getName());
        user.setPassword(null);
        return user;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editUser(Principal principal, @RequestBody User user){
        user.setIsUser(null);
        userService.editUser(user, principal.getName());
    }

    @RequestMapping(value = "/editchooseduser", method = RequestMethod.POST)
    public void editChoosedUser(@RequestBody UserEdit userEdit){
        userService.editUser(userEdit, userEdit.getUserMailToEdit());
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}



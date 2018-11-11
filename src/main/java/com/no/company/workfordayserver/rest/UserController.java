package com.no.company.workfordayserver.rest;


import com.no.company.workfordayserver.entities.Dispute;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.services.DisputeService;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.lang.ref.ReferenceQueue;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //FULL PATH: localhost:8080/user/test
    @RequestMapping(value = "/test")
    public String test(){
        return "Hello world";
    }

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        if (user.getLogin() != null && (user.getPassword() != null)) {
            user.setDateRegister(new Date());
            user.setDateUpdate(user.getDateRegister());
            service.addUser(user);
        }
    }

    @RequestMapping(value = "/change,", method = RequestMethod.PUT)
    public void changeUser(@RequestBody User user, @RequestHeader(name = "login") String login, @RequestHeader(name = "password") String password) {
        User oldUser = service.getUserByLogin(login);
        if (oldUser.getPassword().equals(password)) {
            service.updateUser(oldUser.getId(), user);
        } 
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestBody User user) {
        service.remove(user);
    }
}

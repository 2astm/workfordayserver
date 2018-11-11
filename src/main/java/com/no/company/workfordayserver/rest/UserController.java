package com.no.company.workfordayserver.rest;


import com.no.company.workfordayserver.entities.Dispute;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.services.DisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //FULL PATH: localhost:8080/user/test
    @RequestMapping(value = "/test")
    public String test(){
        return "Hello world";
    }
}

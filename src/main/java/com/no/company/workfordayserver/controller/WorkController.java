package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.services.WorkService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/work")
public class WorkController {

    private WorkService workService;

    @RequestMapping(value = "/addwork", method = RequestMethod.POST)
    public void addWork(Authentication authentication, @RequestBody Work work){
        workService.saveWork(work, (User) authentication.getPrincipal());
        System.out.println(work.getHashtags().get(0).getName());
    }

    /*
    Todo editwork
     */
    @RequestMapping(value = "/changework", method = RequestMethod.POST)
    public void changeWork(Authentication authentication, @RequestBody Work work) throws NotFoundException {
        if (work.getId() == null) throw new NullPointerException("ID not selected");
        workService.editWork(work, (User) authentication.getPrincipal());
        System.out.println(work.getHashtags());
    }
    /*
    Todo get list of works (need pages), also filters
     */

    /*
    Todo get work by id without phone number
     */

    /*
    Todo Secutirty need
    Todo get work by id
     */

    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }
}

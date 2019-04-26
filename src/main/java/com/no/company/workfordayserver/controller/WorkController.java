package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.jsonmodels.FiltersForWork;
import com.no.company.workfordayserver.services.WorkService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/work")
public class WorkController {

    private WorkService workService;

    @RequestMapping(value = "/addwork", method = RequestMethod.POST)
    public void addWork(Authentication authentication, @RequestBody Work work){
        workService.saveWork(work, (User) authentication.getPrincipal());
//        System.out.println(work.getHashtags().get(0).getName());
    }

    @RequestMapping(value = "/changework", method = RequestMethod.POST)
    public void changeWork(Authentication authentication, @RequestBody Work work) throws NotFoundException {
        if (work.getId() == null) throw new NullPointerException("ID not selected");
        workService.editWork(work, (User) authentication.getPrincipal());
        System.out.println(work.getHashtags());
    }

    @RequestMapping(value = "/getwork")
    public Work getWork(Authentication authentication, @RequestParam(name = "id") Long id) throws NotFoundException {
        if(authentication.isAuthenticated()){
            return workService.getWork(id);
        }else{
            Work work = workService.getWork(id);
            work.setPhoneNumbers(null);
            return work;
        }
    }

    @RequestMapping(value = "/removework")
    public void removeWork(Authentication authentication, @RequestParam(name = "id") Long id){
        workService.deleteWork(id, (User) authentication.getPrincipal());
    }

    @RequestMapping(value ="/getworkswithfilters")
    public List<Work> getWorks(Authentication authentication, @RequestBody FiltersForWork filtersForWork){
            /*
    Todo get list of works (need pages), also filters
     */
            return null;
    }

    @RequestMapping(value = "/saveWork")
    public void saveWork(Authentication authentication, @RequestParam(name ="id") Long id){
        workService.addToSaved();
    }

    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }
}

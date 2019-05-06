package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.UserSaveWork;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.jsonmodels.FiltersForWork;
import com.no.company.workfordayserver.services.UserSaveWorkService;
import com.no.company.workfordayserver.services.WorkService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/work")
public class WorkController {

    private WorkService workService;
    private UserSaveWorkService userSaveWorkService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addWork(Authentication authentication, @RequestBody Work work){
        workService.saveWork(work, (User) authentication.getPrincipal());
//        System.out.println(work.getHashTags().get(0).getName());
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public void changeWork(Authentication authentication, @RequestBody Work work) throws NotFoundException {
        if (work.getId() == null) throw new NullPointerException("ID not selected");
        workService.editWork(work, (User) authentication.getPrincipal());
        System.out.println(work.getHashTags());
    }

    @RequestMapping(value = "/get")
    public Work getWork(Authentication authentication, @RequestParam(name = "id") Long id) throws NotFoundException {
        if(authentication.isAuthenticated()){
            return workService.getWork(id);
        }else{
            Work work = workService.getWork(id);
            work.setPhoneNumbers(null);
            return work;
        }
    }

    @RequestMapping(value = "/remove")
    public void removeWork(Authentication authentication, @RequestParam(name = "id") Long id){
        workService.deleteWork(id, (User) authentication.getPrincipal());
    }

    @RequestMapping(value ="/getwithfilters")
    public List<Work> getWorks(Authentication authentication, @RequestBody FiltersForWork filtersForWork){
        List<Work> works = workService.getWorks(filtersForWork);
        if (!authentication.isAuthenticated())
            works.stream().forEach(work -> work.setPhoneNumbers(null));
        return works;
    }

    @RequestMapping(value = "/addtosave")
    public void saveWork(Authentication authentication, @RequestParam(name ="id") Long workID){
        userSaveWorkService.addToSavedWork(((User) authentication.getPrincipal()).getId(), workID);
    }

    @RequestMapping(value = "/getsaved")
    public List<UserSaveWork> getSavedWorks(Authentication authentication, @RequestParam(name = "page") int page, @RequestParam(name="results") int results){
        return userSaveWorkService.getSavedWorks(((User) authentication.getPrincipal()).getId(), page, results);
    }


    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }

    @Autowired
    public void setUserSaveWorkService(UserSaveWorkService userSaveWorkService) {
        this.userSaveWorkService = userSaveWorkService;
    }
}

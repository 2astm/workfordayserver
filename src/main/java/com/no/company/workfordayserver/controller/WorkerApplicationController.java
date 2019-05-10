package com.no.company.workfordayserver.controller;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.UserSaveWorkerApplication;
import com.no.company.workfordayserver.entities.WorkerApplication;
import com.no.company.workfordayserver.jsonmodels.FiltersForWorkerApplication;
import com.no.company.workfordayserver.services.UserSaveWorkerApplicationService;
import com.no.company.workfordayserver.services.WorkerApplicationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workerapplication")
public class WorkerApplicationController {

    private WorkerApplicationService workerApplicationService;
    private UserSaveWorkerApplicationService userSaveWorkerApplicationService;

     @RequestMapping(value = "/add", method = RequestMethod.POST)
     public void addWork(Authentication authentication, @RequestBody WorkerApplication workerApplication){
         workerApplicationService.saveWorkerApplication(workerApplication, workerApplication.getUser());//(User) authentication.getPrincipal());
     }

     @RequestMapping(value = "/change", method = RequestMethod.POST)
     public void changeWork(Authentication authentication, @RequestBody WorkerApplication workerApplication) throws NotFoundException {
         if (workerApplication.getId() == null) throw new NullPointerException("ID not selected");
         workerApplicationService.editWorkerApplication(workerApplication, (User) authentication.getPrincipal());
     }

     @RequestMapping(value = "/get")
     public WorkerApplication getWork(Authentication authentication, @RequestParam(name = "id") Long id) throws NotFoundException {
         if(authentication.isAuthenticated()){
             return workerApplicationService.getWorkerApplication(id);
         }else{
             WorkerApplication workerApplication = workerApplicationService.getWorkerApplication(id);
             workerApplication.setPhoneNumbers(null);
             return workerApplication;
         }
     }

     @RequestMapping(value = "/remove")
     public void removeWork(Authentication authentication, @RequestParam(name = "id") Long id){
         workerApplicationService.deleteWorkerApplication(id, (User) authentication.getPrincipal());
     }

     @RequestMapping(value ="/getwithfilters")
     public List<WorkerApplication> getWorkerApplications(Authentication authentication, @RequestBody FiltersForWorkerApplication filtersForWorkerApplication){
            /*
    Todo get list of works (need pages), also filters
     */
         return null;
     }

     @RequestMapping(value = "/getapplications")
     public List<WorkerApplication> getApplications(@RequestParam(name = "page") Integer page, @RequestParam(name = "results") Integer results){
         List<WorkerApplication> workerApplications =  workerApplicationService.getWorks(page, results);
         workerApplications.stream().map(workerApplication -> {
             workerApplication.setPhoneNumbers(null);
             User user = new User();
             user.setEmail(workerApplication.getUser().getEmail());
             user.setPhoto(workerApplication.getUser().getPhoto());
             workerApplication.setUser(user);
             return workerApplication;
         });
         return workerApplications;
     }

     @RequestMapping(value = "/addtosaved")
     public void saveWorkerApplication(Authentication authentication, @RequestParam(name ="id") Long workerApplicationID){
         userSaveWorkerApplicationService.addToSavedWorkerApplication(((User) authentication.getPrincipal()).getId(), workerApplicationID);
     }

     @RequestMapping(value = "/getsaved")
     public List<UserSaveWorkerApplication> getSavedWorks(Authentication authentication, @RequestParam(name = "page") int page, @RequestParam(name="results") int results){
         return userSaveWorkerApplicationService.getSavedWorkerApplications(((User) authentication.getPrincipal()).getId(), page, results);
     }
    /*
    Todo addWork
     */

    /*
    Todo editwork
     */

    /*
    Todo get list of workerApplication (need pages), also filters
     */

    /*
    Todo get workerApplications by id without phone number
     */

    /*
    Todo Secutirty need
    Todo get workerApplication by id
     */

    @Autowired
    public void setWorkerApplicationService(WorkerApplicationService workerApplicationService) {
        this.workerApplicationService = workerApplicationService;
    }
}

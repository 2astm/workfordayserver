package com.no.company.workfordayserver.rest;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.entities.WorkerRequest;
import com.no.company.workfordayserver.services.UserService;
import com.no.company.workfordayserver.services.WorkerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workRequest")
public class WorkersRequestController {

    private WorkerRequestService service;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setService(WorkerRequestService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addRequest")
    public void addRequest(@RequestBody WorkerRequest workerRequest){
        service.addWorkerRequest(workerRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRequestsByUser")
    public List<WorkerRequest> getRequestsByUser(@RequestBody User user){
        return service.getRequestsByUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRequestsByVacancy")
    public List<WorkerRequest> getRequestsByVacancy(@RequestBody Vacancy vacancy){
        return service.getRequestsByVacancy(vacancy);
    }

    //NEED AUTORIZATION
    @RequestMapping(method = RequestMethod.GET, value = "/changeStatus")
    public void setStatus(@RequestParam(name = "id") long id, @RequestParam(name = "new_status") WorkerRequest.State_request state,
                          @RequestParam(name = "login")String login, @RequestParam(name = "password") String password){

        Optional<User> user = userService.getUserByLogin(login);

        if (state == WorkerRequest.State_request.Closed && user.isPresent()){
            service.setStatusByRequestCreator(id, user.get().getId(), state);
            return;
        }/*
        if (state != null){
            service.setStatusByVacancyCreator(id, userService.getUserByLogin(login).getId(), state);
            if (state == WorkerRequest.State_request.Approved);

        }*/
    }
}

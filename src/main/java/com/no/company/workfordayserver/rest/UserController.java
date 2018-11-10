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
public class UserController {

    @Autowired
    private DisputeService service;

    @RequestMapping(value = "/saveDispute/", method = RequestMethod.GET)
    public List saveDispute(){
//        System.out.println("Called");
//        Dispute dispute = new Dispute();
//        dispute.setState(Dispute.State.Proccecing);
//        dispute.setUser(new User());
//        dispute.setVacancy(new Vacancy());
//        service.addDispute(dispute);
        System.out.println(service.getAll().get(0).getState());
        return service.getAll();
    }
}

package com.no.company.workfordayserver.rest;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.services.VacancyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {



    private VacancyService service;

    @Autowired
    public void setService(VacancyService service) {
        this.service = service;
    }

    //FULL PATH: localhost:8080/vacancy/get
    @RequestMapping(value = "/getall")
    @ResponseBody
    public List<Vacancy> getAllVacancies(){
        return service.getAllVacancies();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public List<Vacancy> getVacancy(@RequestBody Vacancy vacancy){
        return service.getVacancy(vacancy);
    }


    //FULL PATH: localhost:8080/vacancy/add
    @RequestMapping(value = "/add")
    public void addVacancy(Vacancy vacancy){
        service.addVacancy(vacancy);
    }

    //FULL PATH: localhost:8080/vacancy/set/name
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public void setVacancyName(@RequestBody Vacancy vacancy){
       service.update(vacancy);
    }



    //FULL PATH: localhost:8080/vacancy/delete
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteVacancy(@RequestBody Vacancy vacancy){
        service.removeVacancy(vacancy);
    }

}
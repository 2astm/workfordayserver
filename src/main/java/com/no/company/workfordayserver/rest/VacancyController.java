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

    //PATH: /vacancy/getall/
    @RequestMapping(value = "/getall/", method = RequestMethod.GET)
    @ResponseBody
    public List<Vacancy> getAllVacancies(@RequestParam int page, @RequestParam int results){
        return service.getAllVacancies(page, results);
    }

    //PATH: /vacancy/get/
    @RequestMapping(value = "/get/", method = RequestMethod.POST)
    @ResponseBody
    public List<Vacancy> getVacancy(@RequestBody Vacancy vacancy){
        return service.getVacancy(vacancy);
    }

    //PATH: /vacancy/add/
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public void addVacancy(@RequestBody Vacancy vacancy){
        service.addVacancy(vacancy);
    }

    //PATH: /vacancy/set/
    @RequestMapping(value = "/set/", method = RequestMethod.POST)
    public void setVacancyName(@RequestBody Vacancy vacancy){
       service.update(vacancy);
    }

    //PATH: /vacancy/delete/
    @RequestMapping(value = "/delete/", method = RequestMethod.POST)
    public void deleteVacancy(@RequestBody Vacancy vacancy){
        service.removeVacancy(vacancy);
    }

}
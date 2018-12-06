package com.no.company.workfordayserver.rest;

import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.entities.Region;
import com.no.company.workfordayserver.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    private CityService service;

    @Autowired
    public void setService(CityService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByName")
    public City getCityObject(@RequestParam(name = "name")String name){
        return service.getCityByName(name);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAllCities/")
    public List<City> getCityList(){
        return service.getAllCities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCitiesByRegion/")
    public List<City> getCity(@RequestParam(name = "name")String name){
        return service.getCitiesByRegion(name); //TODO must be not null
    }

}

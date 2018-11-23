package com.no.company.workfordayserver.rest;

import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.entities.Region;
import com.no.company.workfordayserver.services.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/region")
public class RegionController {

    private RegionService service;

    public void setService(RegionService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByName/")
    public Region RegionGetRegionObject(@RequestParam(name = "name")String name){
        return service.getRegionByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRegions/")
    public List<Region> getRegionList(){
        return service.getAllRegions();
    }

}

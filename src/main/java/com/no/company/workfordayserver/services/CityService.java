package com.no.company.workfordayserver.services;


import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public Optional<City> getCityById(long id) {
        return repository.findById(id);
    }

    public void addCity(City s) {
        repository.saveAndFlush(s);
    }
}
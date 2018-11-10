package com.no.company.workfordayserver.services;


import com.no.company.workfordayserver.entities.Region;
import com.no.company.workfordayserver.repos.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository repository;

    public List<Region> getAllUsers() {
        return repository.findAll();
    }

    public Optional<Region> getUserById(long id) {
        return repository.findById(id);
    }

    public void addUser(Region s) {
        repository.saveAndFlush(s);
    }
}

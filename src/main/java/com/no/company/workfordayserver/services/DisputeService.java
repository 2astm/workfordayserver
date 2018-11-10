package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Dispute;
import com.no.company.workfordayserver.repos.DisputeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisputeService {

    @Autowired
    DisputeRepository repository;

    public void setRepository(DisputeRepository repository) {
        this.repository = repository;
    }

    public void addDispute(Dispute dispute){
        repository.save(dispute);
    }

    public List<Dispute> getAll(){ return repository.findAll(); }
}

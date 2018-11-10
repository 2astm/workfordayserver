package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Worker;
import com.no.company.workfordayserver.repos.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public void addWorker (Worker worker) {
        repository.save(worker);
    }
}

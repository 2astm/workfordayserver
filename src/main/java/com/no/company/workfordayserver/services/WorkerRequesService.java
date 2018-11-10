package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.WorkerRequest;
import com.no.company.workfordayserver.repos.WorkerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkerRequesService {

    @Autowired
    private WorkerRequestRepository repository;

    public void addWorkerRequest (WorkerRequest workerRequest) {
        repository.save(workerRequest);
    }
}

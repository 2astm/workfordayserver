package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.entities.WorkerRequest;
import com.no.company.workfordayserver.repos.WorkerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class WorkerRequestService {

    private WorkerRequestRepository repository;

    @Autowired
    public void setRepository(WorkerRequestRepository repository) {
        this.repository = repository;
    }

    public void addWorkerRequest (WorkerRequest workerRequest) {
        repository.save(workerRequest);
    }

    public List<WorkerRequest> getRequestsByUser(User user){
        return repository.findAllByUser(user);
    }
    public List<WorkerRequest> getRequestsByVacancy(Vacancy vacancy){
        return repository.findAllByVacancy(vacancy);
    }

    public void setStatusByRequestCreator(long id,long creatorRequestId, WorkerRequest.State_request state) {
        repository.setStateByRequestCreator(id, creatorRequestId, state);
    }

    public void setStatusByVacancyCreator(long id, long creatorVacancyId, WorkerRequest.State_request state) {
        repository.setStateByVacancyCreator(id, creatorVacancyId, state);
    }
}

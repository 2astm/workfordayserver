package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.WorkerApplication;
import com.no.company.workfordayserver.jsonmodels.FiltersForWork;
import com.no.company.workfordayserver.repos.WorkerApplicationRepostiory;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerApplicationService {

    private WorkerApplicationRepostiory workerApplicationRepostiory;

    public void saveWorkerApplication(WorkerApplication workerApplication, User user){
        //TODO need to save hashtags before if need
        workerApplication.setUser(user);
        workerApplicationRepostiory.save(workerApplication);
    }


    public void editWorkerApplication(WorkerApplication workerApplication, User user) throws NotFoundException {
        Optional<WorkerApplication> workerApplicationOld = workerApplicationRepostiory.findById(workerApplication.getId());
        if (!workerApplicationOld.isPresent()) throw new NotFoundException("Work not found");

        if (user.getIsUser() && !workerApplicationOld.get().getUser().getId().equals(user.getId())) throw new AccessDeniedException("You can't edit this work");
        //TODO need to save hastags before if need
        workerApplicationOld.get().setWorkerApplication(workerApplication);
        workerApplicationRepostiory.save(workerApplicationOld.get());
    }

    public WorkerApplication getWorkerApplication(Long id) throws NotFoundException {
        Optional<WorkerApplication> work = workerApplicationRepostiory.findById(id);
        if (work.isPresent()) return work.get();
        else throw new NotFoundException("Work not found");
    }

    public void deleteWorkerApplication(Long workerApplicationID, User user){
        workerApplicationRepostiory.deleteByIdAndUser(workerApplicationID, user);
    }

    public List<WorkerApplication> getWorks(FiltersForWork filtersForWorkerApplication){
        //TODO FILTER
        return null;
    }

    @Autowired
    public void setWorkerApplicationRepostiory(WorkerApplicationRepostiory workerApplicationRepostiory) {
        this.workerApplicationRepostiory = workerApplicationRepostiory;
    }
}

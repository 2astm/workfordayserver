package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.UserSaveWorkerApplication;
import com.no.company.workfordayserver.repos.UserSaveWorkerApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSaveWorkerApplicationService {
    private UserSaveWorkerApplicationRepository userSaveWorkerApplicationRepository;

    public void addToSavedWorkerApplication(Long userID, Long workerApplicationID){
        UserSaveWorkerApplication userSaveWorkerApplication = new UserSaveWorkerApplication(userID, workerApplicationID);
        userSaveWorkerApplicationRepository.save(userSaveWorkerApplication);
    }

    public List<UserSaveWorkerApplication> getSavedWorkerApplications(Long userID, int page, int results){
        return userSaveWorkerApplicationRepository.getSavedWorkerApplications(PageRequest.of(page, results), userID);
    }

    @Autowired
    public void setUserSaveWorkerApplicationRepository(UserSaveWorkerApplicationRepository userSaveWorkerApplicationRepository) {
        this.userSaveWorkerApplicationRepository = userSaveWorkerApplicationRepository;
    }
}

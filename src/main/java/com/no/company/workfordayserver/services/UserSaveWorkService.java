package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.UserSaveWork;
import com.no.company.workfordayserver.repos.jpa.UserSaveWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSaveWorkService {
    private UserSaveWorkRepository userSaveWorkRepository;

    public void addToSavedWork(Long userID, Long workID){
        UserSaveWork userSaveWork = new UserSaveWork(userID, workID);
        userSaveWorkRepository.save(userSaveWork);
    }

    public List<UserSaveWork> getSavedWorks(Long userID, int page, int results){
        return userSaveWorkRepository.getSavedWorks(PageRequest.of(page, results), userID);
    }

    @Autowired
    public void setUserSaveWorkRepository(UserSaveWorkRepository userSaveWorkRepository) {
        this.userSaveWorkRepository = userSaveWorkRepository;
    }
}

package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.jsonmodels.FiltersForWork;
import com.no.company.workfordayserver.repos.UserSaveWorkRepository;
import com.no.company.workfordayserver.repos.WorkRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    private WorkRepository workRepository;
    private UserSaveWorkRepository userSaveWorkRepository;

    public void saveWork(Work work, User user){

        //TODO need to save hashtags before if need
        work.setUser(user);
        workRepository.save(work);
    }

    public void editWork(Work work, User user) throws NotFoundException {
        Optional<Work> workold = workRepository.findById(work.getId());
        if (!workold.isPresent()) throw new NotFoundException("Work not found");

        if (user.getIsUser() && !workold.get().getUser().getId().equals(user.getId())) throw new AccessDeniedException("You can't edit this work");
        //TODO need to save hastags before if need
        workold.get().setWork(work);
        workRepository.save(workold.get());
    }

    public Work getWork(Long id) throws NotFoundException {
       Optional<Work> work = workRepository.findById(id);
       if (work.isPresent()) return work.get();
       else throw new NotFoundException("Work not found");
    }

    public void deleteWork(Long workID, User user){
        workRepository.deleteByIdAndUser(workID, user);
    }

    public List<Work> getWorks(FiltersForWork filtersForWork){
       //TODO FILTER
        return null;
    }

    @Autowired
    public void setWorkRepository(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Autowired
    public void setUserSaveWorkRepository(UserSaveWorkRepository userSaveWorkRepository) {
        this.userSaveWorkRepository = userSaveWorkRepository;
    }
}

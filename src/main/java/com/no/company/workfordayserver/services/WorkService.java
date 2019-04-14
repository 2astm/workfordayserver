package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.repos.WorkRepository;
import javassist.NotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkService {
    private WorkRepository workRepository;

    public void saveWork(Work work, User user){
        work.setUser(user);
        workRepository.save(work);
    }

    public void editWork(Work work, User user) throws NotFoundException {
        Optional<Work> workold = workRepository.findById(work.getId());
        if (!workold.isPresent()) throw new NotFoundException("Work not found");
        if (user.getIsUser() && !workold.get().getUser().getId().equals(user.getId())) throw new AccessDeniedException("You can't edit this work");
        workold.get().setWork(work);
        workRepository.save(workold.get());
    }

    @Autowired
    public void setWorkRepository(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }
}

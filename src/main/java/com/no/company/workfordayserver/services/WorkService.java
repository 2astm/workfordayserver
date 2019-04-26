package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Hashtag;
import com.no.company.workfordayserver.entities.Saved;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import com.no.company.workfordayserver.jsonmodels.FiltersForWork;
import com.no.company.workfordayserver.repos.HashtagRepository;
import com.no.company.workfordayserver.repos.SavedRepository;
import com.no.company.workfordayserver.repos.WorkRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    private WorkRepository workRepository;
    private SavedRepository savedRepository;

    @PersistenceContext
    private EntityManager em;

    private HashtagRepository hashtagRepository;

    public void saveWork(Work work, User user){

        //TODO need to save hashtags before if need
        work.setUser(user);
        work.getHashtags().forEach((hashtag) -> {
            if (hashtag.getId() == null || !hashtagRepository.existsById(hashtag.getId())){
                if (hashtag.getName() !=null)
                    hashtagRepository.save(hashtag);
            }
        });
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

    public void addToSaved(Long id, User user) throws NotFoundException {
        Saved saved = new Saved();
        saved.setUser(user);
        saved.setWork(getWork(id));
        savedRepository.save(saved);
    }
    @Autowired
    public void setWorkRepository(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Autowired
    public void setHashtagRepository(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    @Autowired
    public void setSavedRepository(SavedRepository savedRepository) {
        this.savedRepository = savedRepository;
    }
}

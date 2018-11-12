package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.entities.WorkerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface WorkerRequestRepository extends JpaRepository<WorkerRequest, Long> {
    //public List<WorkerRequest> findByUser(User user);
    public List<WorkerRequest> findAllByUser(User user);
    public List<WorkerRequest> findAllByVacancy(Vacancy vacancy);

    @Modifying
    @Transactional
    @Query(value = "update WorkerRequest set stateRequest = ?3 where id = ?1 and user.id = ?2")
    public void setStateByRequestCreator(long id, long request_creator_id, WorkerRequest.State_request state);

    @Modifying
    @Transactional
    @Query(value = "update WorkerRequest set stateRequest = ?3 where id = ?1 and vacancy in (select id from Vacancy where user.id = ?2)")
    void setStateByVacancyCreator(long id, long creatorVacancyId, WorkerRequest.State_request state);
}

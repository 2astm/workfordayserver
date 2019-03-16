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
    List<WorkerRequest> findAllByUser(User user);
    List<WorkerRequest> findAllByVacancy(Vacancy vacancy);

    @Modifying
    @Transactional
    @Query(value = "update WorkerRequest set stateRequest = ?3 where id = ?1 and user.id = ?2")
    void setStateByRequestCreator(long id, long request_creator_id, WorkerRequest.State_request state);

    @Modifying
    @Transactional
    @Query(value = "update WorkerRequest set stateRequest = ?3 where id = ?1 and vacancy in (select id from Vacancy where creator.id = ?2)")
    void setStateByVacancyCreator(long id, long creatorVacancyId, WorkerRequest.State_request state);
}

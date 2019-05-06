package com.no.company.workfordayserver.repos.jpa;

import com.no.company.workfordayserver.entities.UserSaveWorkerApplication;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSaveWorkerApplicationRepository extends JpaRepository<UserSaveWorkerApplication, Long> {
    @Query(value = "select s from UserSaveWorkerApplication s where s.user.id = :id order by s.date desc")
    List<UserSaveWorkerApplication> getSavedWorkerApplications(Pageable pageable, @Param("id") Long userID);
}

package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.UserSaveWork;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSaveWorkRepository extends JpaRepository<UserSaveWork, Long> {
    @Query(value = "select s from UserSaveWork s where s.user.id = :id order by s.date desc")
    List<UserSaveWork> getSavedWorks(Pageable pageable, @Param("id") Long userID);
}

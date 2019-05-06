package com.no.company.workfordayserver.repos.jpa;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    void deleteByIdAndUser(Long id, User user);


}
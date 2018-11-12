package com.no.company.workfordayserver.repos;


import com.no.company.workfordayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    @Modifying
    @Transactional
    @Query (value = "Update User set password = ?2 where id = ?1" )
    void setPassword(long id, String password);
}

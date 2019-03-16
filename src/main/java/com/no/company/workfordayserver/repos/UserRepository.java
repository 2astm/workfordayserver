package com.no.company.workfordayserver.repos;


import com.no.company.workfordayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Modifying
    @Transactional
    @Query (value = "Update User set password = ?2 where id = ?1")
    void setPassword(@Param(value = "user_id") long id, @Param(value = "new_password") String password);

    @Modifying
    @Transactional
    @Query (value = "Update User set login = ?2 where id = ?1")
    void setLogin(@Param(value = "user_id") long id, @Param(value = "new_login") String login);

    @Modifying
    @Transactional
    @Query (value = "Update User set name = ?2 where id = ?1")
    void setName(@Param(value = "user_id") long id, @Param(value = "new_name") String name);

    @Modifying
    @Transactional
    @Query (value = "Update User set surname = ?2 where id = ?1")
    void setSurname(@Param(value = "user_id") long id, @Param(value = "Surname") String Surname);

    @Modifying
    @Transactional
    @Query (value = "Update User set email = ?2 where id = ?1")
    void setEmail(@Param(value = "user_id") long id, @Param(value = "email") String email);

    @Modifying
    @Transactional
    @Query (value = "Update User set phoneNumber = ?2 where id = ?1")
    void setPhoneNumber(@Param(value = "user_id") long id, @Param(value = "phoneNumber") String phoneNumber);
}

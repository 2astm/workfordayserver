package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Email String email);

    @Transactional
    void deleteByEmail(@Email String email);
}

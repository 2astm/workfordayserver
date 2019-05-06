package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.UserSaveWork;
import com.no.company.workfordayserver.entities.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Email String email);

    @Transactional
    void deleteByEmail(@Email String email);

    @Transactional
    @Modifying
    @Query(value = "update users u set u.isUser = :is_user where u.email = :email")
    void updateIsUser(@Param("is_user") Boolean isUser, @Param("email") String email);
}

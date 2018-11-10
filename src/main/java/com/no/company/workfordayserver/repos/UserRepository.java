package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

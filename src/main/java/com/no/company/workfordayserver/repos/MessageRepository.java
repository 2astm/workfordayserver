package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

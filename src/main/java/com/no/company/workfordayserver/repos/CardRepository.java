package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

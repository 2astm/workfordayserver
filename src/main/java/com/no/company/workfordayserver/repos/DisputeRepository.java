package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Dispute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisputeRepository extends JpaRepository<Dispute, Long> {
}

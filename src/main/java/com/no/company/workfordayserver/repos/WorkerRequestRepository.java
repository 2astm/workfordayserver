package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.WorkerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRequestRepository extends JpaRepository<WorkerRequest, Long> {
}

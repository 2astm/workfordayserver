package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}

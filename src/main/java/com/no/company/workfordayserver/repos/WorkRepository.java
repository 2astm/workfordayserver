package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.ReportAsSingleViolation;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}

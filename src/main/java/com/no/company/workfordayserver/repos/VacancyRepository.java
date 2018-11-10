package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}

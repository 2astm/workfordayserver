package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}

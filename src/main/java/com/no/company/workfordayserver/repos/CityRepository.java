package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
    List<City> findByRegionName(String region_name);
}

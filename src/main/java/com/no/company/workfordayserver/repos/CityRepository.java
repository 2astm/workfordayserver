package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    public City findByName(String name);
    public List<City> findByRegionName(String region_name);
}

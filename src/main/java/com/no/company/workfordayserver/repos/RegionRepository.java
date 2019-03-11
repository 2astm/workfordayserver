package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
}

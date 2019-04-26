package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Saved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedRepository extends JpaRepository<Saved, Long> {

}

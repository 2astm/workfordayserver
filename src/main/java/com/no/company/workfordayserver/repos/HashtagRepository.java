package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Optional<Hashtag> findByNameIgnoreCase(String name);
    List<Hashtag> findAllByNameLikeIgnoreCase(String name);
}

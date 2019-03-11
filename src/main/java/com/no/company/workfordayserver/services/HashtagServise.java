package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Hashtag;
import com.no.company.workfordayserver.repos.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashtagServise {

    @Autowired
    private HashtagRepository repository;

    public void addHashtag(Hashtag hashtag){
        repository.save(hashtag);
    }
}

package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Hashtag;
import com.no.company.workfordayserver.repos.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagServise {

    @Autowired
    private HashtagRepository repository;

    public void addHashtag(Hashtag hashtag){
        Optional<Hashtag> hashtagOptional = repository.findByNameIgnoreCase(hashtag.getName());

        if (!hashtagOptional.isPresent()) {
            repository.save(hashtag);
        }
    }

    public List<Hashtag> getHashtagsByName(String name){
        Optional<Hashtag> hashtag = repository.findByNameIgnoreCase(name);

        if (hashtag.isPresent()){
            return repository.findAllByNameLikeIgnoreCase(name);
        }

        //TODO: продумать вариант сохранения в бд

        return null;
    }
}

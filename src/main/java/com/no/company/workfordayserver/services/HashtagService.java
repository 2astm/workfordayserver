package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Hashtag;
import com.no.company.workfordayserver.repos.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagService {

    private HashtagRepository hashtagRepository;

    void saveAllHashtags(List<Hashtag> hashtags){
        for (Hashtag hashtag : hashtags) {
            Optional<Hashtag> optionalHashtag = hashtagRepository.findByName(hashtag.getName());
            optionalHashtag.ifPresentOrElse(
                    presentHashtag-> hashtag.setId(presentHashtag.getId()),
                    () -> hashtagRepository.save(hashtag));
        }
    }

    @Autowired
    public void setHashtagRepository(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }
}

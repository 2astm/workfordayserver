package com.no.company.workfordayserver.services;


import com.no.company.workfordayserver.entities.Card;
import com.no.company.workfordayserver.repos.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public void setRepository(CardRepository repository) {
        this.repository = repository;
    }

    public void addCard(Card card){
        repository.save(card);
    }
}

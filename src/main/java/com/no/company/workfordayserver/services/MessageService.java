package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Message;
import com.no.company.workfordayserver.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public void addMessage(Message message){
        repository.save(message);
    }

}

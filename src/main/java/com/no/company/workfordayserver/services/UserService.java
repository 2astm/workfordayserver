package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    public User getUserByLogin(String login) {
        return  repository.findByLogin(login);
    }

    public void addUser(User s) {
        repository.saveAndFlush(s);
    }

    public void updateUser(long id, User newUser) {
        if(newUser.getPassword() != null) {
            repository.setPassword(id, newUser.getPassword());
        }
        if(newUser.getLogin() != null) {
            repository.setLogin(id, newUser.getLogin());
        }
        if(newUser.getName() != null) {
            repository.setName(id, newUser.getName());
        }
        if(newUser.getSurname() != null) {
            repository.setSurname(id, newUser.getSurname());
        }
        if(newUser.getEmail() != null) {
            repository.setEmail(id, newUser.getEmail());
        }
        if(newUser.getPhoneNumber() != null) {
            repository.setPhoneNumber(id, newUser.getPhoneNumber());
        }
    }

    public void remove(User user) {
        repository.delete(user);
    }
}

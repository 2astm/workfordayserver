package com.no.company.workfordayserver.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "id_user", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "login", unique = true)
    @NotNull
    private String login;

    @ManyToOne
    @JoinColumn(name = "id_city")
    @JsonBackReference
    private City city;

    @Column(name = "dateRegister")
    private Date dateRegister;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<WorkerRequest> workerRequests;

    @OneToMany(mappedBy = "userFromMessage")
    @JsonManagedReference(value = "userFromMessage-message")
    private Set<Message> messagesFrom;

    @OneToMany(mappedBy = "userToMessage")
    @JsonManagedReference(value = "userToMessage-message")
    private Set<Message> messagesTo;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user-card")
    private Set<Card> cards;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user-dispute")
    private Set<Dispute> disputes;

    public Set<Dispute> getDisputes() {
        return disputes;
    }

    public void setDisputes(Set<Dispute> disputes) {
        this.disputes = disputes;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    @PrePersist
    public void setDateRegister() {
        this.dateRegister = new Date();
        this.dateUpdate = dateRegister;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void setDateUpdate() {
        this.dateUpdate = new Date();
    }

    public Set<WorkerRequest> getWorkerRequests() {
        return workerRequests;
    }

    public void setWorkerRequests(Set<WorkerRequest> workerRequests) {
        this.workerRequests = workerRequests;
    }

    public Set<Message> getMessagesFrom() {
        return messagesFrom;
    }

    public void setMessagesFrom(Set<Message> messagesFrom) {
        this.messagesFrom = messagesFrom;
    }

    public Set<Message> getMessagesTo() {
        return messagesTo;
    }

    public void setMessagesTo(Set<Message> messagesTo) {
        this.messagesTo = messagesTo;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " Surname: " + surname + " PhoneNumber: " + phoneNumber + " Email: " + email + " Login: " + login + " City; " + city.toString() +
                " DateRegister: " + dateRegister.toString() + " DateUpdate: " + dateUpdate.toString();
    }
}


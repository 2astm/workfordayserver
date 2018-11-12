package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference(value = "user-card")
    private User user;

    @OneToMany(mappedBy = "cardTo")
    @JsonManagedReference(value = "cardTo-payment")
    private Set<Payment> paymentsTo;

    @OneToMany(mappedBy = "cardFrom")
    @JsonManagedReference(value = "cardFrom-payment")
    private Set<Payment> paymentsFrom;

    private String number;

    public enum State{
        ACTIVE,
        ACTIVE_DEFAULT,
        EXPIERED
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

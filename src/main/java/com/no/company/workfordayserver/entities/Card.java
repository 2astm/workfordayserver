package com.no.company.workfordayserver.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user_fk2")
    private User card_user;
    //TODO Связь с cards
    /*
    @OneToMany(mappedBy = "cards")
    private Set<Payment> paymentsTo;

    @OneToMany(mappedBy = "cards")
    private Set<Payment> paymentsFrom;*/

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
        return card_user;
    }

    public void setUser(User user) {
        this.card_user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

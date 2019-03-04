package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    private String number;

    public enum State{
        ACTIVE,
        ACTIVE_DEFAULT,
        EXPIERED
    }

    private State state;

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void setDateCreate() {
        this.dateCreate = new Date();
        this.dateUpdate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void setDateUpdate() {
        this.dateUpdate = new Date();
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

    public Set<Payment> getPaymentsTo() {
        return paymentsTo;
    }

    public void setPaymentsTo(Set<Payment> paymentsTo) {
        this.paymentsTo = paymentsTo;
    }

    public Set<Payment> getPaymentsFrom() {
        return paymentsFrom;
    }

    public void setPaymentsFrom(Set<Payment> paymentsFrom) {
        this.paymentsFrom = paymentsFrom;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Number: " + number + " State: " + state + " Date Create: " + dateCreate + " Date Update: " + dateUpdate;
    }
}

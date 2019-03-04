package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue
    private long id;

    private Date date;

    private double price;

    @ManyToOne
    @JoinColumn(name = "id_from")
    @JsonBackReference(value = "cardFrom-payment")
    private Card cardFrom;

    @ManyToOne
    @JoinColumn(name = "id_to")
    @JsonBackReference(value = "cardTo-payment")
    private Card cardTo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    @PrePersist
    public void setDate() {
        this.date = new Date();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Card getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Card cardFrom) {
        this.cardFrom = cardFrom;
    }

    public Card getCardTo() {
        return cardTo;
    }

    public void setCardTo(Card cardTo) {
        this.cardTo = cardTo;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Date: " + date.getDate() + " Price: " + price + " CardFrom: " + cardFrom.toString() + " CardTo: " + cardTo.toString();
    }
}

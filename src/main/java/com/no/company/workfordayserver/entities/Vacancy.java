package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private long id;

    // TODO discription?
    @Column(name = "description")
    private String discription;

    @ManyToOne
    @JoinColumn(name = "id_creator")
    @JsonBackReference(value = "vacancy-workerRequest")
    private User user;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_city")
    @JsonBackReference(value = "city-vacancy")
    private City city;

    @OneToMany(mappedBy = "vacancy")
    @JsonManagedReference(value = "dispute-vacancy")
    private Set<Dispute> disputes;

    @Column(name = "name")
    private String name;

    @Column(name = "dateStart")
    private Date dateStart;

    @Column(name = "dateEnd")
    private Date dateEnd;

    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @ManyToMany(mappedBy = "vacancies", fetch = FetchType.EAGER)
    private Set<Hashtag> hashtags;

    public enum State {
        NEW, IN_PROCCESS, CHECKING, READY, DELETED, REJECTED
    }

    private State state;

    private double lat;

    private double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Dispute> getDisputes() {
        return disputes;
    }

    public void setDisputes(Set<Dispute> disputes) {
        this.disputes = disputes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    protected void onCreate() {
        this.dateCreate = new Date();this.dateUpdate = new Date(); state= State.CHECKING;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.dateUpdate = new Date();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}


package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_creator")
    private User creator;

    @Column(name = "price")
    private double price;

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
    @JsonManagedReference
    private Set<Hashtag> hashtags;

    public enum State {
        NEW, IN_PROCCESS, CHECKING, READY, DELETED, REJECTED
    }

    @Column(name = "state")
    private State state;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @ManyToOne
    @JoinColumn(name = "id_city")
    @JsonManagedReference
    private City city;

    @OneToMany(mappedBy = "vacancy")
    @JsonBackReference
    private List<WorkerRequest> workerRequestList;

    public List<WorkerRequest> getWorkerRequestList() {
        return workerRequestList;
    }

    public void setWorkerRequestList(List<WorkerRequest> workerRequestList) {
        this.workerRequestList = workerRequestList;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
        state= State.CHECKING;
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

    @Override
    public String toString() {
        return "Id: " + id + " Lat: " + lat + " Lng: " + lng + " Discription: " + description + " Creator: " + creator.toString() + " Price: " + price + " City: " + city.toString() + " Name: " + name +
                " DateStart: " + dateStart + " DateEnd: " + dateEnd + " DateCreate: " + dateCreate + " DateUpdate: " + dateUpdate + " State: " + state;
    }
}


package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Work {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user_work")
    private User user;

    @NotNull
    private String title;

    private Double budget;

    private String description;

    private Double lat;
    private Double ln;

    private Status status;

    @Pattern(regexp = "([+]38[0-9]{10};)+")
    private String phoneNumbers;

    private Date dateCreate;
    private Date dateUpdate;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Hashtag.class)
    private List<Hashtag> hashTags;

    public enum Status{
        ACTIVE, DELETED, CANCELLED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLn() {
        return ln;
    }

    public void setLon(Double ln) {
        this.ln = ln;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Hashtag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<Hashtag> hashTags) {
        this.hashTags = hashTags;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void onCreate() {
        dateCreate = new Date();
        dateUpdate = dateCreate;
        status = Status.ACTIVE;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void onUpdate(){
        dateUpdate = new Date();
    }

    public void setWork(Work work){
        if (work.title != null)
            title = work.title;
        if (work.budget != null)
            budget = work.budget;
        if (work.description != null)
            description = work.description;
        if (work.lat != null)
            lat = work.lat;
        if (work.ln != null)
            ln = work.ln;
        if (work.hashTags != null)
            hashTags = work.hashTags;
        if (work.phoneNumbers != null)
            phoneNumbers = work.phoneNumbers;

    }
}

package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class WorkerApplication {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @Pattern(regexp = "([+]38[0-9]{10};)+")
    private String phoneNumbers;

    @ManyToMany(targetEntity = Hashtag.class)
    @JsonManagedReference("workerApplication_hashtags")
    private List<Hashtag> hashTags;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;

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

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void setDateCreate() {
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void setDateUpdate() {
        this.dateUpdate = new Date();
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

    public void setWorkerApplication(WorkerApplication workerApplication){
        if (workerApplication.hashTags != null)
            this.hashTags = workerApplication.hashTags;
        if (workerApplication.phoneNumbers != null)
            this.phoneNumbers = workerApplication.phoneNumbers;
    }
}

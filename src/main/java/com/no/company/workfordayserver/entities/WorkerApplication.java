package com.no.company.workfordayserver.entities;

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
    private List<Hashtag> hashtags;

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
        return hashtags;
    }

    public void setHashTags(List<Hashtag> hashTags) {
        this.hashtags = hashTags;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setWorkerApplication(WorkerApplication workerApplication){
        if (workerApplication.hashtags != null)
            this.hashtags = workerApplication.hashtags;
        if (workerApplication.phoneNumbers != null)
            this.phoneNumbers = workerApplication.phoneNumbers;
    }
}

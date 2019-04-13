package com.no.company.workfordayserver.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class WorkerApplication {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private User user;

    @ManyToMany(targetEntity = Hashtag.class)
    private List<Hashtag> hashtags;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;

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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}

package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"work_id", "user_id"})
})
public class UserSaveWork {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private Date date;

    public UserSaveWork(){}

    public UserSaveWork(Long userID, Long workID){
        user = new User();
        user.setId(userID);
        work = new Work();
        work.setId(workID);
    }

    public UserSaveWork(Work work, User user) {
        this.work = work;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void setDate() {
        this.date = new Date();
    }
}

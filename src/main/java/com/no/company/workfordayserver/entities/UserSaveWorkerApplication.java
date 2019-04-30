package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserSaveWorkerApplication {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_application_id")
    private WorkerApplication workerApplication;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private Date date;

    public UserSaveWorkerApplication(){}

    public UserSaveWorkerApplication(Long userID, Long workerApplicationID){
        user = new User();
        user.setId(userID);
        workerApplication = new WorkerApplication();
        workerApplication.setId(workerApplicationID);
    }

    public UserSaveWorkerApplication(WorkerApplication workerApplication, User user) {
        this.workerApplication = workerApplication;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkerApplication getWorkerApplication() {
        return workerApplication;
    }

    public void setWorkerApplication(WorkerApplication workerApplication) {
        this.workerApplication = workerApplication;
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

package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "worker_application_id")
    private WorkerApplication workerApplication;

    private String reason;

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

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public WorkerApplication getWorkerApplication() {
        return workerApplication;
    }

    public void setWorkerApplication(WorkerApplication workerApplication) {
        this.workerApplication = workerApplication;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void onCreate() {
        dateCreate = new Date();
        dateUpdate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void onUpdate(){
        dateUpdate = new Date();
    }
}

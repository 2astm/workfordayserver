package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HoldPayment {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "id_worker_request") //<---Reget??????
    @JsonBackReference(value = "workerRequest-holdPayment")
    private WorkerRequest workerRequest;

    @Column(name = "date")
    private Date date;

    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    //Надо делать
    public enum State{
        CONFIRMED, WAITING, FREEZE
    }

    @Column(name = "state")
    private State state;

    public WorkerRequest getWorkerRequest() {
        return workerRequest;
    }

    public void setWorkerRequest(WorkerRequest workerRequest) {
        this.workerRequest = workerRequest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void setDateCreate() {
        this.dateCreate = new Date();
        this.dateUpdate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void setDateUpdate() {
        this.dateUpdate = new Date();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Id: " + id + " WorkerRequest: " + workerRequest.toString() + " Date: " + date.toString() + " DateCreate: " + dateCreate.toString() +
                " DateUpdate: " + dateUpdate.toString() + " State: " + state;
    }
}

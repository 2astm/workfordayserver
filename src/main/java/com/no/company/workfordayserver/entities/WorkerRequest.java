package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Workers_request")
public class WorkerRequest {


    @Id
    @GeneratedValue
    private long id;

    private double price;
    public enum State_request {
        Waiting, Approved, Rejected, Closed
    }
    private State_request stateRequest;

    @OneToOne(mappedBy = "workerRequest")
    @JsonBackReference
    private Worker worker;


    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    @JsonManagedReference
    private Vacancy vacancy;


    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public State_request getStateRequest() {
        return stateRequest;
    }

    public void setStateRequest(State_request stateRequest) {
        this.stateRequest = stateRequest;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Id: " + id + " User: " + user.toString() + " Vacancy: " + vacancy.toString() + " Price: " + price + " StateRequest: " + stateRequest +
                " Worker: " + worker.toString() + " DateCreate: " + dateCreate.toString() + " DateUpdate: " + dateUpdate.toString();
    }
}

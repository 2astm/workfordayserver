package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "Workers_request")
public class WorkerRequest {


    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    @JsonBackReference(value = "vacancy-workerRequest")
    private Vacancy vacancy;

    private double price;
    public enum State_request {
        Waiting, Approved, Rejected, Closed
    };
    private State_request stateRequest;

    @OneToOne(mappedBy = "workerRequest")
    @JsonManagedReference(value = "workerRequest-holdPayment")
    private HoldPayment holdPayment;


    @OneToOne(mappedBy = "workerRequest")
    @JsonManagedReference(value = "workerRequest-Worker")
    private Worker worker;

    public void setId(long id) {
        this.id = id;
    }

    public HoldPayment getHoldPayment() {
        return holdPayment;
    }

    public void setHoldPayment(HoldPayment holdPayment) {
        this.holdPayment = holdPayment;
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
}

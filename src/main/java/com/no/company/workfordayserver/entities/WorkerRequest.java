package com.no.company.workfordayserver.entities;

import javax.persistence.*;

@Entity
@Table(name = "Workers_request")
public class WorkerRequest {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    private Vacancy WORKER_REQUEST_vacancy;

    private double price;
    public enum State_request {Statement, Approved, Rejected};
    private State_request stateRequest;

    @OneToOne(mappedBy = "HOLDPAYMENT_workerRequest")
    private HoldPayment holdPayment;

    public void setId(long id) {
        this.id = id;
    }

    public HoldPayment getHoldPayment() {
        return holdPayment;
    }

    public void setHoldPayment(HoldPayment holdPayment) {
        this.holdPayment = holdPayment;
    }

    @OneToOne(mappedBy = "WORKER_workerRequest")
    private Worker worker;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vacancy getWORKER_REQUEST_vacancy() {
        return WORKER_REQUEST_vacancy;
    }

    public void setWORKER_REQUEST_vacancy(Vacancy WORKER_REQUEST_vacancy) {
        this.WORKER_REQUEST_vacancy = WORKER_REQUEST_vacancy;
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

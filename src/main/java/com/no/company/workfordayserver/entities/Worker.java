package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Worker {

    @Id
    @GeneratedValue
    private long id;

    private Date date_start;
    private Date date_end;

    private double mark;
    private double price;
    private String review;

    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @OneToOne
    @JoinColumn(name = "id_workers_request")
    @JsonBackReference(value = "workerRequest-Worker")
    private WorkerRequest workerRequest;

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkerRequest getWorkerRequest() {
        return workerRequest;
    }

    public void setWorkerRequest(WorkerRequest workerRequest) {
        this.workerRequest = workerRequest;
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
        return "Id: " + id + " Mark: " + mark + " Price: " + price + " Review " + review + " DateStart: " + date_start.toString() + " DateEnd: " + date_end.toString() +
                " WorkerRequest: " + workerRequest.toString() + " DateCreate: " + dateCreate.toString() + " DateUpdate: " + dateUpdate.toString();
    }
}

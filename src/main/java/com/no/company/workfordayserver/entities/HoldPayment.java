package com.no.company.workfordayserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HoldPayment {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "id_worker_request") //<---Reget??????
    private WorkerRequest workerRequest;

    @Column(name = "date")
    private Date date;

    //Надо делать
    public enum State{
        CONFIRMED, WAITING, FREEZE
    }

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
}

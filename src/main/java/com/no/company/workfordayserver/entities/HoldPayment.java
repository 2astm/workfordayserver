package com.no.company.workfordayserver.entities;

import javax.persistence.*;

@Entity
public class HoldPayment {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "id_worker_request")
    private WorkerRequest workerRequest;

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

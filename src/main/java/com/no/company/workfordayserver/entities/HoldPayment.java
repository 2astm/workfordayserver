package com.no.company.workfordayserver.entities;

import javax.annotation.Generated;
import javax.persistence.*;

public class HoldPayment {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @JoinColumn(name = "id_worker_request")
    private WorkerRequest HOLDPAYMENT_workerRequest;

    public WorkerRequest getHOLDPAYMENT_workerRequest() {
        return HOLDPAYMENT_workerRequest;
    }

    public void setHOLDPAYMENT_workerRequest(WorkerRequest HOLDPAYMENT_workerRequest) {
        this.HOLDPAYMENT_workerRequest = HOLDPAYMENT_workerRequest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

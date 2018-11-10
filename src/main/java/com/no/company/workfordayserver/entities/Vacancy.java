package com.no.company.workfordayserver.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "vacancy")
    private Set<Dispute> disputes;

    @OneToMany(mappedBy = "WORKER_REQUEST_vacancy")
    private Set<WorkerRequest> workerRequests;

    public Set<WorkerRequest> getWorkerRequests() {
        return workerRequests;
    }

    public void setWorkerRequests(Set<WorkerRequest> workerRequests) {
        this.workerRequests = workerRequests;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Dispute> getDisputes() {
        return disputes;
    }

    public void setDisputes(Set<Dispute> disputes) {
        this.disputes = disputes;
    }
}

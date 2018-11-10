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

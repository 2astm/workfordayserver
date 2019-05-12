package com.no.company.workfordayserver.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
//@Document(indexName = "items", type = "items", shards = 1)
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

//    @ManyToMany(targetEntity = com.no.company.workfordayserver.entities.WorkerApplication.class, mappedBy = "hashTags")
//    @JsonBackReference("workerApplication_hashtags")
//    private List<WorkerApplication> workerApplications;

//    @ManyToMany(targetEntity = com.no.company.workfordayserver.entities.Work.class, mappedBy = "hashtags")
//    private List<Work> works;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public List<WorkerApplication> getWorkerApplications() {
//        return workerApplications;
//    }
//
//    public void setWorkerApplications(List<WorkerApplication> workerApplications) {
//        this.workerApplications = workerApplications;
//    }
//
//    public List<Work> getWorks() {
//        return works;
//    }
//
//    public void setWorks(List<Work> works) {
//        this.works = works;
//    }
}

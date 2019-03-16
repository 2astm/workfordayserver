package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hashtag")
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name="vacancies",
            joinColumns = @JoinColumn(name="id_hashtag", referencedColumnName="id_hashtag"),
            inverseJoinColumns = @JoinColumn(name="id_vacancy", referencedColumnName="id_vacancy")
    )
    private Set<Vacancy> vacancies;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public String toString() {
        return "Id:" + id + " Name:" + name;
    }
}

package com.no.company.workfordayserver.entities;

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
    @JoinTable(name="vacancies",
            joinColumns = @JoinColumn(name="id_hashtag", referencedColumnName="id_hashtag"),
            inverseJoinColumns = @JoinColumn(name="id_vacancy", referencedColumnName="id_vacancy")
    )
    private Set<Vacancy> vacancies;

    public Hashtag() {
    }

    public Hashtag(String name, Set<Vacancy> vacancies) {
        this.name = name;
        this.vacancies = vacancies;
    }

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
}

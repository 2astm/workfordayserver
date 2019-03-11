package com.no.company.workfordayserver.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "id_user", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "login", unique = true)
    @NotNull
    private String login;

    @Column(name = "dateRegister")
    private Date dateRegister;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    @OneToMany(mappedBy = "creator")
    @JsonBackReference
    private List<Vacancy> created_vacancies;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<WorkerRequest> workerRequests;

    public List<WorkerRequest> getWorkerRequests() {
        return workerRequests;
    }

    public void setWorkerRequests(List<WorkerRequest> workerRequests) {
        this.workerRequests = workerRequests;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Vacancy> getCreated_vacancies() {
        return created_vacancies;
    }

    public void setCreated_vacancies(List<Vacancy> created_vacancies) {
        this.created_vacancies = created_vacancies;
    }
}


package com.no.company.workfordayserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispute")
public class Dispute {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vacancy")
    private Vacancy vacancy;

    public enum State{
        PROCCECING,
        CLOSED
    }

    private State state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



}

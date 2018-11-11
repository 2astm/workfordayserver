package com.no.company.workfordayserver.entities;

import com.no.company.workfordayserver.entities.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "disruption")
    private String disruption;

    @ManyToOne
    @JoinColumn(name = "id_creator")
    private User user;

    @Column(name = "price")
    private double price;

    /**
     * Error: Нужна таблица City
     * добавить к проекту
     */
   /* @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;*/

    @Column(name = "name")
   private String name;

   /* Здесь может быть ваш код к State Vacancy
      Номер карты 674332857639284 закидывайте деньги
      и приступайте к работе!
    */

    @Column(name = "dateStart")
   private Date dateStart;

    @Column(name = "dateEnd")
   private Date dateEnd;

    @Column(name = "dateCreate")
   private Date dateCreate;

    @Column(name = "dateUpdate")
   private Date dateUpdate;

    //Надо делать
    public enum State{

    }

    private State state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisruption() {
        return disruption;
    }

    public void setDisruption(String disruption) {
        this.disruption = disruption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
    //Своровано
    /*@OneToMany(mappedBy = "vacancy")
    private Set<Dispute> disputes;*/
}


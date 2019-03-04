package com.no.company.workfordayserver.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "region")
    @JsonManagedReference(value = "region-city")
    private Set<City> cities;

    public Region(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<City> getCity() {
        return cities;
    }

    public void setCity(Set<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + id + " RegionName: " + name;
    }
}

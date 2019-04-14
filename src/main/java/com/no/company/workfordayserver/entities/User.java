package com.no.company.workfordayserver.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Work> works;

    private String phoneNumber;

    @Lob
    private byte[] photo;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;

    @NotNull
    private Boolean isUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @PrePersist
    public void onCreate() {
        dateCreate = new Date();
        dateUpdate = dateCreate;
        isUser = true;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    @PreUpdate
    public void onUpdate(){
        dateUpdate = new Date();
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean user) {
        this.isUser = user;
    }

    public void setUser(User user){
        if (user.email != null)
            this.email = user.email;
        if (user.password != null)
            this.password = user.password;
        if (user.name != null)
            this.name = user.name;
        if (user.phoneNumber != null)
            this.phoneNumber = user.phoneNumber;
        if (user.photo != null)
            this.photo = user.photo;
        if (user.isUser!=null && !user.isUser)
            this.isUser = user.isUser;

    }
}
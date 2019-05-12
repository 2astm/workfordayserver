package com.no.company.workfordayserver.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.no.company.workfordayserver.consts.SecurityRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Work> works;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserSaveWork> userSavedWorks;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserSaveWorkerApplication> savedWorkerApplication;

    @Pattern(regexp = "([+]38[0-9]{10};)+")
    private String phoneNumbers;

    @Lob
    private byte[] photo;

    @Column(name = "date_create")
    @JsonIgnore
    private Date dateCreate;

    @Column(name = "date_update")
    @JsonIgnore
    private Date dateUpdate;

    @NotNull
    @JsonIgnore
    private Boolean isUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + (isUser? SecurityRoles.USER:SecurityRoles.ADMIN));
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
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

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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

    @JsonIgnore
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

    public List<UserSaveWork> getUserSavedWorks() {
        return userSavedWorks;
    }

    public void setUserSavedWorks(List<UserSaveWork> userSavedWorks) {
        this.userSavedWorks = userSavedWorks;
    }

    public List<UserSaveWorkerApplication> getSavedWorkerApplication() {
        return savedWorkerApplication;
    }

    public void setSavedWorkerApplication(List<UserSaveWorkerApplication> savedWorkerApplication) {
        this.savedWorkerApplication = savedWorkerApplication;
    }

    public void setUser(User user){
        if (user.email != null)
            this.email = user.email;
        if (user.password != null)
            this.password = user.password;
        if (user.name != null)
            this.name = user.name;
        if (user.phoneNumbers != null)
            this.phoneNumbers = user.phoneNumbers;
        if (user.photo != null)
            this.photo = user.photo;
        if (user.isUser!=null && !user.isUser)
            this.isUser = user.isUser;

    }
}
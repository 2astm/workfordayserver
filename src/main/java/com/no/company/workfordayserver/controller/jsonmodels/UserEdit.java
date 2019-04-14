package com.no.company.workfordayserver.controller.jsonmodels;

import com.no.company.workfordayserver.entities.User;

import javax.validation.constraints.Email;

public class UserEdit extends User {
    @Email
    private String userMailToEdit;

    public String getUserMailToEdit() {
        return userMailToEdit;
    }

    public void setUserMailToEdit(String userMailToEdit) {
        this.userMailToEdit = userMailToEdit;
    }
}

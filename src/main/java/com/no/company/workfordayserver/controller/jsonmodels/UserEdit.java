package com.no.company.workfordayserver.controller.jsonmodels;

import com.no.company.workfordayserver.entities.User;

import javax.validation.constraints.Email;
import java.io.Serializable;

public class UserEdit extends User implements Serializable {
    @Email
    private String userMailToEdit;

    public String getUserMailToEdit() {
        return userMailToEdit;
    }

    public void setUserMailToEdit(String userMailToEdit) {
        this.userMailToEdit = userMailToEdit;
    }
}

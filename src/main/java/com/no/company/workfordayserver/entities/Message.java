package com.no.company.workfordayserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.no.company.workfordayserver.entities.User;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_from")
    @JsonBackReference(value = "userFromMessage-message")
    private User userFromMessage;

    @ManyToOne
    @JoinColumn(name = "id_to")
    @JsonBackReference(value = "userToMessage-message")
    private User userToMessage;

    @Column(name = "messages")
    private String messages;

    @Column(name = "date")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserFromMessage() {
        return userFromMessage;
    }

    public void setUserFromMessage(User userFromMessage) {
        this.userFromMessage = userFromMessage;
    }

    public User getUserToMessage() {
        return userToMessage;
    }

    public void setUserToMessage(User userToMessage) {
        this.userToMessage = userToMessage;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

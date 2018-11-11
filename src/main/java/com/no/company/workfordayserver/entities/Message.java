package com.no.company.workfordayserver.entities;

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
    @JoinColumn(name = "id_front")
    private User userFromMessage;

    @ManyToOne
    @JoinColumn(name = "id_to")
    private User userToMessage;

    @Column(name = "messages")
    private String messages;

    @Column(name = "date")
    private Date date;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

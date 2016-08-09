package com.accolite.chat.model;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue
    private Integer id;
    private String message;
    private Date created;
    @ManyToOne
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private ChatGroup chatGroup;

    public Message() {
    }

    public Message(String message, Date created, User user) {
        this.message = message;
        this.created = created;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatGroup getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(ChatGroup chatGroup) {
        this.chatGroup = chatGroup;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", created=" + created +
                ", user=" + user +
                ", chatGroup=" + chatGroup +
                '}';
    }
}

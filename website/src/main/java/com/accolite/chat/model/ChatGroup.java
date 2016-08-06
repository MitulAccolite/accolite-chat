package com.accolite.chat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Table
@Entity
public class ChatGroup {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date created;
    @ManyToMany
    private List<User> users = new ArrayList();
    @OneToMany
    private List<Message> messages = new ArrayList<Message>();

    public ChatGroup() {
    }

    public ChatGroup(String name, Date date) {
        this.name = name;
        this.created = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "ChatGroupDao{" +
                "messages=" + messages +
                ", users=" + users +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

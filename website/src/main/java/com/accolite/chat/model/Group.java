package com.accolite.chat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Table
@Entity
public class Group {

    @Id
    @GeneratedValue
    private int id;
    private String groupName;
    private Date created;

    @ManyToMany
    private List<User> users = new ArrayList();

    @OneToMany
    private List<Message> messages = new ArrayList<Message>();

    public Group(){

    }

    public Group(String name,Date date){
        this.groupName = name;
        this.created = date;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public Date getCreated() {
        return created;
    }
}

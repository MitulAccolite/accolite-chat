package com.accolite.chat.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String message;
    private int userID;
    private Date created;
    private int groupID;
    private boolean isArchived;

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;

    public Message(){

    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public Message(String msg, int userid, Date created, int groupID, boolean isArchived, User user){
        this.message = msg;
        this.userID = userid;
        this.created = created;
        this.groupID = groupID;
        this.isArchived = isArchived;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getUserID() {
        return userID;
    }

    public Date getCreated() {
        return created;
    }

    public int getGroupID() {
        return groupID;
    }

    public boolean isArchived() {
        return isArchived;
    }
}

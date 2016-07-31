package com.accolite.chat.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class LoginCredentials {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private Date created;
    private Date updated;
    private int userID;

    @OneToOne
    private User user;

    public LoginCredentials(){

    }

    public LoginCredentials(String uname,String pass,Date created,Date updated,int user){
        this.username = uname;
        this.password = pass;
        this. created = created;
        this.updated = updated;
        this.userID = user;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public int getUserID() {
        return userID;
    }
}

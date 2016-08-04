package com.accolite.chat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class Credential {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Date created;
    private Date updated;
    @OneToOne
    private User user;

    public Credential() {
    }

    public Credential(String userName, String password, Date created, Date updated) {
        this.username = userName;
        this.password = password;
        this.created = created;
        this.updated = updated;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

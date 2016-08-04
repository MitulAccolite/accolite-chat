package com.accolite.chat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String details;

    public Notification(String email, String details) {
        this.email = email;
        this.details = details;
    }

    public Notification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

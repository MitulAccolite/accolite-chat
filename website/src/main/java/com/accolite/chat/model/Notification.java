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
    private int id;
    private String email;
    private String notificationDetails;


    public Notification(){

    }

    public Notification(String email,String notificationDetails){
        this.email = email;
        this.notificationDetails = notificationDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotificationDetails(String notificationDetails) {
        this.notificationDetails = notificationDetails;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNotificationDetails() {
        return notificationDetails;
    }
}

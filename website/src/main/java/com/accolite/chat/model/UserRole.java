package com.accolite.chat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class UserRole {

    @Id
    @GeneratedValue
    private int id;
    private int userID;
    @Column(columnDefinition = "varchar(255) default 'USER' ",nullable = false)
    private String role;

    @ManyToMany
    private List<User> users = new ArrayList<User>();

    public UserRole(){
            role= Roles.USER;
    }

    public UserRole(int userID,String role){
        this.userID = userID;
        this.role = role;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }
}

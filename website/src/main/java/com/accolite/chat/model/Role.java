package com.accolite.chat.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "varchar(255) default 'USER' ", nullable = false)
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<User>();

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

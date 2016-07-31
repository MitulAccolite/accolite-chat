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
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date created;
    private Date updated;
    private boolean isActive;
    private String nickName;
    private String email;

    @OneToMany
    private List<Message> messages;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Group> groups = new ArrayList<Group>();

    @ManyToMany(mappedBy = "users")
    private List<UserRole> roles = new ArrayList<UserRole>();

    @OneToOne(mappedBy = "user")
    private LoginCredentials loginCredentials;
    public User(){

    }

    public User(String fname,String mname,String lname,Date created,Date updated,boolean isActive,String nickname,String email){
        this.firstName = fname;
        this.middleName = mname;
        this.lastName = lname;
        this.created = created;
        this.updated = updated;
        this.isActive = isActive;
        this.nickName = nickname;
        this.email = email;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }
}

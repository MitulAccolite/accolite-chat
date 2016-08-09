package com.accolite.chat.model;

import com.accolite.chat.dao.impl.ChatGroupDao;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.swing.plaf.basic.BasicMenuUI;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
@Table
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date created;
    private Date updated;
    private boolean isActive;
    private String nickName;
    private String email;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Message> messages;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<ChatGroup> chatGroups = new ArrayList<ChatGroup>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<Role>();

    @OneToOne(mappedBy = "user")
    private Credential credential;


    public User() {
    }

    public User(String firstName, String middleName, String lastName, Date created, Date updated,
                boolean isActive, String nickName, String email, List<Role> roles, Credential credential) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.created = created;
        this.updated = updated;
        this.isActive = isActive;
        this.nickName = nickName;
        this.email = email;
        this.roles = roles;
        this.credential = credential;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    public List<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public void setChatGroups(List<ChatGroup> chatGroups) {
        this.chatGroups = chatGroups;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        getMessages();
        getChatGroups();
        return "User{" +
//                       "id=" + id +
//                       ", firstName='" + firstName +
//                       ", middleName='" + middleName +
//                       ", lastName='" + lastName +
//                       ", created=" + created +
//                       ", updated=" + updated +
//                       ", isActive=" + isActive +
//                       ", nickName='" + nickName +
//                       ", email='" + email +
////                       ", messages=" + getMessages() +
////                       ", chatGroups=" + getChatGroups() +
//                       ", roles=" + roles +
//                       ", credential=" + credential +
                       "}";
    }
}

package com.accolite.chat.model;

/**
 * Created by Diksha Garg on 8/10/2016.
 */
public class OnlineUsers {
    private String emailID;
    private String nickName;
    private boolean isActive;
    public OnlineUsers(String a,String b,boolean c)
    {
        this.emailID=a;
        this.nickName=b;
        this.isActive=c;

    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

package com.accolite.chat.model;

import java.util.Date;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */

public class Group_user {

    private int groupID;
    private int userID;
    private Date joined;

    public Group_user(){

    }

    public Group_user(int id,int user,Date date){
        this.groupID = id;
        this.userID = user;
        this.joined = date;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getJoined() {
        return joined;
    }
}

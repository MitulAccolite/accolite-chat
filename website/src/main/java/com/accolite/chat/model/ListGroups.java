package com.accolite.chat.model;

/**
 * Created by Diksha Garg on 8/10/2016.
 */
public class ListGroups {
    private Integer groupId;
    private String groupName;

    public ListGroups(Integer a,String groupName)
    {

        this.groupId=a;
        this.groupName=groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

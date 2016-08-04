package com.accolite.chat.dao;

import com.accolite.chat.model.Group;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IGroupDao {

    public void createGroup(Group group);
    public List<Group> showAllGroups();
    public void updateGroupName(int groupID, String name);
}

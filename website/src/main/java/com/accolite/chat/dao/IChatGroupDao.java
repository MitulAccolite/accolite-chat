package com.accolite.chat.dao;

import com.accolite.chat.model.ChatGroup;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IChatGroupDao {

    void add(ChatGroup group);

    List<ChatGroup> all();

    void merge(ChatGroup group);

    ChatGroup findById(Integer id);



   /* void updateGroupName(int groupID, String name);*/
}

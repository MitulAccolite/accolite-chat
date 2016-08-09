package com.accolite.chat.dao;

import com.accolite.chat.model.ChatGroup;
import com.accolite.chat.model.Message;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IChatGroupDao {

    void add(ChatGroup group);

    List<ChatGroup> all();

    void merge(ChatGroup group);

    ChatGroup findById(Integer id);

    void addMessageToGroup(ChatGroup group, Message message);

    ChatGroup getChatGroupById(int id);

    void updateGroupNameByID(int groupID, String update);

    ChatGroup getChatGroupByName(String groupName);


   /* void updateGroupName(int groupID, String name);*/
}

package com.accolite.chat.dao;

import com.accolite.chat.model.Message;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IMessageDao {

    void save(Message message);


 /*   void sendMessage(Message message);

    void archieveMessage(int messageId, boolean archive);

    List<Message> showAllGroupMessages(int groupID);

    List<Message> showMessagesToPersonInGroup(int userID, int groupID);

    List<Message> showAllUserMessages(int userID);

    List<Message> showArchivedMessages();*/

}

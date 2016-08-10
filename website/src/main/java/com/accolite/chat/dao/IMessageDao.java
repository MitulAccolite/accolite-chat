package com.accolite.chat.dao;

import com.accolite.chat.model.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IMessageDao {

    void save(Message message);

    public List<Message> showMessagesToPersonInGroup(int userID, int groupID);

    public List<Message> pollMessagesToPersonInGroup(int userID, int groupID,Date date);

    public void archiveAllMessages(boolean archive);
    /*   void sendMessage(Message message);

    void archieveMessage(int messageId, boolean archive);

    List<Message> showAllGroupMessages(int groupID);

    List<Message> showAllUserMessages(int userID);

    List<Message> showArchivedMessages();*/

}

package com.accolite.chat.dao_interface;

import com.accolite.chat.model.Message;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface MessageDaoInterface {
    public void sendMessage(Message message);
    public void archieveMessage(int messageId, boolean archive);
    public List<Message> showAllGroupMessages(int groupID);
    public List<Message> showMessagesToPersonInGroup(int userID, int groupID);
    public List<Message> showAllUserMessages(int userID);
    public List<Message> showArchivedMessages();

}

package com.accolite.chat.controller;

import com.accolite.chat.dao.IMessageDao;
import com.accolite.chat.dao.impl.MessageDao;
import org.springframework.stereotype.Component;

/**
 * Created by Mitul Kapoor on 8/9/2016.
 */
@Component
public class RunScheduler {
    public void run(){
        System.out.println("Archiving all chats");
        IMessageDao messageDao = new MessageDao();
        messageDao.archiveAllMessages(true);
        System.out.println("Archive task completed!");
    }
}

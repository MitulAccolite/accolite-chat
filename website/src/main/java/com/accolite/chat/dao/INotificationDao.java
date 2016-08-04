package com.accolite.chat.dao;

import com.accolite.chat.model.Notification;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface INotificationDao {
    List<Notification> showAllNotifications();

    List<Notification> showNotificationsSendToId(String email);

    void postNotification(List<String> emails, String details);
}

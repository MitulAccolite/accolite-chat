package com.accolite.chat.dao;

import com.accolite.chat.model.Notification;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface INotificationDao {
    public List<Notification> showAllNotifications();
    public List<Notification> showNotificationsSendToId(String email);
    public void postNotification(List<String> emails, String details);
}

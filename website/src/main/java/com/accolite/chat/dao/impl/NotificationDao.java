package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.INotificationDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.Notification;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class NotificationDao implements INotificationDao {

    private Session session;
    private DatabaseManager databaseManager;

    public NotificationDao() {

        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public List<Notification> showAllNotifications() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Notification");
        List<Notification> resultList = q.list();
        return resultList;
    }

    public List<Notification> showNotificationsSendToId(String email) {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Notification where email =?");
        q.setString(0, email);
        List<Notification> resultList = q.list();
        return resultList;
    }

    public void postNotification(List<String> emails, String details) {
        for (int i = 0; i < emails.size(); i++) {
            Notification notification = new Notification();
            notification.setEmail(emails.get(i));
            notification.setDetails(details);
            session.beginTransaction();
            session.save(notification);
            session.getTransaction().commit();
        }
    }

}

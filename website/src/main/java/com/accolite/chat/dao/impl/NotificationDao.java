package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.INotificationDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.Notification;

import org.hibernate.HibernateException;
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
    }

    public List<Notification> showAllNotifications() {
        List<Notification> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Notification");
            resultList = q.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return resultList;
        }
    }

    public List<Notification> showNotificationsSendToId(String email) {
        List<Notification> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Notification where email =?");
            q.setString(0, email);
            resultList = q.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return resultList;
        }
    }

    public void postNotification(List<String> emails, String details) {
        try {
            session = databaseManager.getSessionFactory().openSession();
            for (int i = 0; i < emails.size(); i++) {
                Notification notification = new Notification();
                notification.setEmail(emails.get(i));
                notification.setDetails(details);
                session.beginTransaction();
                session.save(notification);
                session.getTransaction().commit();
            }
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}

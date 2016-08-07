package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.IMessageDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.ChatGroup;
import com.accolite.chat.model.Message;

import com.accolite.chat.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class MessageDao implements IMessageDao {

    private Session session;
    private DatabaseManager databaseManager;

    public MessageDao() {
        databaseManager = new DatabaseManager();
    }

    public void save(Message message) {
        try {

            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }



    public void archieveMessage(int messageId, boolean archive) {
        Transaction tx = null;
        try {

            session = databaseManager.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Message message = (Message) session.get(Message.class, messageId);
            session.update(message);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        throw new NotImplementedException();
    }

    public List<Message> showAllGroupMessages(int groupID) {
        Transaction tx = null;
        List<Message> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Message where chatGroup.id =?");
            q.setInteger(0, groupID);
            resultList = q.list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return resultList;
        }
    }

    public List<Message> showMessagesToPersonInGroup(int userID, int groupID) {
        List<Message> finalResult = new ArrayList<Message>();
        List<Message> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            User user = (new UserDao()).findUserByUserId(userID);
            Query q = session.createQuery("From Message where chatGroup.id = ?" );
            q.setInteger(0, groupID);
            if(q==null){
                System.out.println("Query result is null");
            }

            resultList =(List<Message>) q.list();
            for(Message message:resultList){
                if(message.getCreated().compareTo(user.getCreated()) > 0){
                    finalResult.add(message);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return finalResult;
        }
    }

    public List<Message> showAllUserMessages(int userID) {
        List<Message> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Message where user.id=?");
            q.setInteger(0, userID);
            resultList = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return resultList;
        }
    }

    public List<Message> showArchivedMessages() {
        List<Message> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Message where isArchived=?");
            q.setBoolean(0, true);
            resultList = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return resultList;
        }
    }
}

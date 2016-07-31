package com.accolite.chat.dao;

import com.accolite.chat.dao_interface.MessageDaoInterface;
import com.accolite.chat.database_handler.DatabaseManager;
import com.accolite.chat.model.Message;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class MessageDao implements MessageDaoInterface {

    private Session session;
    private DatabaseManager databaseManager;

    public MessageDao(){

        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public void sendMessage(Message message) {
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
    }

    public void archieveMessage(int messageId,boolean archive) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Message message = (Message) session.get(Message.class,messageId);
            message.setArchived(true);
            session.update(message);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Message> showAllGroupMessages(int groupID) {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Message where groupID =?");
        q.setInteger(0,groupID);
        List<Message> resultList = q.list();
        return resultList;
    }

    public List<Message> showMessagesToPersonInGroup(int userID, int groupID) {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Message where groupID =? and userID = ? and User.created < Message.created");
        q.setInteger(0,groupID);
        q.setInteger(1,userID);
        List<Message> resultList = q.list();
        return resultList;
    }

    public List<Message> showAllUserMessages(int userID) {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Message where userID=?");
        q.setInteger(0,userID);
        List<Message> resultList = q.list();
        return resultList;
    }

    public List<Message> showArchivedMessages() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Message where isArchived=?");
        q.setBoolean(0,true);
        List<Message> resultList = q.list();
        return resultList;
    }
}

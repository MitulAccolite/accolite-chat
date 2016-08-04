package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.IChatGroupDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.ChatGroup;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class ChatGroupDao implements IChatGroupDao {

    private Session session;
    private DatabaseManager databaseManager;

    public ChatGroupDao() {
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public void add(ChatGroup group) {
        session.beginTransaction();
        session.save(group);
        session.getTransaction().commit();
    }

    public List<ChatGroup> all() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From ChatGroup ");
        List<ChatGroup> resultList = q.list();
        return resultList;
    }

    public void merge(ChatGroup group) {
        session.beginTransaction();
        session.merge(group);
        session.getTransaction().commit();
    }

    public ChatGroup findById(Integer id) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            return (ChatGroup) session.get(ChatGroup.class, id);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            tx.commit();
           // session.close();
        }
        return null;
    }


}

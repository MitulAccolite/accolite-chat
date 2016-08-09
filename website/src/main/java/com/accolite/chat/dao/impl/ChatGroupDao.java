package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.IChatGroupDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.ChatGroup;

import com.accolite.chat.model.Message;
import com.accolite.chat.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class ChatGroupDao implements IChatGroupDao {

    private DatabaseManager databaseManager;
    private Session session;

    public ChatGroupDao() {
        databaseManager = new DatabaseManager();

    }

    public void add(ChatGroup group) {
        Session session = databaseManager.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void addMessageToGroup(ChatGroup group, Message message) {
        Session session = databaseManager.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            ChatGroup g = (ChatGroup)session.get(ChatGroup.class, group.getId());
            g.getMessages().add(message);
            session.merge(g);
            session.getTransaction().commit();
            System.out.println("added msg: "+g.getMessages());
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public ChatGroup getChatGroupById(int id) {
        Session session = databaseManager.getSessionFactory().openSession();
        ChatGroup resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From ChatGroup where id=?");
            q.setInteger(0, id);
            resultList = (ChatGroup) q.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println(resultList);
            return resultList;
        }
    }

    public List<ChatGroup> all() {
        Session session = databaseManager.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("From ChatGroup ");
            List<ChatGroup> resultList = q.list();
            session.getTransaction().commit();
            System.out.println(resultList);
            return resultList;

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void addUserToChatGroup(int groupID, User user) {
        Session session = databaseManager.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("From ChatGroup where id=?");
            q.setInteger(0, groupID);
            ChatGroup chatGroup = (ChatGroup) q.list().get(0);
            chatGroup.addUser(user);
            System.out.println("User : " + user.getFirstName() + " added to group : " + groupID);

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    public void merge(ChatGroup group) {
        Session session = databaseManager.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(group);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ChatGroup findById(Integer id) {
        session = databaseManager.getSessionFactory().openSession();
        Transaction tx = null;
        ChatGroup chatGroup = null;
        try {
            tx = session.beginTransaction();
            chatGroup = (ChatGroup) session.get(ChatGroup.class, id);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
            System.out.println(chatGroup);
            return chatGroup;
        }
    }


    public ChatGroup getDefaultChatGroup() {
        session = databaseManager.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ChatGroup chatGroup=(ChatGroup) session.get(ChatGroup.class, 1);
            System.out.println(chatGroup);
            return chatGroup;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void updateGroupNameByID(int groupID, String update) {
        Session session = databaseManager.getSessionFactory().openSession();
        ChatGroup chatGroup = null;
        Transaction tx=null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Query q = session.createQuery("From ChatGroup where id=?");
            q.setInteger(0, groupID);
            chatGroup = (ChatGroup) q.list().get(0);
            chatGroup.setName(update);
            session.update(chatGroup);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

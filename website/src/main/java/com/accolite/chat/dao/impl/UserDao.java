package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.IChatGroupDao;
import com.accolite.chat.dao.IUserDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.ChatGroup;
import com.accolite.chat.model.Credential;
import com.accolite.chat.model.Role;
import com.accolite.chat.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class UserDao implements IUserDao {

    private Session session;
    private DatabaseManager databaseManager;

    public UserDao() {
        databaseManager = new DatabaseManager();
    }


    public void add(User user) {
        try {
            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void add (Credential credential){
        try {
            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(credential);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    public void add(Role role) {
        try {
            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    public Role findRoleByName(String role) {
        Role result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Role where role = ?");
            q.setString(0, role);
            result = (Role) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }


    public void addNewUser(User user) {
        try {
            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            ChatGroup chatGroup = (new ChatGroupDao()).getDefaultChatGroup();
            ChatGroup g = (ChatGroup)session.get(ChatGroup.class, chatGroup.getId());
            g.getUsers().add(user);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public User findUserByUserId(int userID) {
        User result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where id = ?");
            q.setInteger(0, userID);
            result = (User) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }

    public User findUserByUsername(String username) {
        User result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where firstName = ?");
            q.setString(0, username);
            result = (User) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }

    public User findUserByEmail(String email) {
        User result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where email = ?");
            q.setString(0, email);
            result = (User) q.list().get(0);
            System.out.println(result);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }

    public int getUserId(String email) {
        User result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where email = ?");
            q.setString(0, email);
            result = (User) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result.getId();
        }
    }

    public User allGroupsForUser(String username) {
        User result = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where email = ?");
            q.setString(0, username);
            result = (User) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }

    public List<User> showAllUsers() {
        List<User> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User");
            resultList = q.list();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return resultList;
        }
    }

    public User findUserByNickname(String nickname) {
        User result  = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From User where nickName = ?");
            q.setString(0, nickname);
            result = (User) q.list().get(0);
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return result;
        }
    }

    public void updateUserUsingId(int userID, String fname, String lname, String mname, String email, String nickname) {
        Transaction tx = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            tx = session.beginTransaction();
            User user1 = (User) session.get(User.class, userID);
            user1.setFirstName(fname);
            user1.setLastName(lname);
            user1.setMiddleName(mname);
            user1.setEmail(email);
            user1.setNickName(nickname);
            session.update(user1);
            tx.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void setUserInActive(int userID, boolean activeState) {
        Transaction tx = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            tx = session.beginTransaction();
            User user1 = (User) session.get(User.class, userID);
            user1.setActive(activeState);
            session.update(user1);
            tx.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
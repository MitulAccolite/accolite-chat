package com.accolite.chat.dao;

import com.accolite.chat.dao_interface.UserDaoInterface;
import com.accolite.chat.database_handler.DatabaseManager;
import com.accolite.chat.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class UserDao implements UserDaoInterface {

    private Session session;
    private DatabaseManager databaseManager;

    public UserDao(){

        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }


    public void addNewUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public User findUserByUserId(int userID) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From User where id = ?");
        q.setInteger(0, userID);
        User result = (User) q.list().get(0);
        return result;
    }

    public User findUserByUsername(String username) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From User where firstName = ?");
        q.setString(0, username);
        User result = (User) q.list().get(0);
        return result;
    }

    public User findUserByEmail(String email) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From User where email = ?");
        q.setString(0, email);
        User result = (User) q.list().get(0);
        return result;
    }


    public List<User> showAllUsers() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From User");
        List<User> resultList = q.list();
        return resultList;
    }

    public User findUserByNickname(String nickname) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From User where nickName = ?");
        q.setString(0, nickname);
        User result = (User) q.list().get(0);
        return result;
    }

    public void updateUserUsingId(int userID, String fname,String lname,String mname,String email,String nickname) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            User user1 = (User) session.get(User.class,userID);
            user1.setFirstName(fname);
            user1.setLastName(lname);
            user1.setMiddleName(mname);
            user1.setEmail(email);
            user1.setNickName(nickname);
            session.update(user1);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void setUserInActive(int userID,boolean activeState) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            User user1 = (User) session.get(User.class,userID);
            user1.setActive(activeState);
            session.update(user1);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

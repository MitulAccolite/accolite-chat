package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.ILoginCredentialsDao;
import com.accolite.chat.dao.manager.DatabaseManager;

import com.accolite.chat.model.Credential;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class LoginCredentialsDao implements ILoginCredentialsDao {


    private Session session;
    private DatabaseManager databaseManager;

    public LoginCredentialsDao() {
        databaseManager = new DatabaseManager();
    }

    public void updateUserPassword(int userID, String password) {
        Transaction tx = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Credential loginCredentials = (Credential) session.get(Credential.class, userID);
            loginCredentials.setPassword(password);
            session.update(loginCredentials);
            tx.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateUserName(int userID, String username) {
        Transaction tx = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Credential loginCredentials = (Credential) session.get(Credential.class, userID);
            loginCredentials.setUsername(username);
            session.update(loginCredentials);
            tx.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public void addUser(Credential credential) {
        try {
            session = databaseManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(credential);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Credential> showAllCredentials() {
        List<Credential> resultList = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Credential ");
            resultList = q.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            System.out.println(resultList);
            return resultList;
        }
    }

    public Credential verifyCredentials(String username, String password) {
        List<Credential> user = null;
        try {
            session = databaseManager.getSessionFactory().openSession();
            Query q = session.createQuery("From Credential where username = ? and password = ?");
            q.setString(0, username);
            q.setString(1, password);
            user = (List<Credential>) q.list();
            System.out.println(user.get(0));
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            if(user.size()>0){
                return (Credential) user.get(0);
            }
            return null;
        }
    }

   /* private Session session;
    private DatabaseManager databaseManager;

    public LoginCredentialsDao() {
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }



    public void updateUserPassword(int userID, String password) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            LoginCredentials loginCredentials = (LoginCredentials) session.get(LoginCredentials.class, userID);
            loginCredentials.setPassword(password);
            session.update(loginCredentials);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUserName(int userID, String username) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            LoginCredentials loginCredentials = (LoginCredentials) session.get(LoginCredentials.class, userID);
            loginCredentials.setUsername(username);
            session.update(loginCredentials);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addUser(LoginCredentials loginCredentials) {
        session.beginTransaction();
        session.save(loginCredentials);
        session.getTransaction().commit();
    }

    public List<LoginCredentials> showAllCredentials() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From LoginCredentials ");
        List<LoginCredentials> resultList = q.list();
        return resultList;
    }

    public LoginCredentials verifyCredentials(String username, String password) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From LoginCredentials where username = ? and password = ?");
        q.setString(0, username);
        q.setString(1, password);
        List user = (List<LoginCredentials>) q.list();
        //int user =  q.list().size();
        if(user.size()>0){
            return (LoginCredentials) user.get(0);
        }
        return null;
    }
*/
}

package com.accolite.chat.dao;

import com.accolite.chat.dao_interface.LoginCredentialsDaoInterface;
import com.accolite.chat.database_handler.DatabaseManager;
import com.accolite.chat.model.LoginCredentials;
import com.accolite.chat.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class LoginCredentialsDao implements LoginCredentialsDaoInterface {

    private Session session;
    private DatabaseManager databaseManager;

    public LoginCredentialsDao(){
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public void updateUserPassword(int userID, String password) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            LoginCredentials loginCredentials = (LoginCredentials) session.get(LoginCredentials.class,userID);
            loginCredentials.setPassword(password);
            session.update(loginCredentials);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateUserName(int userID, String username) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            LoginCredentials loginCredentials = (LoginCredentials) session.get(LoginCredentials.class,userID);
            loginCredentials.setUsername(username);
            session.update(loginCredentials);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
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
        q.setString(0,username);
        q.setString(1,password);
        LoginCredentials user = (LoginCredentials) q.list().get(0);
        //int user =  q.list().size();
        if(user!=null){
            return user;
        }
        return null;
    }
}

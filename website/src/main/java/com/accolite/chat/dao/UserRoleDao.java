package com.accolite.chat.dao;

import com.accolite.chat.dao_interface.UserRoleDaoInterface;
import com.accolite.chat.database_handler.DatabaseManager;
import com.accolite.chat.model.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class UserRoleDao implements UserRoleDaoInterface {


    private Session session;
    private DatabaseManager databaseManager;

    public UserRoleDao(){
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public UserRole getUserRole(int userID) {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From UserRole where userID= ?");
        q.setInteger(0, userID);
        UserRole result = (UserRole) q.list().get(0);
        return result;
    }

    public void addUserRole(int userID, String role) {
        UserRole userRole = new UserRole(userID,role);
        session.beginTransaction();
        session.save(userRole);
        session.getTransaction().commit();
    }

    public List<UserRole> showAllUserRoles() {
        session.getSessionFactory().openSession();
        Query q = session.createQuery("From UserRole");
        List<UserRole> result = q.list();
        return result;
    }
}

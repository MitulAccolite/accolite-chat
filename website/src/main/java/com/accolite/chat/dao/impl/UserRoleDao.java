package com.accolite.chat.dao.impl;

import com.accolite.chat.dao.IUserRoleDao;
import com.accolite.chat.dao.manager.DatabaseManager;
import com.accolite.chat.model.Role;

import org.hibernate.Session;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class UserRoleDao implements IUserRoleDao {


    private Session session;
    private DatabaseManager databaseManager;

    public UserRoleDao() {
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public Role getUserRole(int userID) {
      /*  session.getSessionFactory().openSession();
        Query q = session.createQuery("From UserRole where userID= ?");
        q.setInteger(0, userID);
        UserRole result = (UserRole) q.list().get(0);
        return result;*/

        throw new NotImplementedException();
    }

    public void addUserRole(int userID, String role) {
      /*  UserRole userRole = new UserRole(userID, role);
        session.beginTransaction();
        session.save(userRole);
        session.getTransaction().commit();*/
    }

    public List<Role> showAllUserRoles() {
       /* session.getSessionFactory().openSession();
        Query q = session.createQuery("From UserRole");
        List<UserRole> result = q.list();
        return result;*/
        throw new NotImplementedException();
    }
}

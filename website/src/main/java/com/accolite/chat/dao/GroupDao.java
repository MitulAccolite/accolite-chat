package com.accolite.chat.dao;

import com.accolite.chat.dao_interface.GroupDaoInterface;
import com.accolite.chat.database_handler.DatabaseManager;
import com.accolite.chat.model.Group;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public class GroupDao implements GroupDaoInterface {

    private Session session;
    private DatabaseManager databaseManager;
    public GroupDao(){
        databaseManager = new DatabaseManager();
        session = databaseManager.getSessionFactory().openSession();
    }

    public void createGroup(Group group) {
        session.beginTransaction();
        session.save(group);
        session.getTransaction().commit();
    }

    public List<Group> showAllGroups() {
        session = databaseManager.getSessionFactory().openSession();
        Query q = session.createQuery("From Group ");
        List<Group> resultList = q.list();
        return resultList;
    }

    public void updateGroupName(int groupID,String name) {
        session.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Group group = (Group) session.get(Group.class,groupID);
            group.setGroupName(name);
            session.update(group);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

package com.accolite.chat.dao;

import com.accolite.chat.model.Role;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IUserRoleDao {
    Role getUserRole(int userID);

    void addUserRole(int userID, String role);

    List<Role> showAllUserRoles();

}

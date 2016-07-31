package com.accolite.chat.dao_interface;

import com.accolite.chat.model.UserRole;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface UserRoleDaoInterface {
    public UserRole getUserRole(int userID);
    public void addUserRole(int userID, String role);
    public List<UserRole> showAllUserRoles();

}

package com.accolite.chat.dao;

import com.accolite.chat.model.Credential;
import com.accolite.chat.model.Role;
import com.accolite.chat.model.User;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IUserDao {

    void add(Credential credential);

    void add(User user);

    void add(Role role);

    Role findRoleByName(String role);
    User findUserByEmail(String email);

/*
    User findUserByNickname(String nickname);

    User findUserByEmail(String email);


    //TODO: needs to be reviewd

    User findUserByUserId(int userId);

    User findUserByUsername(String username);

    List<User> showAllUsers();

    void updateUserUsingId(int userID, String fname, String lname, String mname, String email, String nickname);

    void setUserInActive(int userID, boolean activeState);*/


}

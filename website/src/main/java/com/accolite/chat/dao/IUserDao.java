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

    List<User> listAddUsers();
    Role findRoleByName(String role);
    User findUserByEmail(String email);
    void updateFirstNameByEmail(String email,String update);
    void updateMiddleNameByEmail(String email,String update);
    void updateLastNameByEmail(String email,String update);
    void updateNickNameByEmail(String email,String update);

    User findUserByUserId(int id);

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

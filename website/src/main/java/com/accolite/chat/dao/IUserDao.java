package com.accolite.chat.dao;

import com.accolite.chat.model.User;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface IUserDao {

    void addNewUser(User user);

    User findUserByUserId(int userID);

    User findUserByUsername(String username);

    List<User> showAllUsers();

    User findUserByNickname(String nickname);

    void updateUserUsingId(int userID, String fname, String lname, String mname, String email, String nickname);

    void setUserInActive(int userID, boolean activeState);

    User findUserByEmail(String email);

}

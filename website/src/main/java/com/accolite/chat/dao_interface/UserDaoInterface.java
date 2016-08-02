package com.accolite.chat.dao_interface;

import com.accolite.chat.model.User;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface UserDaoInterface {

    public void addNewUser(User user);
    public User findUserByUserId(int userID);
    public User findUserByUsername(String username);
    public List<User> showAllUsers();
    public User findUserByNickname(String nickname);
    public void updateUserUsingId(int userID, String fname, String lname, String mname, String email, String nickname);
    public void setUserInActive(int userID, boolean activeState);
    public User findUserByEmail(String email);

}

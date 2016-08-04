package com.accolite.chat.dao;

import com.accolite.chat.model.LoginCredentials;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface ILoginCredentialsDao {

    void updateUserPassword(int userID, String password);

    void updateUserName(int userID, String username);

    void addUser(LoginCredentials loginCredentials);

    List<LoginCredentials> showAllCredentials();

    LoginCredentials verifyCredentials(String username, String password);
}

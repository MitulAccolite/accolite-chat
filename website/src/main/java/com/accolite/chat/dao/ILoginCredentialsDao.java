package com.accolite.chat.dao;

import com.accolite.chat.model.Credential;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface ILoginCredentialsDao {

    void updateUserPassword(int userID, String password);

    void updateUserName(int userID, String username);

    void addUser(Credential credential);

    List<Credential> showAllCredentials();

    Credential verifyCredentials(String username, String password);
}

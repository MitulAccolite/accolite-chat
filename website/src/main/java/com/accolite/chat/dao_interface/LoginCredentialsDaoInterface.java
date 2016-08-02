package com.accolite.chat.dao_interface;

import com.accolite.chat.model.LoginCredentials;
import com.accolite.chat.model.User;

import java.util.List;

/**
 * Created by Mitul Kapoor on 7/30/2016.
 */
public interface LoginCredentialsDaoInterface {

    public void updateUserPassword(int userID, String password);
    public void updateUserName(int userID, String username);
    public void addUser(LoginCredentials loginCredentials);
    public List<LoginCredentials> showAllCredentials();
    public LoginCredentials verifyCredentials(String username, String password);

}

package com.accolite.chat.forms;

/**
 * Created by Mitul Kapoor on 8/1/2016.
 */
public class RegistrationForm {
    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String number;

    public RegistrationForm(){
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getNumber() {
        return number;
    }
}

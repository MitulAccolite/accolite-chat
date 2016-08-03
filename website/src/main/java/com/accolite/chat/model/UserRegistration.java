package com.accolite.chat.model;

/**
 * Created by Mitul Kapoor on 8/2/2016.
 */
public class UserRegistration {
    private String userMail;
    private String userPassword;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String userMobile;

    public UserRegistration(){

    }

    public UserRegistration(String email,String pass,String fname,String mname,String lname,String nickName,String no){
        this.userMail = email;
        this.userPassword = pass;
        this.firstName = fname;
        this.middleName = mname;
        this.lastName = lname;
        this.nickName = nickName;
        this.userMobile = no;
    }

    public String toString(){
        return "First Name : " + firstName + ", Middle Name : " + middleName +  ", Last Name : "+ lastName +
                ", Nick name : " + nickName + ", mobile : " + userMobile + ", password : " + userPassword;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
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

    public String getUserMobile() {
        return userMobile;
    }
}

package com.accolite.chat.model;

/**
 * Created by Lokesh K on 10 Aug 2016.
 */
public class GMessage {
    public GMessage(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String message;
    private Long created;
    private String email;

    public GMessage(String message, Long created, String email, String nickName) {
        this.message = message;
        this.created = created;
        this.email = email;
        this.nickName = nickName;
    }

    private String nickName;

}

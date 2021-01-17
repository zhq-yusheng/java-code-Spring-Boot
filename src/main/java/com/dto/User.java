package com.dto;

public class User {
    private String id;
    private String user;
    private String phoneId;

    public User() {
    }

    public User(String id, String user, String phoneId) {
        this.id = id;
        this.user = user;
        this.phoneId = phoneId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }


}

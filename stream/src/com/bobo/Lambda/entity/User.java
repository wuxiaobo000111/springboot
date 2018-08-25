package com.bobo.Lambda.entity;

/**
 * Created by bobo on 2018/8/25/9:32.
 */
public class User {

    private Integer id;

    private String userName;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public User() {
    }

    public User(String userName, Integer id) {
        this.id = id;
        this.userName = userName;
    }
}

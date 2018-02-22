package com.lynda.training.db.beans;

/**
 * Created by juan.hernandez on 2/20/18.
 */
public class Admin {
    private int AdminId;
    private String userName;
    private String password;

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

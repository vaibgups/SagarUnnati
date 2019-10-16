package com.example.sagarunnati.model.registration;

import com.google.gson.annotations.SerializedName;

public class SignInModel {

    @SerializedName("userName")
    private String userName;

    @SerializedName("userId")
    private String userId;

    @SerializedName("password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

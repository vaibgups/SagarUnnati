package com.example.sagarunnati.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestParameter implements Serializable {
    private String select_fy;
    private int select_month;
    private int PortId;
    private String selectedMonthName;
    private String  loginEmail, loginPassword, accessToken;
    private Map<String,String> hashMap = new HashMap<>();


    public void setSelect_fy(String select_fy) {
        this.select_fy = select_fy;
        hashMap.put("select_fy", select_fy);
    }

    public String getSelect_fy() {
        return select_fy;
    }

    public void setSelect_month(int select_month) {
        this.select_month = select_month;
        hashMap.put("select_month", String.valueOf(select_month));
    }

    public int getSelect_month() {
        return select_month;
    }

    public void setPortId(int portId) {
        PortId = portId;
        hashMap.put("PortId",String.valueOf(PortId));
    }

    public int getPortId() {
        return PortId;
    }

    public void setSelectedMonthName(String selectedMonthName) {
        this.selectedMonthName = selectedMonthName;
    }

    public String getSelectedMonthName() {
        return selectedMonthName;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
        hashMap.put("login_email",String.valueOf(loginEmail));
    }

    public String getLoginEmail() {
        return loginEmail;
    }


    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        hashMap.put("login_password",String.valueOf(loginPassword));
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        hashMap.put("Authorization", "Bearer " + accessToken);
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "RequestParameter{" +
                "select_fy='" + select_fy + '\'' +
                ", select_month=" + select_month +
                ", PortId=" + PortId +
                ", selectedMonthName='" + selectedMonthName + '\'' +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", hashMap=" + hashMap +
                '}';
    }
}

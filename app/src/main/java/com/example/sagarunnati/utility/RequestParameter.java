package com.example.sagarunnati.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestParameter implements Serializable {
    private String FinancialYear;
    private int fy_month;
    private int PortId;
    private String selectedMonth;
    private String  loginEmail, loginPassword, accessToken;
    private Map<String,String> hashMap = new HashMap<>();

    public String getFinancialYear() {
        return FinancialYear;
    }

    public void setFinancialYear(String financialYear) {
        FinancialYear = financialYear;
        hashMap.put("FinancialYear",financialYear);
    }

    public int getFy_month() {
        return fy_month;
    }

    public void setFy_month(int fy_month) {
        this.fy_month = fy_month;
        hashMap.put("fy_month",String.valueOf(fy_month));
    }

    public void setPortId(int portId) {
        PortId = portId;
        hashMap.put("PortId",String.valueOf(PortId));
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
        hashMap.put("login_email",String.valueOf(loginEmail));
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        hashMap.put("login_password",String.valueOf(loginPassword));
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        hashMap.put("Authorization", "Bearer " + accessToken);
    }

    @Override
    public String toString() {
        return "RequestParameter{" +
                "FinancialYear='" + FinancialYear + '\'' +
                ", fy_month=" + fy_month +
                ", PortId=" + PortId +
                ", selectedMonth='" + selectedMonth + '\'' +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", hashMap=" + hashMap +
                '}';
    }
}

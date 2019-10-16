package com.example.sagarunnati.model.about;

import com.google.gson.annotations.SerializedName;

public class AboutUsModel {

    @SerializedName("aboutUsMessage")
    private String aboutUsMessage;

    @SerializedName("statusCode")
    private String statusCode;

    @SerializedName("statusMessage")
    private String statusMessage;


    public String getAboutUsMessage() {
        return aboutUsMessage;
    }

    public void setAboutUsMessage(String aboutUsMessage) {
        this.aboutUsMessage = aboutUsMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}

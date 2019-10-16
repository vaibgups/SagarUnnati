package com.example.sagarunnati.model.gallery;

import com.google.gson.annotations.SerializedName;

public class GalleryModel {

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("statusCode")
    private String statusCode;

    @SerializedName("statusMessage")
    private String statusMessage;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

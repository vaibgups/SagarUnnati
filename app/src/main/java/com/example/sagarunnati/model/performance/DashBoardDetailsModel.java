package com.example.sagarunnati.model.performance;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DashBoardDetailsModel implements Serializable {

    @SerializedName("headingTitle")
    private String headingTitle;
    @SerializedName("subHeadingTitle1")
    private String subHeadingTitle1;
    @SerializedName("subHeadingTitle2")
    private String subHeadingTitle2;
    @SerializedName("detailsUrl")
    private String detailsUrl;

    public String getHeadingTitle() {
        return headingTitle;
    }

    public void setHeadingTitle(String headingTitle) {
        this.headingTitle = headingTitle;
    }

    public String getSubHeadingTitle1() {
        return subHeadingTitle1;
    }

    public void setSubHeadingTitle1(String subHeadingTitle1) {
        this.subHeadingTitle1 = subHeadingTitle1;
    }

    public String getSubHeadingTitle2() {
        return subHeadingTitle2;
    }

    public void setSubHeadingTitle2(String subHeadingTitle2) {
        this.subHeadingTitle2 = subHeadingTitle2;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }
}

package com.example.sagarunnati.model.daily_vessel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DailyVesselResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("data")
    private List<DailyVesselDataItem> data;

    @SerializedName("latest_date")
    private String latestDate;

    @SerializedName("status")
    private boolean status;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setData(List<DailyVesselDataItem> data) {
        this.data = data;
    }

    public List<DailyVesselDataItem> getData() {
        return data;
    }

    public void setLatestDate(String latestDate) {
        this.latestDate = latestDate;
    }

    public String getLatestDate() {
        return latestDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "DailyVesselResponse{" +
                        "msg = '" + msg + '\'' +
                        ",status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",latest_date = '" + latestDate + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
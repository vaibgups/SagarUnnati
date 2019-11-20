package com.example.sagarunnati.model.traffic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrafficResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("data")
    private List<TrafficDataItem> data;

    @SerializedName("latest_date")
    private LatestDate latestDate;

    @SerializedName("total_traffic")
    private int totalTraffic;

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

    public void setData(List<TrafficDataItem> data) {
        this.data = data;
    }

    public List<TrafficDataItem> getData() {
        return data;
    }

    public void setLatestDate(LatestDate latestDate) {
        this.latestDate = latestDate;
    }

    public LatestDate getLatestDate() {
        return latestDate;
    }

    public void setTotalTraffic(int totalTraffic) {
        this.totalTraffic = totalTraffic;
    }

    public int getTotalTraffic() {
        return totalTraffic;
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
                "TrafficResponse{" +
                        "msg = '" + msg + '\'' +
                        ",status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",latest_date = '" + latestDate + '\'' +
                        ",total_traffic = '" + totalTraffic + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
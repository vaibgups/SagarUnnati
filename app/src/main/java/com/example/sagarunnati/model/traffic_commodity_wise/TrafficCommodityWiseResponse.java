package com.example.sagarunnati.model.traffic_commodity_wise;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrafficCommodityWiseResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("data_sum")
    private DataSum dataSum;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("data")
    private List<TrafficCommodityWiseDataItem> data;

    @SerializedName("latest_date")
    private LatestDate latestDate;

    @SerializedName("total_variation")
    private String totalVariation;

    @SerializedName("total_prev_traffic")
    private int totalPrevTraffic;

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

    public void setDataSum(DataSum dataSum) {
        this.dataSum = dataSum;
    }

    public DataSum getDataSum() {
        return dataSum;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setData(List<TrafficCommodityWiseDataItem> data) {
        this.data = data;
    }

    public List<TrafficCommodityWiseDataItem> getData() {
        return data;
    }

    public void setLatestDate(LatestDate latestDate) {
        this.latestDate = latestDate;
    }

    public LatestDate getLatestDate() {
        return latestDate;
    }

    public void setTotalVariation(String totalVariation) {
        this.totalVariation = totalVariation;
    }

    public String getTotalVariation() {
        return totalVariation;
    }

    public void setTotalPrevTraffic(int totalPrevTraffic) {
        this.totalPrevTraffic = totalPrevTraffic;
    }

    public int getTotalPrevTraffic() {
        return totalPrevTraffic;
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
                "TrafficCommodityWiseResponse{" +
                        "msg = '" + msg + '\'' +
                        ",data_sum = '" + dataSum + '\'' +
                        ",status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",latest_date = '" + latestDate + '\'' +
                        ",total_variation = '" + totalVariation + '\'' +
                        ",total_prev_traffic = '" + totalPrevTraffic + '\'' +
                        ",total_traffic = '" + totalTraffic + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
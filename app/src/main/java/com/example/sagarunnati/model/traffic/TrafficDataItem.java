package com.example.sagarunnati.model.traffic;

import com.google.gson.annotations.SerializedName;

public class TrafficDataItem {

    @SerializedName("port_name")
    private String portName;

    @SerializedName("port_id")
    private String portId;

    @SerializedName("total_sum")
    private int totalSum;

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getPortId() {
        return portId;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return
                "TrafficDataItem{" +
                        "port_name = '" + portName + '\'' +
                        ",port_id = '" + portId + '\'' +
                        ",total_sum = '" + totalSum + '\'' +
                        "}";
    }
}
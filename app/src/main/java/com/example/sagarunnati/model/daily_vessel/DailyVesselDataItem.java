package com.example.sagarunnati.model.daily_vessel;

import com.google.gson.annotations.SerializedName;

public class DailyVesselDataItem {

    @SerializedName("port_name")
    private String portName;

    @SerializedName("at_berth")
    private String atBerth;

    @SerializedName("at_anchor")
    private String atAnchor;

    @SerializedName("port_id")
    private String portId;

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }

    public void setAtBerth(String atBerth) {
        this.atBerth = atBerth;
    }

    public String getAtBerth() {
        return atBerth;
    }

    public void setAtAnchor(String atAnchor) {
        this.atAnchor = atAnchor;
    }

    public String getAtAnchor() {
        return atAnchor;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getPortId() {
        return portId;
    }

    @Override
    public String toString() {
        return
                "DailyVesselDataItem{" +
                        "port_name = '" + portName + '\'' +
                        ",at_berth = '" + atBerth + '\'' +
                        ",at_anchor = '" + atAnchor + '\'' +
                        ",port_id = '" + portId + '\'' +
                        "}";
    }
}
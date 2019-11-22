package com.example.sagarunnati.model.project_under_sagarmala;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectUnderSagarmalaResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("data")
    private List<ProjectUnderSagarmalaDataItem> data;

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

    public void setData(List<ProjectUnderSagarmalaDataItem> data) {
        this.data = data;
    }

    public List<ProjectUnderSagarmalaDataItem> getData() {
        return data;
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
                "ProjectUnderSagarmalaResponse{" +
                        "msg = '" + msg + '\'' +
                        ",status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
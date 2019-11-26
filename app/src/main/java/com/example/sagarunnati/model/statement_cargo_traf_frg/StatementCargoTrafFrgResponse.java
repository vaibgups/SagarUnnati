package com.example.sagarunnati.model.statement_cargo_traf_frg;


import com.google.gson.annotations.SerializedName;

public class StatementCargoTrafFrgResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("data")
    private String data;

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

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
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
                "StatementCargoTrafFrgResponse{" +
                        "msg = '" + msg + '\'' +
                        ",status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
package com.example.sagarunnati.model.sagarmala_beneficiaries;

import com.google.gson.annotations.SerializedName;

public class SgarmalaBeneficiariesDataItem {

    @SerializedName("title")
    private String title;

    @SerializedName("value")
    private String value;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return
                "SgarmalaBeneficiariesDataItem{" +
                        "title = '" + title + '\'' +
                        ",value = '" + value + '\'' +
                        "}";
    }
}
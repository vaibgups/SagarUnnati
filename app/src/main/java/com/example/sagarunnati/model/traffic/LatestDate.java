package com.example.sagarunnati.model.traffic;

import com.google.gson.annotations.SerializedName;

public class LatestDate {

    @SerializedName("fin_month")
    private String finMonth;

    @SerializedName("fin_year")
    private String finYear;

    public void setFinMonth(String finMonth) {
        this.finMonth = finMonth;
    }

    public String getFinMonth() {
        return finMonth;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    public String getFinYear() {
        return finYear;
    }

    @Override
    public String toString() {
        return
                "LatestDate{" +
                        "fin_month = '" + finMonth + '\'' +
                        ",fin_year = '" + finYear + '\'' +
                        "}";
    }
}
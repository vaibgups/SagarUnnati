package com.example.sagarunnati.model.traffic_commodity_wise;

import com.google.gson.annotations.SerializedName;

public class LatestDate {

    @SerializedName("fin_month")
    private String finMonth;

    @SerializedName("month_name")
    private String monthName;

    @SerializedName("fin_year")
    private String finYear;

    public void setFinMonth(String finMonth) {
        this.finMonth = finMonth;
    }

    public String getFinMonth() {
        return finMonth;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
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
                        ",month_name = '" + monthName + '\'' +
                        ",fin_year = '" + finYear + '\'' +
                        "}";
    }
}
package com.example.sagarunnati.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestParameter implements Serializable {
    private String FinancialYear;
    private int fy_month;
    private int PortId;
    private String selectedMonth;
    private Map<String,String> hashMap = new HashMap<>();

    public String getFinancialYear() {
        return FinancialYear;
    }

    public void setFinancialYear(String financialYear) {
        FinancialYear = financialYear;
        hashMap.put("FinancialYear",financialYear);
    }

    public int getFy_month() {
        return fy_month;
    }

    public void setFy_month(int fy_month) {
        this.fy_month = fy_month;
        hashMap.put("fy_month",String.valueOf(fy_month));
    }

    public void setPortId(int portId) {
        PortId = portId;
        hashMap.put("PortId",String.valueOf(PortId));
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }


}

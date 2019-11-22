package com.example.sagarunnati.model.project_under_sagarmala;

import com.google.gson.annotations.SerializedName;

public class ProjectUnderSagarmalaDataItem {

    @SerializedName("project_values")
    private String projectValues;

    @SerializedName("programme_name")
    private String programmeName;

    @SerializedName("project_cost")
    private String projectCost;

    public void setProjectValues(String projectValues) {
        this.projectValues = projectValues;
    }

    public String getProjectValues() {
        return projectValues;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProjectCost(String projectCost) {
        this.projectCost = projectCost;
    }

    public String getProjectCost() {
        return projectCost;
    }

    @Override
    public String toString() {
        return
                "ProjectUnderSagarmalaDataItem{" +
                        "project_values = '" + projectValues + '\'' +
                        ",programme_name = '" + programmeName + '\'' +
                        ",project_cost = '" + projectCost + '\'' +
                        "}";
    }
}
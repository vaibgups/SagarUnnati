package com.example.sagarunnati.model.yearMonth;

import com.google.gson.annotations.SerializedName;

public class FinancialMonthItem{

	@SerializedName("fy_month_name")
	private String fyMonthName;

	@SerializedName("fy_month_num")
	private String fyMonthNum;

	public void setFyMonthName(String fyMonthName){
		this.fyMonthName = fyMonthName;
	}

	public String getFyMonthName(){
		return fyMonthName;
	}

	public void setFyMonthNum(String fyMonthNum){
		this.fyMonthNum = fyMonthNum;
	}

	public String getFyMonthNum(){
		return fyMonthNum;
	}

	@Override
 	public String toString(){
		return 
			"FinancialMonthItem{" + 
			"fy_month_name = '" + fyMonthName + '\'' + 
			",fy_month_num = '" + fyMonthNum + '\'' + 
			"}";
		}
}
package com.example.sagarunnati.model.yearMonth;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MasterData{

	@SerializedName("financial_year")
	private List<String> financialYear;

	@SerializedName("financial_month")
	private List<FinancialMonthItem> financialMonth;

	public void setFinancialYear(List<String> financialYear){
		this.financialYear = financialYear;
	}

	public List<String> getFinancialYear(){
		return financialYear;
	}

	public void setFinancialMonth(List<FinancialMonthItem> financialMonth){
		this.financialMonth = financialMonth;
	}

	public List<FinancialMonthItem> getFinancialMonth(){
		return financialMonth;
	}

	@Override
 	public String toString(){
		return 
			"MasterData{" + 
			"financial_year = '" + financialYear + '\'' + 
			",financial_month = '" + financialMonth + '\'' + 
			"}";
		}
}
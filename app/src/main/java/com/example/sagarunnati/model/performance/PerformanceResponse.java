package com.example.sagarunnati.model.performance;

import com.google.gson.annotations.SerializedName;

public class PerformanceResponse{

	@SerializedName("content_one")
	private String contentOne;

	@SerializedName("content_two")
	private String contentTwo;

	@SerializedName("financial_year")
	private String financialYear;

	@SerializedName("title")
	private String title;

	public void setContentOne(String contentOne){
		this.contentOne = contentOne;
	}

	public String getContentOne(){
		return contentOne;
	}

	public void setContentTwo(String contentTwo){
		this.contentTwo = contentTwo;
	}

	public String getContentTwo(){
		return contentTwo;
	}

	public void setFinancialYear(String financialYear){
		this.financialYear = financialYear;
	}

	public String getFinancialYear(){
		return financialYear;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"PerformanceResponse{" + 
			"content_one = '" + contentOne + '\'' + 
			",content_two = '" + contentTwo + '\'' + 
			",financial_year = '" + financialYear + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}